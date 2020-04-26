package com.eunsong.clothingmatcherbycamera.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J0\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/listener/DetectorCallback;", "", "onFailureDetector", "", "e", "", "onSuccessDetector", "originalCameraImage", "Landroid/graphics/Bitmap;", "results", "", "Lcom/google/firebase/ml/vision/face/FirebaseVisionFace;", "frameMetadata", "Lcom/eunsong/clothingmatcherbycamera/model/FrameMetadata;", "graphicOverlay", "Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;", "app_debug"})
public abstract interface DetectorCallback {
    
    public abstract void onSuccessDetector(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap originalCameraImage, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.google.firebase.ml.vision.face.FirebaseVisionFace> results, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.model.FrameMetadata frameMetadata, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay graphicOverlay);
    
    public abstract void onFailureDetector(@org.jetbrains.annotations.Nullable()
    java.lang.String e);
}