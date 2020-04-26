package com.eunsong.clothingmatcherbycamera.camera

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.hardware.Camera
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.ViewGroup
import com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay
import com.eunsong.clothingmatcherbycamera.util.PreferenceUtils
import timber.log.Timber
import java.io.IOException
import kotlin.math.max
import kotlin.math.min


/** Preview the camera image in the screen.  */
class CameraSourcePreview1 @JvmOverloads constructor(context: Context, attrs: AttributeSet?) : ViewGroup(context, attrs) {
    private val surfaceView: SurfaceView = SurfaceView(context)
    private var startRequested = false
    private var surfaceAvailable = false
    private var cameraSource: CameraSource1? = null

    private var overlay: GraphicOverlay? = null
    @Throws(IOException::class)
    private fun start(cameraSource: CameraSource1?) {
        cameraSource?:run { stop() }

        this.cameraSource = cameraSource

        this.cameraSource?.run {
            startRequested = true
            startIfReady()
        }
    }

    @Throws(IOException::class)
    fun start(cameraSource: CameraSource1?, overlay: GraphicOverlay?) {
        this.overlay = overlay
        start(cameraSource)
    }

    fun stop() {
        cameraSource?.stop()
    }

    fun release() {
        cameraSource?.let {
            it.release()
            cameraSource = null
        }
        surfaceView.holder.surface.release()
    }

    @SuppressLint("MissingPermission")
    @Throws(IOException::class)
    private fun startIfReady() {
        if (startRequested && surfaceAvailable) {
            cameraSource?.let {cameraSource ->
                if (PreferenceUtils.isCameraLiveViewportEnabled(context)) {
                    cameraSource.start(surfaceView.holder)
                } else {
                    cameraSource.start()
                }
                requestLayout()
                changeExposure()

                overlay?.let { overlay ->
                    cameraSource.previewSize?.let { size ->
                        val min = min(size.width, size.height)
                        val max = max(size.width, size.height)
                        if (isPortraitMode) {
                            // Swap width and height sizes when in portrait, since it will be rotated by
                            // 90 degrees
                            overlay.setCameraInfo(min, max, cameraSource.cameraFacing)
                        } else {
                            overlay.setCameraInfo(max, min, cameraSource.cameraFacing)
                        }
                        overlay.clear()
                    }
                }
                startRequested = false
            }
        }
    }

    private inner class SurfaceCallback : SurfaceHolder.Callback {
        override fun surfaceCreated(surface: SurfaceHolder) {
            surfaceAvailable = true
            try {
                startIfReady()
            } catch (e: IOException) {
                Timber.tag(TAG).e( "Could not start camera source. $e")
            }
        }

        override fun surfaceDestroyed(surface: SurfaceHolder) {
            surfaceAvailable = false
        }

        override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
            changeExposure()
        }
    }

    private fun changeExposure() {
        cameraSource?.let {cameraSource->
            cameraSource.camera?.let {camera ->
                try {
                    val parameters = camera.parameters
                    //WHITE_BALANCE_FLUORESCENT
                    //WHITE_BALANCE_DAYLIGHT
                    //WHITE_BALANCE_CLOUDY_DAYLIGHT
                    //WHITE_BALANCE_INCANDESCENT
                    //WHITE_BALANCE_SHADE : 약간 어둡다.
                    //WHITE_BALANCE_WARM_FLUORESCENT : 약간 어둡다.
                    //    parameters.setWhiteBalance(Camera.Parameters.WHITE_BALANCE_CLOUDY_DAYLIGHT);//WHITE_BALANCE_INCANDESCENT
                    val maxExpo = parameters.maxExposureCompensation
                    Timber.tag("changeExposure").i( "maxExpo : $maxExpo")
                    parameters.exposureCompensation = maxExpo
                    val sceneModeList = parameters.supportedSceneModes
                    val focusModeList = parameters.supportedFocusModes
                    try {
                        parameters.previewFrameRate = 10
                        if (sceneModeList != null &&
                                sceneModeList.contains(Camera.Parameters.SCENE_MODE_PORTRAIT)) {
                            parameters.sceneMode = Camera.Parameters.SCENE_MODE_PORTRAIT
                        }
                        if (focusModeList != null &&
                                focusModeList.contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO)) {
                            parameters.focusMode = Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO
                        }
                        camera.parameters = parameters
                    } catch (ex: Exception) {
                        ex.printStackTrace()
                        Timber.tag("cameraSourcePreview").i( "setParameters failed~")
                    }
                    camera.startPreview()

                } catch (e: Exception) {
                    e.printStackTrace()
                }



            }
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        var width = 320
        var height = 240
        cameraSource?.let { cameraSource ->
            cameraSource.previewSize?.let { size ->
                width = size.width
                height = size.height
            }
        }
        // Swap width and height sizes when in portrait, since it will be rotated 90 degrees
        if (isPortraitMode) {
            val tmp = width
            width = height
            height = tmp
        }
        val layoutWidth = right - left
        val layoutHeight = bottom - top
        // Computes height and width for potentially doing fit width.
        var childWidth = layoutWidth
        var childHeight = (layoutWidth.toFloat() / width.toFloat() * height).toInt()
        // If height is too tall using fit width, does fit height instead.
        if (childHeight > layoutHeight) {
            childHeight = layoutHeight
            childWidth = (layoutHeight.toFloat() / height.toFloat() * width) as Int
        }
        for (i in 0 until childCount) {
            getChildAt(i).layout(0, 0, childWidth, childHeight)
            Timber.tag(TAG).d("Assigned view: $i")
        }
        try {
            startIfReady()
        } catch (e: IOException) {
            Timber.tag(TAG).e( "Could not start camera source. $e")
        }
    }

    private val isPortraitMode: Boolean
        private get() {
            val orientation = context.resources.configuration.orientation
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                return false
            }
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                return true
            }
            Timber.tag(TAG).d( "isPortraitMode returning false by default")
            return false
        }

    companion object {
        private const val TAG = "Camera:Preview"
    }

    init {
        surfaceView.holder.addCallback(SurfaceCallback())
        addView(surfaceView)
    }
}
