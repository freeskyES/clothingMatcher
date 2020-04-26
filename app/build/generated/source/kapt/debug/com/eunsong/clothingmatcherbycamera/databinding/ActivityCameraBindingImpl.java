package com.eunsong.clothingmatcherbycamera.databinding;
import com.eunsong.clothingmatcherbycamera.R;
import com.eunsong.clothingmatcherbycamera.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCameraBindingImpl extends ActivityCameraBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 2);
        sViewsWithIds.put(R.id.back_key, 3);
        sViewsWithIds.put(R.id.facing_switch, 4);
        sViewsWithIds.put(R.id.preview_container, 5);
        sViewsWithIds.put(R.id.camera_preview, 6);
        sViewsWithIds.put(R.id.overlay, 7);
        sViewsWithIds.put(R.id.clothes_overlay, 8);
        sViewsWithIds.put(R.id.clothes_view, 9);
        sViewsWithIds.put(R.id.guide_title, 10);
        sViewsWithIds.put(R.id.bottom_container, 11);
        sViewsWithIds.put(R.id.pager_container, 12);
        sViewsWithIds.put(R.id.shutter_btn, 13);
        sViewsWithIds.put(R.id.picker, 14);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityCameraBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private ActivityCameraBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageView) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[11]
            , (com.eunsong.clothingmatcherbycamera.camera.CameraSourcePreview) bindings[6]
            , (android.widget.TextView) bindings[1]
            , (com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay) bindings[8]
            , (com.eunsong.clothingmatcherbycamera.custom.ImagePreview) bindings[9]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[10]
            , (com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay) bindings[7]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[12]
            , (com.yarolegovich.discretescrollview.DiscreteScrollView) bindings[14]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (android.widget.ImageView) bindings[13]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            );
        this.clothTitle.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewmodel == variableId) {
            setViewmodel((com.eunsong.clothingmatcherbycamera.CameraViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodel(@Nullable com.eunsong.clothingmatcherbycamera.CameraViewModel Viewmodel) {
        this.mViewmodel = Viewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewmodel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewmodelSelectedImageName((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewmodelSelectedImageName(androidx.lifecycle.LiveData<java.lang.String> ViewmodelSelectedImageName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        androidx.lifecycle.LiveData<java.lang.String> viewmodelSelectedImageName = null;
        java.lang.String viewmodelSelectedImageNameGetValue = null;
        com.eunsong.clothingmatcherbycamera.CameraViewModel viewmodel = mViewmodel;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewmodel != null) {
                    // read viewmodel.selectedImageName
                    viewmodelSelectedImageName = viewmodel.getSelectedImageName();
                }
                updateLiveDataRegistration(0, viewmodelSelectedImageName);


                if (viewmodelSelectedImageName != null) {
                    // read viewmodel.selectedImageName.getValue()
                    viewmodelSelectedImageNameGetValue = viewmodelSelectedImageName.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.clothTitle, viewmodelSelectedImageNameGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewmodel.selectedImageName
        flag 1 (0x2L): viewmodel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}