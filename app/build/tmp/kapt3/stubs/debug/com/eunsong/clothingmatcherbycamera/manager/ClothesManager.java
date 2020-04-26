package com.eunsong.clothingmatcherbycamera.manager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u00044567B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J&\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001e\u0010\u001a\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0011\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020 J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0002J \u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020&H\u0002J\u0018\u0010(\u001a\u0004\u0018\u00010\b2\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0019J\u0018\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bH\u0002J\u000e\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u000201J\u0018\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/manager/ClothesManager;", "", "clothesOverlay", "Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;", "requestManager", "Lcom/bumptech/glide/RequestManager;", "(Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;Lcom/bumptech/glide/RequestManager;)V", "clothesBitmap", "Landroid/graphics/Bitmap;", "getClothesBitmap", "()Landroid/graphics/Bitmap;", "setClothesBitmap", "(Landroid/graphics/Bitmap;)V", "detectFace", "", "firebaseVisionImage", "Lcom/google/firebase/ml/vision/common/FirebaseVisionImage;", "callback", "Lcom/eunsong/clothingmatcherbycamera/manager/ClothesManager$DetectResult;", "editClothesImage", "resizedBitmap", "points", "Ljava/util/ArrayList;", "Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceContourData;", "faceContourInfo", "Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceDetectInfo;", "getFaceContourInfo", "faces", "", "Lcom/google/firebase/ml/vision/face/FirebaseVisionFace;", "Lcom/eunsong/clothingmatcherbycamera/manager/ClothesManager$FaceContourResult;", "processImage", "Lcom/eunsong/clothingmatcherbycamera/manager/ClothesManager$ProcessResult;", "removeImageBackground", "splitResult", "removeSameColorArea", "imageBitmap", "px", "", "py", "resizeClothes", "faceInfoOfClothes", "faceInfoOfCamera", "resizeImage", "targetSize", "Landroid/util/Size;", "selectBitmap", "setupImage", "targetImage", "", "splitImage", "targetBitmap", "Companion", "DetectResult", "FaceContourResult", "ProcessResult", "app_debug"})
public final class ClothesManager {
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap clothesBitmap;
    private final com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay clothesOverlay = null;
    private final com.bumptech.glide.RequestManager requestManager = null;
    public static final float COLOR_TOLERANCE = 5.0F;
    public static final com.eunsong.clothingmatcherbycamera.manager.ClothesManager.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getClothesBitmap() {
        return null;
    }
    
    public final void setClothesBitmap(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
    }
    
    /**
     * clothes bitmap 얻어오기
     */
    public final void setupImage(@org.jetbrains.annotations.NotNull()
    java.lang.String targetImage) {
    }
    
    /**
     * 카메라 얼굴크기에 맞춰서
     * 옷 이미지 크기 리사이징하기
     */
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap resizeClothes(@org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo faceInfoOfClothes, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo faceInfoOfCamera) {
        return null;
    }
    
    /**
     * 1. resize
     * 2. face detect onSuccess / onFailure
     * 3. 옷 이미지 편집
     */
    public final void processImage(@org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.manager.ClothesManager.ProcessResult callback) {
    }
    
    private final android.graphics.Bitmap editClothesImage(android.graphics.Bitmap resizedBitmap, java.util.ArrayList<com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceContourData> points, com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo faceContourInfo) {
        return null;
    }
    
    private final android.graphics.Bitmap removeImageBackground(android.graphics.Bitmap splitResult) {
        return null;
    }
    
    private final android.graphics.Bitmap splitImage(android.graphics.Bitmap targetBitmap, com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo faceContourInfo) {
        return null;
    }
    
    private final void getFaceContourInfo(java.util.List<? extends com.google.firebase.ml.vision.face.FirebaseVisionFace> faces, com.eunsong.clothingmatcherbycamera.manager.ClothesManager.FaceContourResult callback) {
    }
    
    private final void detectFace(com.google.firebase.ml.vision.common.FirebaseVisionImage firebaseVisionImage, com.eunsong.clothingmatcherbycamera.manager.ClothesManager.DetectResult callback) {
    }
    
    private final android.graphics.Bitmap resizeImage(android.util.Size targetSize, android.graphics.Bitmap selectBitmap) {
        return null;
    }
    
    private final android.graphics.Bitmap removeSameColorArea(android.graphics.Bitmap imageBitmap, int px, int py) {
        return null;
    }
    
    public ClothesManager(@org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay clothesOverlay, @org.jetbrains.annotations.NotNull()
    com.bumptech.glide.RequestManager requestManager) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/manager/ClothesManager$ProcessResult;", "", "onFailure", "", "e", "", "onSuccess", "faceInfo", "Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceDetectInfo;", "editedImage", "Landroid/graphics/Bitmap;", "app_debug"})
    public static abstract interface ProcessResult {
        
        public abstract void onSuccess(@org.jetbrains.annotations.NotNull()
        com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo faceInfo, @org.jetbrains.annotations.NotNull()
        android.graphics.Bitmap editedImage);
        
        public abstract void onFailure(@org.jetbrains.annotations.Nullable()
        java.lang.String e);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&\u00a8\u0006\n"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/manager/ClothesManager$DetectResult;", "", "onFailure", "", "e", "", "onSuccess", "faces", "", "Lcom/google/firebase/ml/vision/face/FirebaseVisionFace;", "app_debug"})
    public static abstract interface DetectResult {
        
        public abstract void onSuccess(@org.jetbrains.annotations.NotNull()
        java.util.List<? extends com.google.firebase.ml.vision.face.FirebaseVisionFace> faces);
        
        public abstract void onFailure(@org.jetbrains.annotations.Nullable()
        java.lang.String e);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/manager/ClothesManager$FaceContourResult;", "", "getPoints", "", "points", "Ljava/util/ArrayList;", "Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceContourData;", "faceInfo", "Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceDetectInfo;", "app_debug"})
    public static abstract interface FaceContourResult {
        
        public abstract void getPoints(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceContourData> points, @org.jetbrains.annotations.NotNull()
        com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo faceInfo);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/manager/ClothesManager$Companion;", "", "()V", "COLOR_TOLERANCE", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}