package com.eunsong.clothingmatcherbycamera.camera;

import java.lang.System;

/**
 * Manages the camera and allows UI updates on top of it (e.g. overlaying extra Graphics or
 * displaying extra information). This receives preview frames from the camera at a specified rate,
 * sending those frames to child classes' detectors / classifiers as fast as it is able to process.
 */
@android.annotation.SuppressLint(value = {"MissingPermission"})
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 D2\u00020\u0001:\u0004CDEFB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u0010H\u0003J\u0012\u00105\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0003J\u0006\u00106\u001a\u000203J\u000e\u00107\u001a\u0002032\u0006\u00108\u001a\u00020\u0016J\u0010\u00109\u001a\u0002032\b\u0010:\u001a\u0004\u0018\u00010\u001dJ$\u0010;\u001a\u0002032\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010<\u001a\u00060=R\u00020\u00102\u0006\u0010>\u001a\u00020\u0016H\u0002J\b\u0010?\u001a\u00020\u0000H\u0007J\u0012\u0010?\u001a\u00020\u00002\b\u0010@\u001a\u0004\u0018\u00010AH\u0007J\u0006\u0010B\u001a\u000203R\u001a\u0010\u0002\u001a\u00020\u0003X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u0015\u001a\u0004\u0018\u00010\"@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00060\'R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020-X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/camera/CameraSource1;", "", "activity", "Landroid/app/Activity;", "graphicOverlay", "Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;", "(Landroid/app/Activity;Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "bytesToByteBuffer", "", "", "Ljava/nio/ByteBuffer;", "camera", "Landroid/hardware/Camera;", "getCamera", "()Landroid/hardware/Camera;", "setCamera", "(Landroid/hardware/Camera;)V", "<set-?>", "", "cameraFacing", "getCameraFacing", "()I", "dummySurfaceTexture", "Landroid/graphics/SurfaceTexture;", "frameProcessor", "Lcom/eunsong/clothingmatcherbycamera/vision/VisionImageProcessor;", "getGraphicOverlay", "()Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;", "setGraphicOverlay", "(Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;)V", "Lcom/google/android/gms/common/images/Size;", "previewSize", "getPreviewSize", "()Lcom/google/android/gms/common/images/Size;", "processingRunnable", "Lcom/eunsong/clothingmatcherbycamera/camera/CameraSource1$FrameProcessingRunnable;", "processingThread", "Ljava/lang/Thread;", "processorLock", "Ljava/lang/Object;", "requestedAutoFocus", "", "requestedFps", "", "rotation", "usingSurfaceTexture", "cleanScreen", "", "createCamera", "createPreviewBuffer", "release", "setFacing", "facing", "setMachineLearningFrameProcessor", "processor", "setRotation", "parameters", "Landroid/hardware/Camera$Parameters;", "cameraId", "start", "surfaceHolder", "Landroid/view/SurfaceHolder;", "stop", "CameraPreviewCallback", "Companion", "FrameProcessingRunnable", "SizePair", "app_debug"})
public final class CameraSource1 {
    @org.jetbrains.annotations.Nullable()
    private android.hardware.Camera camera;
    
    /**
     * Returns the selected camera; one of [.CAMERA_FACING_BACK] or [ ][.CAMERA_FACING_FRONT].
     */
    private int cameraFacing;
    
    /**
     * Rotation of the device, and thus the associated preview images captured from the device. See
     * Frame.Metadata#getRotation().
     */
    private int rotation;
    
    /**
     * Returns the preview size that is currently in use by the underlying camera.
     */
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.common.images.Size previewSize;
    private final float requestedFps = 30.0F;
    private final boolean requestedAutoFocus = true;
    private android.graphics.SurfaceTexture dummySurfaceTexture;
    private boolean usingSurfaceTexture;
    
    /**
     * Dedicated thread and associated runnable for calling into the detector with frames, as the
     * frames become available from the camera.
     */
    private java.lang.Thread processingThread;
    private final com.eunsong.clothingmatcherbycamera.camera.CameraSource1.FrameProcessingRunnable processingRunnable = null;
    private final java.lang.Object processorLock = null;
    private com.eunsong.clothingmatcherbycamera.vision.VisionImageProcessor frameProcessor;
    
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
    private final java.util.Map<byte[], java.nio.ByteBuffer> bytesToByteBuffer = null;
    @org.jetbrains.annotations.NotNull()
    private android.app.Activity activity;
    @org.jetbrains.annotations.NotNull()
    private com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay graphicOverlay;
    @android.annotation.SuppressLint(value = {"InlinedApi"})
    public static final int CAMERA_FACING_BACK = android.hardware.Camera.CameraInfo.CAMERA_FACING_BACK;
    @android.annotation.SuppressLint(value = {"InlinedApi"})
    public static final int CAMERA_FACING_FRONT = android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT;
    public static final int IMAGE_FORMAT = android.graphics.ImageFormat.NV21;
    public static final int DEFAULT_REQUESTED_CAMERA_PREVIEW_WIDTH = 480;
    public static final int DEFAULT_REQUESTED_CAMERA_PREVIEW_HEIGHT = 360;
    private static final java.lang.String TAG = "MIDemoApp:CameraSource";
    
