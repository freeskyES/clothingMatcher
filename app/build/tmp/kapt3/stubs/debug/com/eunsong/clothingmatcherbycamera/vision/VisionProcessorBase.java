package com.eunsong.clothingmatcherbycamera.vision;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0012\u001a\u00020\u0013H$J,\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0014\u0010\u001b\u001a\u00020\u00152\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001eH$J/\u0010\u001f\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH$\u00a2\u0006\u0002\u0010\"J \u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010%\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\'\u001a\u00020\u0015H\u0016R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R \u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b\u00a8\u0006("}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/vision/VisionProcessorBase;", "T", "Lcom/eunsong/clothingmatcherbycamera/vision/VisionImageProcessor;", "()V", "latestImage", "Ljava/nio/ByteBuffer;", "latestImageMetaData", "Lcom/eunsong/clothingmatcherbycamera/model/FrameMetadata;", "getLatestImageMetaData", "()Lcom/eunsong/clothingmatcherbycamera/model/FrameMetadata;", "setLatestImageMetaData", "(Lcom/eunsong/clothingmatcherbycamera/model/FrameMetadata;)V", "processingImage", "processingMetaData", "getProcessingMetaData", "setProcessingMetaData", "detectInImage", "Lcom/google/android/gms/tasks/Task;", "image", "Lcom/google/firebase/ml/vision/common/FirebaseVisionImage;", "detectInVisionImage", "", "originalCameraImage", "Landroid/graphics/Bitmap;", "metadata", "graphicOverlay", "Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;", "onFailure", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "results", "frameMetadata", "(Landroid/graphics/Bitmap;Ljava/lang/Object;Lcom/eunsong/clothingmatcherbycamera/model/FrameMetadata;Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;)V", "process", "data", "processImage", "processLatestImage", "stop", "app_debug"})
public abstract class VisionProcessorBase<T extends java.lang.Object> implements com.eunsong.clothingmatcherbycamera.vision.VisionImageProcessor {
    @androidx.annotation.GuardedBy(value = "this")
    private java.nio.ByteBuffer latestImage;
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.GuardedBy(value = "this")
    private com.eunsong.clothingmatcherbycamera.model.FrameMetadata latestImageMetaData;
    @androidx.annotation.GuardedBy(value = "this")
    private java.nio.ByteBuffer processingImage;
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.GuardedBy(value = "this")
    private com.eunsong.clothingmatcherbycamera.model.FrameMetadata processingMetaData;
    
    @org.jetbrains.annotations.Nullable()
    public final com.eunsong.clothingmatcherbycamera.model.FrameMetadata getLatestImageMetaData() {
        return null;
    }
    
    public final void setLatestImageMetaData(@org.jetbrains.annotations.Nullable()
    com.eunsong.clothingmatcherbycamera.model.FrameMetadata p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.eunsong.clothingmatcherbycamera.model.FrameMetadata getProcessingMetaData() {
        return null;
    }
    
    public final void setProcessingMetaData(@org.jetbrains.annotations.Nullable()
    com.eunsong.clothingmatcherbycamera.model.FrameMetadata p0) {
    }
    
    @java.lang.Override()
    public synchronized void process(@org.jetbrains.annotations.NotNull()
    java.nio.ByteBuffer data, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.model.FrameMetadata frameMetadata, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay graphicOverlay) {
    }
    
    private final synchronized void processLatestImage(com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay graphicOverlay) {
    }
    
    private final void processImage(java.nio.ByteBuffer data, com.eunsong.clothingmatcherbycamera.model.FrameMetadata frameMetadata, com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay graphicOverlay) {
    }
    
    private final void detectInVisionImage(android.graphics.Bitmap originalCameraImage, com.google.firebase.ml.vision.common.FirebaseVisionImage image, com.eunsong.clothingmatcherbycamera.model.FrameMetadata metadata, com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay graphicOverlay) {
    }
    
    @java.lang.Override()
    public void stop() {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected abstract com.google.android.gms.tasks.Task<T> detectInImage(@org.jetbrains.annotations.NotNull()
    com.google.firebase.ml.vision.common.FirebaseVisionImage image);
    
    /**
     * Callback that executes with a successful detection result.
     *
     * @param originalCameraImage hold the original image from camera, used to draw the background
     * image.
     */
    protected abstract void onSuccess(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap originalCameraImage, T results, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.model.FrameMetadata frameMetadata, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay graphicOverlay);
    
    protected abstract void onFailure(@org.jetbrains.annotations.NotNull()
    java.lang.Exception e);
    
    public VisionProcessorBase() {
        super();
    }
}