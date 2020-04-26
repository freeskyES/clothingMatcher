package com.eunsong.clothingmatcherbycamera;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eunsong.clothingmatcherbycamera.databinding.ActivityCameraBindingImpl;
import com.eunsong.clothingmatcherbycamera.databinding.FaceRecognitionGuideBindingImpl;
import com.eunsong.clothingmatcherbycamera.databinding.RvClothesItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYCAMERA = 1;

  private static final int LAYOUT_FACERECOGNITIONGUIDE = 2;

  private static final int LAYOUT_RVCLOTHESITEM = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.eunsong.clothingmatcherbycamera.R.layout.activity_camera, LAYOUT_ACTIVITYCAMERA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.eunsong.clothingmatcherbycamera.R.layout.face_recognition_guide, LAYOUT_FACERECOGNITIONGUIDE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.eunsong.clothingmatcherbycamera.R.layout.rv_clothes_item, LAYOUT_RVCLOTHESITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYCAMERA: {
          if ("layout/activity_camera_0".equals(tag)) {
            return new ActivityCameraBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_camera is invalid. Received: " + tag);
        }
        case  LAYOUT_FACERECOGNITIONGUIDE: {
          if ("layout/face_recognition_guide_0".equals(tag)) {
            return new FaceRecognitionGuideBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for face_recognition_guide is invalid. Received: " + tag);
        }
        case  LAYOUT_RVCLOTHESITEM: {
          if ("layout/rv_clothes_item_0".equals(tag)) {
            return new RvClothesItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for rv_clothes_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "eventListener");
      sKeys.put(2, "item");
      sKeys.put(3, "position");
      sKeys.put(4, "viewmodel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/activity_camera_0", com.eunsong.clothingmatcherbycamera.R.layout.activity_camera);
      sKeys.put("layout/face_recognition_guide_0", com.eunsong.clothingmatcherbycamera.R.layout.face_recognition_guide);
      sKeys.put("layout/rv_clothes_item_0", com.eunsong.clothingmatcherbycamera.R.layout.rv_clothes_item);
    }
  }
}