    /**
     * The dummy surface texture must be assigned a chosen name. Since we never use an OpenGL context,
     * we can choose any ID we want here. The dummy surface texture is not a crazy hack - it is
     * actually how the camera team recommends using the camera without a preview.
     */
    private static final int DUMMY_TEXTURE_NAME = 100;
    
    /**
     * If the absolute difference between a preview size aspect ratio and a picture size aspect ratio
     * is less than this tolerance, they are considered to be the same aspect ratio.
     */
    private static final float ASPECT_RATIO_TOLERANCE = 0.01F;
    public static final com.eunsong.clothingmatcherbycamera.camera.CameraSource1.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final android.hardware.Camera getCamera() {
        return null;
    }
    
    public final void setCamera(@org.jetbrains.annotations.Nullable()
    android.hardware.Camera p0) {
    }
    
    public final int getCameraFacing() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.common.images.Size getPreviewSize() {
        return null;
    }
    
    /**
     * Stops the camera and releases the resources of the camera and underlying detector.
     */
    public final void release() {
    }
    
    /**
     * Opens the camera and starts sending preview frames to the underlying detector. The preview
     * frames are not displayed.
     *
     * @throws IOException if the camera's preview texture or display could not be initialized
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresPermission(value = "android.permission.CAMERA")
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final synchronized com.eunsong.clothingmatcherbycamera.camera.CameraSource1 start() throws java.io.IOException {
        return null;
    }
    
    /**
     * Opens the camera and starts sending preview frames to the underlying detector. The supplied
     * surface holder is used for the preview so frames can be displayed to the user.
     *
     * @param surfaceHolder the surface holder to use for the preview frames
     * @throws IOException if the supplied surface holder could not be used as the preview display
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresPermission(value = "android.permission.CAMERA")
    public final synchronized com.eunsong.clothingmatcherbycamera.camera.CameraSource1 start(@org.jetbrains.annotations.Nullable()
    android.view.SurfaceHolder surfaceHolder) throws java.io.IOException {
        return null;
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
    public final synchronized void stop() {
    }
    
    /**
     * Changes the facing of the camera.
     */
    public final synchronized void setFacing(int facing) {
    }
    
    /**
     * Opens the camera and applies the user settings.
     *
     * @throws IOException if camera cannot be found or preview cannot be processed
     */
    @android.annotation.SuppressLint(value = {"InlinedApi"})
    private final android.hardware.Camera createCamera() throws java.io.IOException {
        return null;
    }
    
    /**
     * Calculates the correct rotation for the given camera id and sets the rotation in the
     * parameters. It also sets the camera's display orientation and rotation.
     *
     * @param parameters the camera parameters for which to set the rotation
     * @param cameraId the camera id to set rotation based on
     */
    private final void setRotation(android.hardware.Camera camera, android.hardware.Camera.Parameters parameters, int cameraId) {
    }
    
    /**
     * Creates one buffer for the camera preview callback. The size of the buffer is based off of the
     * camera preview size and the format of the camera image.
     *
     * @return a new preview buffer of the appropriate size for the current camera settings
     */
    @android.annotation.SuppressLint(value = {"InlinedApi"})
    private final byte[] createPreviewBuffer(com.google.android.gms.common.images.Size previewSize) {
        return null;
    }
    
    public final void setMachineLearningFrameProcessor(@org.jetbrains.annotations.Nullable()
    com.eunsong.clothingmatcherbycamera.vision.VisionImageProcessor processor) {
    }
    
