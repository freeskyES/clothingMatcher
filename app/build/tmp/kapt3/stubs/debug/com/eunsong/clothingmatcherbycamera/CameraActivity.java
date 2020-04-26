package com.eunsong.clothingmatcherbycamera;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 02\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u001a\u0010&\u001a\u00020\u00182\b\u0010\'\u001a\u0004\u0018\u00010\u00032\u0006\u0010(\u001a\u00020 H\u0016J\b\u0010)\u001a\u00020\u0018H\u0014J\b\u0010*\u001a\u00020\u0018H\u0014J\b\u0010+\u001a\u00020\u0018H\u0014J\b\u0010,\u001a\u00020\u0018H\u0002J\b\u0010-\u001a\u00020\u0018H\u0002J\b\u0010.\u001a\u00020\u0018H\u0002J\b\u0010/\u001a\u00020\u0018H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u00061"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/CameraActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/yarolegovich/discretescrollview/DiscreteScrollView$OnItemChangedListener;", "Lcom/eunsong/clothingmatcherbycamera/adapter/holder/ClothesItemHolder;", "Lcom/eunsong/clothingmatcherbycamera/adapter/listener/ClothesListener;", "()V", "cameraSource", "Lcom/eunsong/clothingmatcherbycamera/camera/CameraSource;", "requiredPermissions", "", "", "getRequiredPermissions", "()[Ljava/lang/String;", "viewDataBinding", "Lcom/eunsong/clothingmatcherbycamera/databinding/ActivityCameraBinding;", "viewmodel", "Lcom/eunsong/clothingmatcherbycamera/CameraViewModel;", "getViewmodel", "()Lcom/eunsong/clothingmatcherbycamera/CameraViewModel;", "viewmodel$delegate", "Lkotlin/Lazy;", "allPermissionsGranted", "", "changeFacing", "", "checkCamera", "createCameraSource", "getRuntimePermissions", "isPermissionGranted", "permission", "onClothesItemClicked", "pos", "", "clothesItem", "Lcom/eunsong/clothingmatcherbycamera/adapter/model/ClothesItem;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCurrentItemChanged", "holder", "position", "onDestroy", "onPause", "onResume", "setupCamera", "setupEvents", "setupPicker", "startCamera", "Companion", "app_debug"})
public final class CameraActivity extends androidx.appcompat.app.AppCompatActivity implements com.yarolegovich.discretescrollview.DiscreteScrollView.OnItemChangedListener<com.eunsong.clothingmatcherbycamera.adapter.holder.ClothesItemHolder>, com.eunsong.clothingmatcherbycamera.adapter.listener.ClothesListener {
    private com.eunsong.clothingmatcherbycamera.databinding.ActivityCameraBinding viewDataBinding;
    private final kotlin.Lazy viewmodel$delegate = null;
    private com.eunsong.clothingmatcherbycamera.camera.CameraSource cameraSource;
    private static final int PERMISSION_REQUESTS = 1;
    private static final java.lang.String CAMERA_PARAM = "camera_param";
    public static final com.eunsong.clothingmatcherbycamera.CameraActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.eunsong.clothingmatcherbycamera.CameraViewModel getViewmodel() {
        return null;
    }
    
    private final java.lang.String[] getRequiredPermissions() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupPicker() {
    }
    
    @java.lang.Override()
    public void onCurrentItemChanged(@org.jetbrains.annotations.Nullable()
    com.eunsong.clothingmatcherbycamera.adapter.holder.ClothesItemHolder holder, int position) {
    }
    
    @java.lang.Override()
    public void onClothesItemClicked(int pos, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem clothesItem) {
    }
    
    private final void setupCamera() {
    }
    
    private final void setupEvents() {
    }
    
    private final void getRuntimePermissions() {
    }
    
    private final void createCameraSource() {
    }
    
    /**
     * camera 가 1개일경우, front camera 접근 막기
     */
    private final void checkCamera() {
    }
    
    private final void changeFacing() {
    }
    
    private final void startCamera() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final boolean allPermissionsGranted() {
        return false;
    }
    
    private final boolean isPermissionGranted(java.lang.String permission) {
        return false;
    }
    
    public CameraActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.content.Intent startIntent(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.eunsong.clothingmatcherbycamera.model.CameraParam cameraParam) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/eunsong/clothingmatcherbycamera/CameraActivity$Companion;", "", "()V", "CAMERA_PARAM", "", "PERMISSION_REQUESTS", "", "startIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "cameraParam", "Lcom/eunsong/clothingmatcherbycamera/model/CameraParam;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Intent startIntent(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.eunsong.clothingmatcherbycamera.model.CameraParam cameraParam) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}