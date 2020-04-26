package com.eunsong.clothingmatcherbycamera.overlay;

import java.lang.System;

/**
 * A view which renders a series of custom graphics to be overlayed on top of an associated preview
 * (i.e., the camera preview). The creator can add graphics objects, update the objects, and remove
 * them, triggering the appropriate drawing and invalidation within the view.
 *
 *
 * Supports scaling and mirroring of the graphics relative the camera's preview properties. The
 * idea is that detection items are expressed in terms of a preview size, but need to be scaled up
 * to the full view size, and also mirrored in the case of the front-facing camera.
 *
 *
 * Associated [Graphic] items should use the following methods to convert to view
 * coordinates for the graphics that are drawn:
 *
 *
 * 1. [Graphic.scaleX] and [Graphic.scaleY] adjust the size of the
 * supplied value from the preview scale to the view scale.
 * 1. [Graphic.translateX] and [Graphic.translateY] adjust the
 * coordinate from the preview's coordinate system to the view coordinate system.
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001cB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010\u0016\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bJ\u001e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "facing", "", "graphics", "", "Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay$Graphic;", "heightScaleFactor", "", "lock", "Ljava/lang/Object;", "previewHeight", "previewWidth", "widthScaleFactor", "add", "", "graphic", "clear", "onDraw", "canvas", "Landroid/graphics/Canvas;", "remove", "setCameraInfo", "Graphic", "app_debug"})
public final class GraphicOverlay extends android.view.View {
    private final java.lang.Object lock = null;
    private int previewWidth;
    private float widthScaleFactor;
    private int previewHeight;
    private float heightScaleFactor;
    private int facing;
    private final java.util.List<com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay.Graphic> graphics = null;
    private java.util.HashMap _$_findViewCache;
    
    /**
     * Removes all graphics from the overlay.
     */
    public final void clear() {
    }
    
    /**
     * Adds a graphic to the overlay.
     */
    public final void add(@org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay.Graphic graphic) {
    }
    
    /**
     * Removes a graphic from the overlay.
     */
    public final void remove(@org.jetbrains.annotations.Nullable()
    com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay.Graphic graphic) {
    }
    
    /**
     * Sets the camera attributes for size and facing direction, which informs how to transform image
     * coordinates later.
     */
    public final void setCameraInfo(int previewWidth, int previewHeight, int facing) {
    }
    
    /**
     * Draws the overlay with its associated graphic objects.
     */
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    public GraphicOverlay(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    /**
     * Base class for a custom graphics object to be rendered within the graphic overlay. Subclass
     * this and implement the [Graphic.draw] method to define the graphics element. Add
     * instances to the overlay using [GraphicOverlay.add].
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fR\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay$Graphic;", "", "overlay", "Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;", "(Lcom/eunsong/clothingmatcherbycamera/overlay/GraphicOverlay;)V", "applicationContext", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "postInvalidate", "scaleX", "", "horizontal", "scaleY", "vertical", "translateX", "x", "translateY", "y", "app_debug"})
    public static abstract class Graphic {
        private final com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay overlay = null;
        
        /**
         * Draw the graphic on the supplied canvas. Drawing should use the following methods to convert
         * to view coordinates for the graphics that are drawn:
         *
         *
         * 1. [Graphic.scaleX] and [Graphic.scaleY] adjust the size of the
         * supplied value from the preview scale to the view scale.
         * 1. [Graphic.translateX] and [Graphic.translateY] adjust the
         * coordinate from the preview's coordinate system to the view coordinate system.
         *
         *
         * @param canvas drawing canvas
         */
        public abstract void draw(@org.jetbrains.annotations.Nullable()
        android.graphics.Canvas canvas);
        
        /**
         * Adjusts a horizontal value of the supplied value from the preview scale to the view scale.
         */
        public final float scaleX(float horizontal) {
            return 0.0F;
        }
        
        /**
         * Adjusts a vertical value of the supplied value from the preview scale to the view scale.
         */
        public final float scaleY(float vertical) {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getApplicationContext() {
            return null;
        }
        
        /**
         * Adjusts the x coordinate from the preview's coordinate system to the view coordinate system.
         */
        public final float translateX(float x) {
            return 0.0F;
        }
        
        /**
         * Adjusts the y coordinate from the preview's coordinate system to the view coordinate system.
         */
        public final float translateY(float y) {
            return 0.0F;
        }
        
        public final void postInvalidate() {
        }
        
        public Graphic(@org.jetbrains.annotations.NotNull()
        com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay overlay) {
            super();
        }
    }
}