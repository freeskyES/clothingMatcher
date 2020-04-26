package com.eunsong.clothingmatcherbycamera.binding;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0000\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007\u001a\u001a\u0010\n\u001a\u00020\u0001*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007\u00a8\u0006\u000f"}, d2 = {"imageUrl", "", "imageView", "Landroid/widget/ImageView;", "", "showHide", "view", "Landroid/view/View;", "show", "", "setClothesItem", "Lcom/yarolegovich/discretescrollview/DiscreteScrollView;", "items", "", "Lcom/eunsong/clothingmatcherbycamera/adapter/model/ClothesItem;", "app_debug"})
public final class BindingAdaptersKt {
    
    @androidx.databinding.BindingAdapter(value = {"visibleGone"})
    public static final void showHide(@org.jetbrains.annotations.NotNull()
    android.view.View view, boolean show) {
    }
    
    @androidx.databinding.BindingAdapter(requireAll = false, value = {"imageUrl"})
    public static final void imageUrl(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"clothesItems"})
    public static final void setClothesItem(@org.jetbrains.annotations.NotNull()
    com.yarolegovich.discretescrollview.DiscreteScrollView $this$setClothesItem, @org.jetbrains.annotations.NotNull()
    java.util.List<com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem> items) {
    }
}