
package com.eunsong.clothingmatcherbycamera.camera

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.ImageFormat
import android.graphics.SurfaceTexture
import android.hardware.Camera
import android.hardware.Camera.PreviewCallback
import android.util.Log
import android.view.Surface
import android.view.SurfaceHolder
import android.view.WindowManager
import androidx.annotation.RequiresPermission
import com.eunsong.clothingmatcherbycamera.model.FrameMetadata
import com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay
import com.eunsong.clothingmatcherbycamera.util.PreferenceUtils
import com.eunsong.clothingmatcherbycamera.vision.VisionImageProcessor
import com.google.android.gms.common.images.Size
import timber.log.Timber
import java.io.IOException
import java.nio.ByteBuffer
import java.util.*
import kotlin.math.ceil

/**
 * Manages the camera and allows UI updates on top of it (e.g. overlaying extra Graphics or
 * displaying extra information). This receives preview frames from the camera at a specified rate,
 * sending those frames to child classes' detectors / classifiers as fast as it is able to process.
 */
@SuppressLint("MissingPermission")
class CameraSource1(
        protected var activity: Activity,
        var graphicOverlay: GraphicOverlay) {
    var camera: Camera? = null
    /**
     * Returns the selected camera; one of [.CAMERA_FACING_BACK] or [ ][.CAMERA_FACING_FRONT].
     */
    var cameraFacing = CAMERA_FACING_FRONT
        private set
    /**
     * Rotation of the device, and thus the associated preview images captured from the device. See
     * Frame.Metadata#getRotation().
     */
    private var rotation = 0
    /** Returns the preview size that is currently in use by the underlying camera.  */
    var previewSize: Size? = null
        private set
    private val requestedFps = 30.0f
    private val requestedAutoFocus = true
    // These instances need to be held onto to avoid GC of their underlying resources.  Even though
    // these aren't used outside of the method that creates them, they still must have hard
    // references maintained to them.
    private var dummySurfaceTexture: SurfaceTexture? = null
    // True if a SurfaceTexture is being used for the preview, false if a SurfaceHolder is being
    // used for the preview.  We want to be compatible back to Gingerbread, but SurfaceTexture
    // wasn't introduced until Honeycomb.  Since the interface cannot use a SurfaceTexture, if the
    // developer wants to display a preview we must use a SurfaceHolder.  If the developer doesn't
    // want to display a preview we use a SurfaceTexture if we are running at least Honeycomb.
    private var usingSurfaceTexture = false
    /**
     * Dedicated thread and associated runnable for calling into the detector with frames, as the
     * frames become available from the camera.
     */
    private var processingThread: Thread? = null
    private val processingRunnable: FrameProcessingRunnable
    private val processorLock = Object()
    // @GuardedBy("processorLock")
    private var frameProcessor: VisionImageProcessor? = null
    /**
     * Map to convert between a byte array, received from the camera, and its associated byte buffer.
     * We use byte buffers internally because this is a more efficient way to call into native code
     * later (avoids a potential copy).
     *
     *
     * **Note:** uses IdentityHashMap here instead of HashMap because the behavior of an array's
     * equals, hashCode and toString methods is both useless and unexpected. IdentityHashMap enforces
     * identity ('==') check on the keys.
     */
    private val bytesToByteBuffer: MutableMap<ByteArray, ByteBuffer?> = IdentityHashMap()
    // ==============================================================================================
    // Public
    // ==============================================================================================
    /** Stops the camera and releases the resources of the camera and underlying detector.  */
    fun release() {
        synchronized(processorLock) {
            stop()
            processingRunnable.release()
            cleanScreen()
            frameProcessor?.stop()
        }
    }

    /**
     * Opens the camera and starts sending preview frames to the underlying detector. The preview
     * frames are not displayed.
     *
     * @throws IOException if the camera's preview texture or display could not be initialized
     */
    @SuppressLint("MissingPermission")
    @RequiresPermission(Manifest.permission.CAMERA)
    @Synchronized
    @Throws(IOException::class)
    fun start(): CameraSource1 {
        camera?: run {
            createCamera().run {
                camera = this
                dummySurfaceTexture = SurfaceTexture(DUMMY_TEXTURE_NAME)
                this.setPreviewTexture(dummySurfaceTexture)
                usingSurfaceTexture = true
                this.startPreview()
            }

            Thread(processingRunnable).run {
                processingThread = this
                processingRunnable.setActive(true)
                this.start()
            }
        }
        return this
    }

    /**
     * Opens the camera and starts sending preview frames to the underlying detector. The supplied
     * surface holder is used for the preview so frames can be displayed to the user.
     *
     * @param surfaceHolder the surface holder to use for the preview frames
     * @throws IOException if the supplied surface holder could not be used as the preview display
     */
    @RequiresPermission(Manifest.permission.CAMERA)
    @Synchronized
    @Throws(IOException::class)
    fun start(surfaceHolder: SurfaceHolder?): CameraSource1 {
        camera?: run {
            camera = createCamera().apply {
                setPreviewDisplay(surfaceHolder)
                startPreview()
            }

            processingThread = Thread(processingRunnable).apply {
                processingRunnable.setActive(true)
                start()
            }
            usingSurfaceTexture = false
        }
        return this
    }

    /**
     * Closes the camera and stops sending frames to the underlying frame detector.
     *
     *
     * This camera source may be restarted again by calling [.start] or [ ][.start].
     *
     *
     * Call [.release] instead to completely shut down this camera source and release the
     * resources of the underlying detector.
     */
    @Synchronized
    fun stop() {
        processingRunnable.setActive(false)
        processingThread?.let {
            try {
                // Wait for the thread to complete to ensure that we can't have multiple threads
                // executing at the same time (i.e., which would happen if we called start too
                // quickly after stop).
                it.join()
            } catch (e: InterruptedException) {
                Timber.tag(TAG).d("Frame processing thread interrupted on release.")
            }
            processingThread = null
        }
        camera?.let {
            it.stopPreview()
            it.setPreviewCallbackWithBuffer(null)
            try {
                if (usingSurfaceTexture) {
                    it.setPreviewTexture(null)
                } else {
                    it.setPreviewDisplay(null)
                }
            } catch (e: Exception) {
                Timber.tag(TAG).e( "Failed to clear camera preview: $e")
            }
            it.release()
            camera = null
        }

        // Release the reference to any image buffers, since these will no longer be in use.
        bytesToByteBuffer.clear()
    }

    /** Changes the facing of the camera.  */
    @Synchronized
    fun setFacing(facing: Int) {
        if(facing != CAMERA_FACING_BACK && facing != CAMERA_FACING_FRONT) {
            Timber.i("Invalid camera: $facing")
            throw IllegalArgumentException("Invalid camera: $facing")
        } else {
            cameraFacing = facing
        }
    }

    /**
     * Opens the camera and applies the user settings.
     *
     * @throws IOException if camera cannot be found or preview cannot be processed
     */
    @SuppressLint("InlinedApi")
    @Throws(IOException::class)
    private fun createCamera(): Camera {
        getIdForRequestedCamera(cameraFacing).let { requestedCameraId ->
            if (requestedCameraId == -1) {
                Timber.e("Could not find requested camera.")
                throw IOException("Could not find requested camera.")
            }

            Camera.open(requestedCameraId).let {camera ->
                var sizePair: SizePair? = PreferenceUtils.getCameraPreviewSizePair1(activity, requestedCameraId)

                sizePair?:run {
                    sizePair = selectSizePair(
                            camera,
                            DEFAULT_REQUESTED_CAMERA_PREVIEW_WIDTH,
                            DEFAULT_REQUESTED_CAMERA_PREVIEW_HEIGHT)
                }

                sizePair?.let {sizePair ->
                    previewSize = sizePair.preview
                    Log.v(TAG, "Camera preview size: $previewSize")
                    Timber.tag(TAG).i("Camera preview size: $previewSize")

                    val previewFpsRange = selectPreviewFpsRange(camera, requestedFps)
                            ?: throw IOException("Could not find suitable preview frames per second range.")
                    val parameters = camera.parameters.apply {
                        sizePair.picture?.let { pictureSize ->
                            Timber.tag(TAG).i("Camera picture size: $pictureSize")
                            this.setPictureSize(pictureSize.width, pictureSize.height)
                        }

                        setPreviewSize(previewSize.width, previewSize.height)
                        setPreviewFpsRange(
                                previewFpsRange[Camera.Parameters.PREVIEW_FPS_MIN_INDEX],
                                previewFpsRange[Camera.Parameters.PREVIEW_FPS_MAX_INDEX])
                        // Use YV12 so that we can exercise YV12->NV21 auto-conversion logic for OCR detection
                        previewFormat = IMAGE_FORMAT
                    }

                    setRotation(camera, parameters, requestedCameraId)
                    if (requestedAutoFocus) {
                        if (parameters.supportedFocusModes
                                        .contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO)) {
                            parameters.focusMode = Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO
                        } else {
                            Timber.tag(TAG).i( "Camera auto focus is not supported on this device.")
                        }
                    }
                    camera.parameters = parameters
                    // Four frame buffers are needed for working with the camera:
                    //
                    //   one for the frame that is currently being executed upon in doing detection
                    //   one for the next pending frame to process immediately upon completing detection
                    //   two for the frames that the camera uses to populate future preview images
                    //
                    // Through trial and error it appears that two free buffers, in addition to the two buffers
                    // used in this code, are needed for the camera to work properly.  Perhaps the camera has
                    // one thread for acquiring images, and another thread for calling into user code.  If only
                    // three buffers are used, then the camera will spew thousands of warning messages when
                    // detection takes a non-trivial amount of time.
                    camera.setPreviewCallbackWithBuffer(CameraPreviewCallback())
                    camera.addCallbackBuffer(createPreviewBuffer(previewSize))
                    camera.addCallbackBuffer(createPreviewBuffer(previewSize))
                    camera.addCallbackBuffer(createPreviewBuffer(previewSize))
                    camera.addCallbackBuffer(createPreviewBuffer(previewSize))
                    return camera

                } ?:run {
                    Timber.e("Could not find suitable preview size.")
                    throw IOException("Could not find suitable preview size.")
                }
            }
        }
    }

    /**
     * Stores a preview size and a corresponding same-aspect-ratio picture size. To avoid distorted
     * preview images on some devices, the picture size must be set to a size that is the same aspect
     * ratio as the preview size or the preview may end up being distorted. If the picture size is
     * null, then there is no picture size with the same aspect ratio as the preview size.
     */
    class SizePair {
        val preview: Size
        val picture: Size?

        internal constructor(
                previewSize: Camera.Size,
                pictureSize: Camera.Size?) {
            preview = Size(previewSize.width, previewSize.height)
            picture = if (pictureSize != null) Size(pictureSize.width, pictureSize.height) else null
        }

        constructor(previewSize: Size, pictureSize: Size?) {
            preview = previewSize
            picture = pictureSize
        }
    }

    /**
     * Calculates the correct rotation for the given camera id and sets the rotation in the
     * parameters. It also sets the camera's display orientation and rotation.
     *
     * @param parameters the camera parameters for which to set the rotation
     * @param cameraId the camera id to set rotation based on
     */
    private fun setRotation(camera: Camera, parameters: Camera.Parameters, cameraId: Int) {
        val windowManager = activity.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        var degrees = 0
        val rotation = windowManager.defaultDisplay.rotation
        when (rotation) {
            Surface.ROTATION_0 -> degrees = 0
            Surface.ROTATION_90 -> degrees = 90
            Surface.ROTATION_180 -> degrees = 180
            Surface.ROTATION_270 -> degrees = 270
            else -> Log.e(TAG, "Bad rotation value: $rotation")
        }
        val cameraInfo = Camera.CameraInfo()
        Camera.getCameraInfo(cameraId, cameraInfo)
        val angle: Int
        val displayAngle: Int
        if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            angle = (cameraInfo.orientation + degrees) % 360
            displayAngle = (360 - angle) % 360 // compensate for it being mirrored
        } else { // back-facing
            angle = (cameraInfo.orientation - degrees + 360) % 360
            displayAngle = angle
        }
        // This corresponds to the rotation constants.
        this.rotation = angle / 90
        Log.d(TAG, "Display rotation is: $rotation")
        Log.d(TAG, "Camera face is: " + cameraInfo.facing)
        Log.d(TAG, "Camera rotation is: " + cameraInfo.orientation)
        Log.d(TAG, "Rotation is: " + this.rotation)
        camera.setDisplayOrientation(displayAngle)
        parameters.setRotation(angle)
    }

    /**
     * Creates one buffer for the camera preview callback. The size of the buffer is based off of the
     * camera preview size and the format of the camera image.
     *
     * @return a new preview buffer of the appropriate size for the current camera settings
     */
    @SuppressLint("InlinedApi")
    private fun createPreviewBuffer(previewSize: Size?): ByteArray {
        val bitsPerPixel = ImageFormat.getBitsPerPixel(IMAGE_FORMAT)
        val sizeInBits = previewSize!!.height.toLong() * previewSize.width * bitsPerPixel
        val bufferSize = (ceil(sizeInBits / 8.0) + 1).toInt()
        // Creating the byte array this way and wrapping it, as opposed to using .allocate(),
        // should guarantee that there will be an array to work with.
        val byteArray = ByteArray(bufferSize)
        val buffer = ByteBuffer.wrap(byteArray)
        check(!(!buffer.hasArray() || buffer.array() != byteArray)) {
            // I don't think that this will ever happen.  But if it does, then we wouldn't be
            // passing the preview content to the underlying detector later.
            "Failed to create valid buffer for camera source."
        }
        bytesToByteBuffer[byteArray] = buffer
        return byteArray
    }
    // ==============================================================================================
    // Frame processing
    // ==============================================================================================
    /** Called when the camera has a new preview frame.  */
    private inner class CameraPreviewCallback : PreviewCallback {
        override fun onPreviewFrame(data: ByteArray?, camera: Camera) {
            processingRunnable.setNextFrame(data, camera)
        }
    }

    fun setMachineLearningFrameProcessor(processor: VisionImageProcessor?) {
        synchronized(processorLock) {
            cleanScreen()
            frameProcessor?.stop()
            frameProcessor = processor
        }
    }

    /**
     * This runnable controls access to the underlying receiver, calling it to process frames when
     * available from the camera. This is designed to run detection on frames as fast as possible
     * (i.e., without unnecessary context switching or waiting on the next frame).
     *
     *
     * While detection is running on a frame, new frames may be received from the camera. As these
     * frames come in, the most recent frame is held onto as pending. As soon as detection and its
     * associated processing is done for the previous frame, detection on the mostly recently received
     * frame will immediately start on the same thread.
     */
    private inner class FrameProcessingRunnable internal constructor() : Runnable {
        // This lock guards all of the member variables below.
        private val lock = Object()
        private var active = true
        // These pending variables hold the state associated with the new frame awaiting processing.
        private var pendingFrameData: ByteBuffer? = null

        /**
         * Releases the underlying receiver. This is only safe to do after the associated thread has
         * completed, which is managed in camera source's release method above.
         */
        @SuppressLint("Assert")
        fun release() {
            assert(processingThread!!.state == Thread.State.TERMINATED)
        }

        /** Marks the runnable as active/not active. Signals any blocked threads to continue.  */
        fun setActive(active: Boolean) {
            synchronized(lock) {
                this.active = active
                lock.notifyAll()
            }
        }

        /**
         * Sets the frame data received from the camera. This adds the previous unused frame buffer (if
         * present) back to the camera, and keeps a pending reference to the frame data for future use.
         */
        fun setNextFrame(data: ByteArray?, camera: Camera) {
            synchronized(lock) {
                pendingFrameData?.run {
                    camera.addCallbackBuffer(this.array())
                    pendingFrameData = null
                }

                if (!bytesToByteBuffer.containsKey(data)) {
                    Timber.tag(TAG).d(
                            "Skipping frame. Could not find ByteBuffer associated with the image data from the camera.")
                    return
                }
                pendingFrameData = bytesToByteBuffer[data]
                // Notify the processor thread if it is waiting on the next frame (see below).
                lock.notifyAll()
            }
        }

        /**
         * As long as the processing thread is active, this executes detection on frames continuously.
         * The next pending frame is either immediately available or hasn't been received yet. Once it
         * is available, we transfer the frame info to local variables and run detection on that frame.
         * It immediately loops back for the next frame without pausing.
         *
         *
         * If detection takes longer than the time in between new frames from the camera, this will
         * mean that this loop will run without ever waiting on a frame, avoiding any context switching
         * or frame acquisition time latency.
         *
         *
         * If you find that this is using more CPU than you'd like, you should probably decrease the
         * FPS setting above to allow for some idle time in between frames.
         */
        @SuppressLint("InlinedApi")
        override fun run() {
            var data: ByteBuffer?
            while (true) {
                synchronized(lock) {
                    while (active && pendingFrameData == null) {
                        try { // Wait for the next frame to be received from the camera, since we
                            // don't have it yet.
                            lock.wait()
                        } catch (e: InterruptedException) {
                            Log.d(TAG, "Frame processing loop terminated.", e)
                            return
                        }
                    }
                    if (!active) { // Exit the loop once this camera source is stopped or released.  We check
                        // this here, immediately after the wait() above, to handle the case where
                        // setActive(false) had been called, triggering the termination of this
                        // loop.
                        return
                    }
                    // Hold onto the frame data locally, so that we can use this for detection
                    // below.  We need to clear pendingFrameData to ensure that this buffer isn't
                    // recycled back to the camera before we are done using that data.
                    data = pendingFrameData
                    pendingFrameData = null
                }
                // The code below needs to run outside of synchronization, because this will allow
                // the camera to add pending frame(s) while we are running detection on the current
                // frame.
                try {
                    synchronized(processorLock) {
//                        Log.d(TAG, "Process an image")
                        if (data != null && previewSize != null) {
                            frameProcessor?.process(
                                    data!!,
                                    FrameMetadata.Companion.Builder()
                                            .setWidth(previewSize!!.width)
                                            .setHeight(previewSize!!.height)
                                            .setRotation(rotation)
                                            .setCameraFacing(cameraFacing)
                                            .build(),
                                    graphicOverlay)
                        }

                    }
                } catch (t: Exception) {
                    Log.e(TAG, "Exception thrown from receiver.", t)
                } finally {
                    camera!!.addCallbackBuffer(data!!.array())
                }
            }
        }
    }

    /** Cleans up graphicOverlay and child classes can do their cleanups as well .  */
    private fun cleanScreen() {
        graphicOverlay.clear()
    }

    companion object {
        @SuppressLint("InlinedApi")
        const val CAMERA_FACING_BACK = Camera.CameraInfo.CAMERA_FACING_BACK
        @SuppressLint("InlinedApi")
        const val CAMERA_FACING_FRONT = Camera.CameraInfo.CAMERA_FACING_FRONT
        const val IMAGE_FORMAT = ImageFormat.NV21
        const val DEFAULT_REQUESTED_CAMERA_PREVIEW_WIDTH = 480
        const val DEFAULT_REQUESTED_CAMERA_PREVIEW_HEIGHT = 360
        private const val TAG = "MIDemoApp:CameraSource"
        /**
         * The dummy surface texture must be assigned a chosen name. Since we never use an OpenGL context,
         * we can choose any ID we want here. The dummy surface texture is not a crazy hack - it is
         * actually how the camera team recommends using the camera without a preview.
         */
        private const val DUMMY_TEXTURE_NAME = 100
        /**
         * If the absolute difference between a preview size aspect ratio and a picture size aspect ratio
         * is less than this tolerance, they are considered to be the same aspect ratio.
         */
        private const val ASPECT_RATIO_TOLERANCE = 0.01f

        /**
         * Gets the id for the camera specified by the direction it is facing. Returns -1 if no such
         * camera was found.
         *
         * @param facing the desired camera (front-facing or rear-facing)
         */
        private fun getIdForRequestedCamera(facing: Int): Int {
            val cameraInfo = Camera.CameraInfo()
            for (i in 0 until Camera.getNumberOfCameras()) {
                Camera.getCameraInfo(i, cameraInfo)
                if (cameraInfo.facing == facing) {
                    return i
                }
            }
            return -1
        }

        /**
         * Selects the most suitable preview and picture size, given the desired width and height.
         *
         *
         * Even though we only need to find the preview size, it's necessary to find both the preview
         * size and the picture size of the camera together, because these need to have the same aspect
         * ratio. On some hardware, if you would only set the preview size, you will get a distorted
         * image.
         *
         * @param camera the camera to select a preview size from
         * @param desiredWidth the desired width of the camera preview frames
         * @param desiredHeight the desired height of the camera preview frames
         * @return the selected preview and picture size pair
         */
        fun selectSizePair(camera: Camera, desiredWidth: Int, desiredHeight: Int): SizePair? {
            val validPreviewSizes = generateValidPreviewSizeList(camera)
            // The method for selecting the best size is to minimize the sum of the differences between
            // the desired values and the actual values for width and height.  This is certainly not the
            // only way to select the best size, but it provides a decent tradeoff between using the
            // closest aspect ratio vs. using the closest pixel area.
            var selectedPair: SizePair? = null
            var minDiff = Int.MAX_VALUE
            for (sizePair in validPreviewSizes) {
                val size = sizePair.preview
                val diff = Math.abs(size.width - desiredWidth) + Math.abs(size.height - desiredHeight)
                if (diff < minDiff) {
                    selectedPair = sizePair
                    minDiff = diff
                }
            }
            return selectedPair
        }

        /**
         * Generates a list of acceptable preview sizes. Preview sizes are not acceptable if there is not
         * a corresponding picture size of the same aspect ratio. If there is a corresponding picture size
         * of the same aspect ratio, the picture size is paired up with the preview size.
         *
         *
         * This is necessary because even if we don't use still pictures, the still picture size must
         * be set to a size that is the same aspect ratio as the preview size we choose. Otherwise, the
         * preview images may be distorted on some devices.
         */
        fun generateValidPreviewSizeList(camera: Camera): List<SizePair> {
            val parameters = camera.parameters
            val supportedPreviewSizes = parameters.supportedPreviewSizes
            val supportedPictureSizes = parameters.supportedPictureSizes
            val validPreviewSizes: MutableList<SizePair> = ArrayList()
            for (previewSize in supportedPreviewSizes) {
                val previewAspectRatio = previewSize.width.toFloat() / previewSize.height.toFloat()
                // By looping through the picture sizes in order, we favor the higher resolutions.
                // We choose the highest resolution in order to support taking the full resolution
                // picture later.
                for (pictureSize in supportedPictureSizes) {
                    val pictureAspectRatio = pictureSize.width.toFloat() / pictureSize.height.toFloat()
                    if (Math.abs(previewAspectRatio - pictureAspectRatio) < ASPECT_RATIO_TOLERANCE) {
                        validPreviewSizes.add(SizePair(previewSize, pictureSize))
                        break
                    }
                }
            }
            // If there are no picture sizes with the same aspect ratio as any preview sizes, allow all
            // of the preview sizes and hope that the camera can handle it.  Probably unlikely, but we
            // still account for it.
            if (validPreviewSizes.size == 0) {
                Log.w(TAG, "No preview sizes have a corresponding same-aspect-ratio picture size")
                for (previewSize in supportedPreviewSizes) { // The null picture size will let us know that we shouldn't set a picture size.
                    validPreviewSizes.add(SizePair(previewSize, null))
                }
            }
            return validPreviewSizes
        }

        /**
         * Selects the most suitable preview frames per second range, given the desired frames per second.
         *
         * @param camera the camera to select a frames per second range from
         * @param desiredPreviewFps the desired frames per second for the camera preview frames
         * @return the selected preview frames per second range
         */
        @SuppressLint("InlinedApi")
        private fun selectPreviewFpsRange(camera: Camera, desiredPreviewFps: Float): IntArray? {
            // The camera API uses integers scaled by a factor of 1000 instead of floating-point frame
            // rates.
            val desiredPreviewFpsScaled = (desiredPreviewFps * 1000.0f).toInt()
            // The method for selecting the best range is to minimize the sum of the differences between
            // the desired value and the upper and lower bounds of the range.  This may select a range
            // that the desired value is outside of, but this is often preferred.  For example, if the
            // desired frame rate is 29.97, the range (30, 30) is probably more desirable than the
            // range (15, 30).
            var selectedFpsRange: IntArray? = null
            var minDiff = Int.MAX_VALUE
            val previewFpsRangeList = camera.parameters.supportedPreviewFpsRange
            for (range in previewFpsRangeList) {
                val deltaMin = desiredPreviewFpsScaled - range[Camera.Parameters.PREVIEW_FPS_MIN_INDEX]
                val deltaMax = desiredPreviewFpsScaled - range[Camera.Parameters.PREVIEW_FPS_MAX_INDEX]
                val diff = Math.abs(deltaMin) + Math.abs(deltaMax)
                if (diff < minDiff) {
                    selectedFpsRange = range
                    minDiff = diff
                }
            }
            return selectedFpsRange
        }
    }

    init {
        graphicOverlay.clear()
        processingRunnable = FrameProcessingRunnable()
    }
}