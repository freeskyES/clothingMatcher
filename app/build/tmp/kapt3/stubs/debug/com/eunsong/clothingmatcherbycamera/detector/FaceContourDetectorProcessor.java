package com.eunsong.clothingmatcherbycamera.detector;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0014\u0010!\u001a\u00020\"2\n\u0010#\u001a\u00060$j\u0002`%H\u0014J0\u0010&\u001a\u00020\"2\b\u0010\'\u001a\u0004\u0018\u00010\u001b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0005H\u0014J\b\u0010,\u001a\u00020\"H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000f\u00a8\u0006-"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourDetectorProcessor;", "Lcom/eunsong/clothingmatcherbycamera/vision/VisionProcessorBase;", "", "Lcom/google/firebase/ml/vision/face/FirebaseVisionFace;", "overlay", "Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;", "clothesOverlay", "clothesPreview", "Lcom/eunsong/clothingmatcherbycamera/custom/ImagePreview;", "detectorCallback", "Lcom/eunsong/clothingmatcherbycamera/listener/DetectorCallback;", "(Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;Lcom/eunsong/clothingmatcherbycamera/custom/ImagePreview;Lcom/eunsong/clothingmatcherbycamera/listener/DetectorCallback;)V", "bgFaceInfo", "Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceDetectInfo;", "getClothesOverlay", "()Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;", "getClothesPreview", "()Lcom/eunsong/clothingmatcherbycamera/custom/ImagePreview;", "detector", "Lcom/google/firebase/ml/vision/face/FirebaseVisionFaceDetector;", "job", "Lkotlinx/coroutines/CompletableJob;", "getJob", "()Lkotlinx/coroutines/CompletableJob;", "setJob", "(Lkotlinx/coroutines/CompletableJob;)V", "originBg", "Landroid/graphics/Bitmap;", "getOverlay", "detectInImage", "Lcom/google/android/gms/tasks/Task;", "image", "Lcom/google/firebase/ml/vision/common/FirebaseVisionImage;", "onFailure", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "originalCameraImage", "results", "frameMetadata", "Lcom/eunsong/clothingmatcherbycamera/model/FrameMetadata;", "graphicOverlay", "stop", "app_debug"})
public final class FaceContourDetectorProcessor extends com.eunsong.clothingmatcherbycamera.vision.VisionProcessorBase<java.util.List<? extends com.google.firebase.ml.vision.face.FirebaseVisionFace>> {
    private final com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector detector = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.CompletableJob job;
    private android.graphics.Bitmap originBg;
    private com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo bgFaceInfo;
    @org.jetbrains.annotations.NotNull()
    private final com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay overlay = null;
    @org.jetbrains.annotations.NotNull()
    private final com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay clothesOverlay = null;
    @org.jetbrains.annotations.NotNull()
    private final com.eunsong.clothingmatcherbycamera.custom.ImagePreview clothesPreview = null;
    private final com.eunsong.clothingmatcherbycamera.listener.DetectorCallback detectorCallback = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CompletableJob getJob() {
        return null;
    }
    
    public final void setJob(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CompletableJob p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected com.google.android.gms.tasks.Task<java.util.List<com.google.firebase.ml.vision.face.FirebaseVisionFace>> detectInImage(@org.jetbrains.annotations.NotNull()
    com.google.firebase.ml.vision.common.FirebaseVisionImage image) {
        return null;
    }
    
    @java.lang.Override()
    protected void onSuccess(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap originalCameraImage, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.google.firebase.ml.vision.face.FirebaseVisionFace> results, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.model.FrameMetadata frameMetadata, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay graphicOverlay) {
    }
    
    @java.lang.Override()
    protected void onFailure(@org.jetbrains.annotations.NotNull()
    java.lang.Exception e) {
    }
    
    @java.lang.Override()
    public void stop() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay getOverlay() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay getClothesOverlay() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.eunsong.clothingmatcherbycamera.custom.ImagePreview getClothesPreview() {
        return null;
    }
    
    public FaceContourDetectorProcessor(@org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay overlay, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay clothesOverlay, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.custom.ImagePreview clothesPreview, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.listener.DetectorCallback detectorCallback) {
        super();
    }
}