    /**
     * Cleans up graphicOverlay and child classes can do their cleanups as well .
     */
    private final void cleanScreen() {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final android.app.Activity getActivity() {
        return null;
    }
    
    protected final void setActivity(@org.jetbrains.annotations.NotNull()
    android.app.Activity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay getGraphicOverlay() {
        return null;
    }
    
    public final void setGraphicOverlay(@org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay p0) {
    }
    
    public CameraSource1(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay graphicOverlay) {
        super();
    }
    
    /**
     * Stores a preview size and a corresponding same-aspect-ratio picture size. To avoid distorted
     * preview images on some devices, the picture size must be set to a size that is the same aspect
     * ratio as the preview size or the preview may end up being distorted. If the picture size is
     * null, then there is no picture size with the same aspect ratio as the preview size.
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0010\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0018\u00010\u0003R\u00020\u0004\u00a2\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0007\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/camera/CameraSource1$SizePair;", "", "previewSize", "Landroid/hardware/Camera$Size;", "Landroid/hardware/Camera;", "pictureSize", "(Landroid/hardware/Camera$Size;Landroid/hardware/Camera$Size;)V", "Lcom/google/android/gms/common/images/Size;", "(Lcom/google/android/gms/common/images/Size;Lcom/google/android/gms/common/images/Size;)V", "picture", "getPicture", "()Lcom/google/android/gms/common/images/Size;", "preview", "getPreview", "app_debug"})
    public static final class SizePair {
        @org.jetbrains.annotations.NotNull()
        private final com.google.android.gms.common.images.Size preview = null;
        @org.jetbrains.annotations.Nullable()
        private final com.google.android.gms.common.images.Size picture = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.google.android.gms.common.images.Size getPreview() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.google.android.gms.common.images.Size getPicture() {
            return null;
        }
        
        public SizePair(@org.jetbrains.annotations.NotNull()
        android.hardware.Camera.Size previewSize, @org.jetbrains.annotations.Nullable()
        android.hardware.Camera.Size pictureSize) {
            super();
        }
        
        public SizePair(@org.jetbrains.annotations.NotNull()
        com.google.android.gms.common.images.Size previewSize, @org.jetbrains.annotations.Nullable()
        com.google.android.gms.common.images.Size pictureSize) {
            super();
        }
    }
    
    /**
     * Called when the camera has a new preview frame.
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/camera/CameraSource1$CameraPreviewCallback;", "Landroid/hardware/Camera$PreviewCallback;", "(Lcom/eunsong/clothingmatcherbycamera/camera/CameraSource1;)V", "onPreviewFrame", "", "data", "", "camera", "Landroid/hardware/Camera;", "app_debug"})
    final class CameraPreviewCallback implements android.hardware.Camera.PreviewCallback {
        
        @java.lang.Override()
        public void onPreviewFrame(@org.jetbrains.annotations.Nullable()
        byte[] data, @org.jetbrains.annotations.NotNull()
        android.hardware.Camera camera) {
        }
        
        public CameraPreviewCallback() {
            super();
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
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0000\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0017J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/camera/CameraSource1$FrameProcessingRunnable;", "Ljava/lang/Runnable;", "(Lcom/eunsong/clothingmatcherbycamera/camera/CameraSource1;)V", "active", "", "lock", "Ljava/lang/Object;", "pendingFrameData", "Ljava/nio/ByteBuffer;", "release", "", "run", "setActive", "setNextFrame", "data", "", "camera", "Landroid/hardware/Camera;", "app_debug"})
    final class FrameProcessingRunnable implements java.lang.Runnable {
        private final java.lang.Object lock = null;
        private boolean active;
        private java.nio.ByteBuffer pendingFrameData;
        
        /**
         * Releases the underlying receiver. This is only safe to do after the associated thread has
         * completed, which is managed in camera source's release method above.
         */
        @android.annotation.SuppressLint(value = {"Assert"})
        public final void release() {
        }
        
        /**
         * Marks the runnable as active/not active. Signals any blocked threads to continue.
         */
        public final void setActive(boolean active) {
        }
        
        /**
         * Sets the frame data received from the camera. This adds the previous unused frame buffer (if
         * present) back to the camera, and keeps a pending reference to the frame data for future use.
         */
        public final void setNextFrame(@org.jetbrains.annotations.Nullable()
        byte[] data, @org.jetbrains.annotations.NotNull()
        android.hardware.Camera camera) {
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
        @android.annotation.SuppressLint(value = {"InlinedApi"})
        @java.lang.Override()
        public void run() {
        }
        
        public FrameProcessingRunnable() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0004H\u0003J \u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0087T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/camera/CameraSource1$Companion;", "", "()V", "ASPECT_RATIO_TOLERANCE", "", "CAMERA_FACING_BACK", "", "CAMERA_FACING_FRONT", "DEFAULT_REQUESTED_CAMERA_PREVIEW_HEIGHT", "DEFAULT_REQUESTED_CAMERA_PREVIEW_WIDTH", "DUMMY_TEXTURE_NAME", "IMAGE_FORMAT", "TAG", "", "generateValidPreviewSizeList", "", "Lcom/eunsong/clothingmatcherbycamera/camera/CameraSource1$SizePair;", "camera", "Landroid/hardware/Camera;", "getIdForRequestedCamera", "facing", "selectPreviewFpsRange", "", "desiredPreviewFps", "selectSizePair", "desiredWidth", "desiredHeight", "app_debug"})
    public static final class Companion {
        
        /**
         * Gets the id for the camera specified by the direction it is facing. Returns -1 if no such
         * camera was found.
         *
         * @param facing the desired camera (front-facing or rear-facing)
         */
        private final int getIdForRequestedCamera(int facing) {
            return 0;
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
        @org.jetbrains.annotations.Nullable()
        public final com.eunsong.clothingmatcherbycamera.camera.CameraSource1.SizePair selectSizePair(@org.jetbrains.annotations.NotNull()
        android.hardware.Camera camera, int desiredWidth, int desiredHeight) {
            return null;
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
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.eunsong.clothingmatcherbycamera.camera.CameraSource1.SizePair> generateValidPreviewSizeList(@org.jetbrains.annotations.NotNull()
        android.hardware.Camera camera) {
            return null;
        }
        
        /**
         * Selects the most suitable preview frames per second range, given the desired frames per second.
         *
         * @param camera the camera to select a frames per second range from
         * @param desiredPreviewFps the desired frames per second for the camera preview frames
         * @return the selected preview frames per second range
         */
        @android.annotation.SuppressLint(value = {"InlinedApi"})
        private final int[] selectPreviewFpsRange(android.hardware.Camera camera, float desiredPreviewFps) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}