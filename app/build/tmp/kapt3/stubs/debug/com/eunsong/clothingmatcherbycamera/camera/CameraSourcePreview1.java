package com.eunsong.clothingmatcherbycamera.camera;

import java.lang.System;

/**
 * Preview the camera image in the screen.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0002J0\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0014J\u0006\u0010\u001b\u001a\u00020\u0013J\u0012\u0010\u001c\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u001c\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\b\u0010\u001d\u001a\u00020\u0013H\u0003J\u0006\u0010\u001e\u001a\u00020\u0013R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/camera/CameraSourcePreview1;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cameraSource", "Lcom/eunsong/clothingmatcherbycamera/camera/CameraSource1;", "isPortraitMode", "", "()Z", "overlay", "Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;", "startRequested", "surfaceAvailable", "surfaceView", "Landroid/view/SurfaceView;", "changeExposure", "", "onLayout", "changed", "left", "", "top", "right", "bottom", "release", "start", "startIfReady", "stop", "Companion", "SurfaceCallback", "app_debug"})
public final class CameraSourcePreview1 extends android.view.ViewGroup {
    private final android.view.SurfaceView surfaceView = null;
    private boolean startRequested;
    private boolean surfaceAvailable;
    private com.eunsong.clothingmatcherbycamera.camera.CameraSource1 cameraSource;
    private com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay overlay;
    private static final java.lang.String TAG = "Camera:Preview";
    public static final com.eunsong.clothingmatcherbycamera.camera.CameraSourcePreview1.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final void start(com.eunsong.clothingmatcherbycamera.camera.CameraSource1 cameraSource) throws java.io.IOException {
    }
    
    public final void start(@org.jetbrains.annotations.Nullable()
    com.eunsong.clothingmatcherbycamera.camera.CameraSource1 cameraSource, @org.jetbrains.annotations.Nullable()
    com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay overlay) throws java.io.IOException {
    }
    
    public final void stop() {
    }
    
    public final void release() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void startIfReady() throws java.io.IOException {
    }
    
    private final void changeExposure() {
    }
    
    @java.lang.Override()
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }
    
    private final boolean isPortraitMode() {
        return false;
    }
    
    public CameraSourcePreview1(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/camera/CameraSourcePreview1$SurfaceCallback;", "Landroid/view/SurfaceHolder$Callback;", "(Lcom/eunsong/clothingmatcherbycamera/camera/CameraSourcePreview1;)V", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surface", "surfaceDestroyed", "app_debug"})
    final class SurfaceCallback implements android.view.SurfaceHolder.Callback {
        
        @java.lang.Override()
        public void surfaceCreated(@org.jetbrains.annotations.NotNull()
        android.view.SurfaceHolder surface) {
        }
        
        @java.lang.Override()
        public void surfaceDestroyed(@org.jetbrains.annotations.NotNull()
        android.view.SurfaceHolder surface) {
        }
        
        @java.lang.Override()
        public void surfaceChanged(@org.jetbrains.annotations.NotNull()
        android.view.SurfaceHolder holder, int format, int width, int height) {
        }
        
        public SurfaceCallback() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/camera/CameraSourcePreview1$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}