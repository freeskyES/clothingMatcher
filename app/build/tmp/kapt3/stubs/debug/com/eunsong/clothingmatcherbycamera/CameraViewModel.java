package com.eunsong.clothingmatcherbycamera;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u0011H\u0002J\u0012\u00105\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u00010\u0011H\u0016J0\u00107\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u00010\u001f2\f\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00062\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J0\u0010?\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u00010\u001f2\f\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00062\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\u000e\u0010@\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\tJ\u000e\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020CJ\u000e\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020FJ\u001e\u0010G\u001a\u00020\u000e2\f\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00062\u0006\u0010=\u001a\u00020>H\u0002J\u000e\u0010H\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010I\u001a\u00020\u000eJ2\u0010J\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u00010\u001f2\u0016\u0010K\u001a\u0012\u0012\u0004\u0012\u00020M0Lj\b\u0012\u0004\u0012\u00020M`N2\u0006\u0010O\u001a\u00020\u0016H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060%\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0%\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\'R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0%\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\'R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0%\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\'R\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0%\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\'R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070%\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\'R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110%\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\'R\u001d\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0%\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\'\u00a8\u0006P"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/CameraViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/eunsong/clothingmatcherbycamera/listener/DetectorCallback;", "()V", "_images", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/eunsong/clothingmatcherbycamera/adapter/model/ClothesItem;", "_isDetectedClothes", "", "_isDetectedFace", "_isFrontFacing", "_pasteClothes", "Lcom/eunsong/clothingmatcherbycamera/util/Event;", "", "_selectedImage", "_selectedImageName", "", "_updateClothesPreview", "clothesManager", "Lcom/eunsong/clothingmatcherbycamera/manager/ClothesManager;", "faceInfoOfCamera", "Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceDetectInfo;", "getFaceInfoOfCamera", "()Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceDetectInfo;", "setFaceInfoOfCamera", "(Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceDetectInfo;)V", "faceInfoOfClothes", "getFaceInfoOfClothes", "setFaceInfoOfClothes", "finalClothes", "Landroid/graphics/Bitmap;", "getFinalClothes", "()Landroid/graphics/Bitmap;", "setFinalClothes", "(Landroid/graphics/Bitmap;)V", "images", "Landroidx/lifecycle/LiveData;", "getImages", "()Landroidx/lifecycle/LiveData;", "isDetectedClothes", "isDetectedFace", "isFrontFacing", "pasteClothes", "getPasteClothes", "selectedImage", "getSelectedImage", "selectedImageName", "getSelectedImageName", "updateClothesPreview", "getUpdateClothesPreview", "onChangedSelectedImage", "url", "onFailureDetector", "e", "onSuccessDetector", "originalCameraImage", "results", "Lcom/google/firebase/ml/vision/face/FirebaseVisionFace;", "frameMetadata", "Lcom/eunsong/clothingmatcherbycamera/model/FrameMetadata;", "graphicOverlay", "Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;", "setFaceContour", "setFrontFacing", "setImages", "cameraParam", "Lcom/eunsong/clothingmatcherbycamera/model/CameraParam;", "setSelectedImage", "pos", "", "setupClothes", "setupClothesManager", "toggleFrontFacing", "updateClothes", "points", "Ljava/util/ArrayList;", "Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceContourData;", "Lkotlin/collections/ArrayList;", "faceInfoOfCam", "app_debug"})
public final class CameraViewModel extends androidx.lifecycle.ViewModel implements com.eunsong.clothingmatcherbycamera.listener.DetectorCallback {
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isFrontFacing = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isFrontFacing = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isDetectedFace = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isDetectedFace = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isDetectedClothes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isDetectedClothes = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem>> _images = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem>> images = null;
    private final androidx.lifecycle.MutableLiveData<com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem> _selectedImage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem> selectedImage = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _selectedImageName = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> selectedImageName = null;
    private final androidx.lifecycle.MutableLiveData<com.eunsong.clothingmatcherbycamera.util.Event<kotlin.Unit>> _updateClothesPreview = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.eunsong.clothingmatcherbycamera.util.Event<kotlin.Unit>> updateClothesPreview = null;
    private final androidx.lifecycle.MutableLiveData<com.eunsong.clothingmatcherbycamera.util.Event<kotlin.Unit>> _pasteClothes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.eunsong.clothingmatcherbycamera.util.Event<kotlin.Unit>> pasteClothes = null;
    @org.jetbrains.annotations.Nullable()
    private com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo faceInfoOfClothes;
    private com.eunsong.clothingmatcherbycamera.manager.ClothesManager clothesManager;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap finalClothes;
    @org.jetbrains.annotations.Nullable()
    private com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo faceInfoOfCamera;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isFrontFacing() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isDetectedFace() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isDetectedClothes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem>> getImages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem> getSelectedImage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getSelectedImageName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.eunsong.clothingmatcherbycamera.util.Event<kotlin.Unit>> getUpdateClothesPreview() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.eunsong.clothingmatcherbycamera.util.Event<kotlin.Unit>> getPasteClothes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo getFaceInfoOfClothes() {
        return null;
    }
    
    public final void setFaceInfoOfClothes(@org.jetbrains.annotations.Nullable()
    com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getFinalClothes() {
        return null;
    }
    
    public final void setFinalClothes(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo getFaceInfoOfCamera() {
        return null;
    }
    
    public final void setFaceInfoOfCamera(@org.jetbrains.annotations.Nullable()
    com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo p0) {
    }
    
    public final void setupClothesManager(@org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.manager.ClothesManager clothesManager) {
    }
    
    public final void setSelectedImage(int pos) {
    }
    
    private final void onChangedSelectedImage(java.lang.String url) {
    }
    
    public final void setImages(@org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.model.CameraParam cameraParam) {
    }
    
    public final void setFrontFacing(boolean isFrontFacing) {
    }
    
    public final void toggleFrontFacing() {
    }
    
    @java.lang.Override()
    public void onSuccessDetector(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap originalCameraImage, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.google.firebase.ml.vision.face.FirebaseVisionFace> results, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.model.FrameMetadata frameMetadata, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay graphicOverlay) {
    }
    
    private final void setFaceContour(android.graphics.Bitmap originalCameraImage, java.util.List<? extends com.google.firebase.ml.vision.face.FirebaseVisionFace> results, com.eunsong.clothingmatcherbycamera.model.FrameMetadata frameMetadata, com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay graphicOverlay) {
    }
    
    /**
     * 얼굴 감지 실패
     */
    @java.lang.Override()
    public void onFailureDetector(@org.jetbrains.annotations.Nullable()
    java.lang.String e) {
    }
    
    /**
     * 카메라 얼굴 감지되었을떄,
     * 옷을 카메라 얼굴에 맞게 업데이트하기
     */
    private final void updateClothes(android.graphics.Bitmap originalCameraImage, java.util.ArrayList<com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceContourData> points, com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo faceInfoOfCam) {
    }
    
    private final void setupClothes(java.util.List<? extends com.google.firebase.ml.vision.face.FirebaseVisionFace> results, com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay graphicOverlay) {
    }
    
    public CameraViewModel() {
        super();
    }
}