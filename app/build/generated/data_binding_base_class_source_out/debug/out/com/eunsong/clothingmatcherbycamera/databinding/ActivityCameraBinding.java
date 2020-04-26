// Generated by data binding compiler. Do not edit!
package com.eunsong.clothingmatcherbycamera.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eunsong.clothingmatcherbycamera.CameraViewModel;
import com.eunsong.clothingmatcherbycamera.R;
import com.eunsong.clothingmatcherbycamera.camera.CameraSourcePreview;
import com.eunsong.clothingmatcherbycamera.custom.ImagePreview;
import com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityCameraBinding extends ViewDataBinding {
  @NonNull
  public final ImageView backKey;

  @NonNull
  public final ConstraintLayout bottomContainer;

  @NonNull
  public final CameraSourcePreview cameraPreview;

  @NonNull
  public final TextView clothTitle;

  @NonNull
  public final GraphicOverlay clothesOverlay;

  @NonNull
  public final ImagePreview clothesView;

  @NonNull
  public final ImageView facingSwitch;

  @NonNull
  public final TextView guideTitle;

  @NonNull
  public final GraphicOverlay overlay;

  @NonNull
  public final ConstraintLayout pagerContainer;

  @NonNull
  public final DiscreteScrollView picker;

  @NonNull
  public final ConstraintLayout previewContainer;

  @NonNull
  public final ImageView shutterBtn;

  @NonNull
  public final ConstraintLayout toolbar;

  @Bindable
  protected CameraViewModel mViewmodel;

  protected ActivityCameraBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView backKey, ConstraintLayout bottomContainer, CameraSourcePreview cameraPreview,
      TextView clothTitle, GraphicOverlay clothesOverlay, ImagePreview clothesView,
      ImageView facingSwitch, TextView guideTitle, GraphicOverlay overlay,
      ConstraintLayout pagerContainer, DiscreteScrollView picker, ConstraintLayout previewContainer,
      ImageView shutterBtn, ConstraintLayout toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.backKey = backKey;
    this.bottomContainer = bottomContainer;
    this.cameraPreview = cameraPreview;
    this.clothTitle = clothTitle;
    this.clothesOverlay = clothesOverlay;
    this.clothesView = clothesView;
    this.facingSwitch = facingSwitch;
    this.guideTitle = guideTitle;
    this.overlay = overlay;
    this.pagerContainer = pagerContainer;
    this.picker = picker;
    this.previewContainer = previewContainer;
    this.shutterBtn = shutterBtn;
    this.toolbar = toolbar;
  }

  public abstract void setViewmodel(@Nullable CameraViewModel viewmodel);

  @Nullable
  public CameraViewModel getViewmodel() {
    return mViewmodel;
  }

  @NonNull
  public static ActivityCameraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_camera, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCameraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityCameraBinding>inflateInternal(inflater, R.layout.activity_camera, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCameraBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_camera, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCameraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityCameraBinding>inflateInternal(inflater, R.layout.activity_camera, null, false, component);
  }

  public static ActivityCameraBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityCameraBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityCameraBinding)bind(component, view, R.layout.activity_camera);
  }
}
