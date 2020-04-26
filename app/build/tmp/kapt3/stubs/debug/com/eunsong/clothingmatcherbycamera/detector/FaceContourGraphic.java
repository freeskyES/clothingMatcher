package com.eunsong.clothingmatcherbycamera.detector;

import java.lang.System;

/**
 * Graphic instance for rendering face contours graphic overlay view.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001b\u001c\u001dBx\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012_\b\u0002\u0010\u0006\u001aY\u00122\u00120\u0012\u0004\u0012\u00020\t0\bj\u0017\u0012\u0004\u0012\u00020\t`\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007j\u0004\u0018\u0001`\u0011\u00a2\u0006\u0002\u0010\u0012J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000Re\u0010\u0006\u001aY\u00122\u00120\u0012\u0004\u0012\u00020\t0\bj\u0017\u0012\u0004\u0012\u00020\t`\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007j\u0004\u0018\u0001`\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic;", "Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay$Graphic;", "overlay", "Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;", "firebaseVisionFace", "Lcom/google/firebase/ml/vision/face/FirebaseVisionFace;", "listener", "Lkotlin/Function2;", "Ljava/util/ArrayList;", "Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceContourData;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "points", "Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceDetectInfo;", "faceInfo", "", "Lcom/eunsong/clothingmatcherbycamera/detector/ContourListener;", "(Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;Lcom/google/firebase/ml/vision/face/FirebaseVisionFace;Lkotlin/jvm/functions/Function2;)V", "boxPaint", "Landroid/graphics/Paint;", "facePositionPaint", "idPaint", "list", "draw", "canvas", "Landroid/graphics/Canvas;", "Companion", "FaceContourData", "FaceDetectInfo", "app_debug"})
public final class FaceContourGraphic extends com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay.Graphic {
    private final java.util.ArrayList<com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceContourData> list = null;
    private final android.graphics.Paint facePositionPaint = null;
    private final android.graphics.Paint idPaint = null;
    private final android.graphics.Paint boxPaint = null;
    private final com.google.firebase.ml.vision.face.FirebaseVisionFace firebaseVisionFace = null;
    private kotlin.jvm.functions.Function2<? super java.util.ArrayList<com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceContourData>, ? super com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo, kotlin.Unit> listener;
    private static final float FACE_POSITION_RADIUS = 4.0F;
    private static final float ID_TEXT_SIZE = 30.0F;
    private static final float ID_Y_OFFSET = 80.0F;
    private static final float ID_X_OFFSET = -70.0F;
    private static final float BOX_STROKE_WIDTH = 5.0F;
    public static final com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.Companion Companion = null;
    
    /**
     * Draws the face annotations for position on the supplied canvas.
     */
    @java.lang.Override()
    public void draw(@org.jetbrains.annotations.Nullable()
    android.graphics.Canvas canvas) {
    }
    
    public FaceContourGraphic(@org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay overlay, @org.jetbrains.annotations.Nullable()
    com.google.firebase.ml.vision.face.FirebaseVisionFace firebaseVisionFace, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function2<? super java.util.ArrayList<com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceContourData>, ? super com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo, kotlin.Unit> listener) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceContourData;", "", "px", "", "py", "(FF)V", "getPx", "()F", "getPy", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class FaceContourData {
        private final float px = 0.0F;
        private final float py = 0.0F;
        
        public final float getPx() {
            return 0.0F;
        }
        
        public final float getPy() {
            return 0.0F;
        }
        
        public FaceContourData(float px, float py) {
            super();
        }
        
        public final float component1() {
            return 0.0F;
        }
        
        public final float component2() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceContourData copy(float px, float py) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\nH\u00c6\u0003J\t\u0010 \u001a\u00020\fH\u00c6\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020&H\u00d6\u0001J\t\u0010\'\u001a\u00020(H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011\u00a8\u0006)"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceDetectInfo;", "", "left", "", "top", "rectWidth", "rectHeight", "centerPx", "centerPy", "canvasSize", "Landroid/util/Size;", "chinBottomPos", "Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceContourData;", "(FFFFFFLandroid/util/Size;Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceContourData;)V", "getCanvasSize", "()Landroid/util/Size;", "getCenterPx", "()F", "getCenterPy", "getChinBottomPos", "()Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$FaceContourData;", "getLeft", "getRectHeight", "getRectWidth", "getTop", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class FaceDetectInfo {
        private final float left = 0.0F;
        private final float top = 0.0F;
        private final float rectWidth = 0.0F;
        private final float rectHeight = 0.0F;
        private final float centerPx = 0.0F;
        private final float centerPy = 0.0F;
        @org.jetbrains.annotations.NotNull()
        private final android.util.Size canvasSize = null;
        @org.jetbrains.annotations.NotNull()
        private final com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceContourData chinBottomPos = null;
        
        public final float getLeft() {
            return 0.0F;
        }
        
        public final float getTop() {
            return 0.0F;
        }
        
        public final float getRectWidth() {
            return 0.0F;
        }
        
        public final float getRectHeight() {
            return 0.0F;
        }
        
        public final float getCenterPx() {
            return 0.0F;
        }
        
        public final float getCenterPy() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.util.Size getCanvasSize() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceContourData getChinBottomPos() {
            return null;
        }
        
        public FaceDetectInfo(float left, float top, float rectWidth, float rectHeight, float centerPx, float centerPy, @org.jetbrains.annotations.NotNull()
        android.util.Size canvasSize, @org.jetbrains.annotations.NotNull()
        com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceContourData chinBottomPos) {
            super();
        }
        
        public final float component1() {
            return 0.0F;
        }
        
        public final float component2() {
            return 0.0F;
        }
        
        public final float component3() {
            return 0.0F;
        }
        
        public final float component4() {
            return 0.0F;
        }
        
        public final float component5() {
            return 0.0F;
        }
        
        public final float component6() {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.util.Size component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceContourData component8() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceDetectInfo copy(float left, float top, float rectWidth, float rectHeight, float centerPx, float centerPy, @org.jetbrains.annotations.NotNull()
        android.util.Size canvasSize, @org.jetbrains.annotations.NotNull()
        com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic.FaceContourData chinBottomPos) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/detector/FaceContourGraphic$Companion;", "", "()V", "BOX_STROKE_WIDTH", "", "FACE_POSITION_RADIUS", "ID_TEXT_SIZE", "ID_X_OFFSET", "ID_Y_OFFSET", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}