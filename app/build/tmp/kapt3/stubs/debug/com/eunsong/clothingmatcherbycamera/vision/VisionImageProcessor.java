package com.eunsong.clothingmatcherbycamera.vision;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&\u00a8\u0006\u000b"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/vision/VisionImageProcessor;", "", "process", "", "data", "Ljava/nio/ByteBuffer;", "frameMetadata", "Lcom/eunsong/clothingmatcherbycamera/model/FrameMetadata;", "graphicOverlay", "Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;", "stop", "app_debug"})
public abstract interface VisionImageProcessor {
    
    /**
     * Processes the images with the underlying machine learning models.
     */
    public abstract void process(@org.jetbrains.annotations.NotNull()
    java.nio.ByteBuffer data, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.model.FrameMetadata frameMetadata, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay graphicOverlay) throws com.google.firebase.ml.common.FirebaseMLException;
    
    /**
     * Stops the underlying machine learning model and release resources.
     */
    public abstract void stop();
}