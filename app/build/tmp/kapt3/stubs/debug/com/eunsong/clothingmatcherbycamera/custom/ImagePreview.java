package com.eunsong.clothingmatcherbycamera.custom;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000fH\u0002J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\tJ*\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010\u00182\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fH\u0016J\u0012\u0010-\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010.\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010\u0018H\u0016J\u0016\u0010/\u001a\u00020$2\u0006\u0010\b\u001a\u00020\t2\u0006\u00100\u001a\u000201R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u00062"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/custom/ImagePreview;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bgInfo", "Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceDetectInfo;", "getBgInfo", "()Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceDetectInfo;", "setBgInfo", "(Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceDetectInfo;)V", "deltaPx", "", "getDeltaPx", "()I", "setDeltaPx", "(I)V", "deltaPy", "getDeltaPy", "setDeltaPy", "viewHolder", "Landroid/view/SurfaceHolder;", "getViewHolder", "()Landroid/view/SurfaceHolder;", "setViewHolder", "(Landroid/view/SurfaceHolder;)V", "blur", "Landroid/graphics/Paint;", "canvas", "Landroid/graphics/Canvas;", "targetWidth", "targetHeight", "run", "", "bgBitmap", "Landroid/graphics/Bitmap;", "faceInfo", "surfaceChanged", "holder", "format", "width", "height", "surfaceCreated", "surfaceDestroyed", "updatePreviewInfo", "previewSize", "Landroid/util/Size;", "app_debug"})
public final class ImagePreview extends android.view.SurfaceView implements android.view.SurfaceHolder.Callback {
    @org.jetbrains.annotations.NotNull()
    private android.view.SurfaceHolder viewHolder;
    @org.jetbrains.annotations.Nullable()
    private com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo bgInfo;
    private int deltaPx;
    private int deltaPy;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.SurfaceHolder getViewHolder() {
        return null;
    }
    
    public final void setViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.SurfaceHolder p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo getBgInfo() {
        return null;
    }
    
    public final void setBgInfo(@org.jetbrains.annotations.Nullable()
    com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo p0) {
    }
    
    public final int getDeltaPx() {
        return 0;
    }
    
    public final void setDeltaPx(int p0) {
    }
    
    public final int getDeltaPy() {
        return 0;
    }
    
    public final void setDeltaPy(int p0) {
    }
    
    public final void updatePreviewInfo(@org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo bgInfo, @org.jetbrains.annotations.NotNull()
    android.util.Size previewSize) {
    }
    
    public final void run(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bgBitmap, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo faceInfo) {
    }
    
    private final android.graphics.Paint blur(android.graphics.Canvas canvas) {
        return null;
    }
    
    private final int deltaPx(int targetWidth) {
        return 0;
    }
    
    private final int deltaPy(int targetHeight) {
        return 0;
    }
    
    @java.lang.Override()
    public void surfaceChanged(@org.jetbrains.annotations.Nullable()
    android.view.SurfaceHolder holder, int format, int width, int height) {
    }
    
    @java.lang.Override()
    public void surfaceDestroyed(@org.jetbrains.annotations.Nullable()
    android.view.SurfaceHolder holder) {
    }
    
    @java.lang.Override()
    public void surfaceCreated(@org.jetbrains.annotations.Nullable()
    android.view.SurfaceHolder holder) {
    }
    
    public ImagePreview(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
}