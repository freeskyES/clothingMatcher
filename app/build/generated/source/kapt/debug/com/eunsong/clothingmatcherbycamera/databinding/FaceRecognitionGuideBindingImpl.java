package com.eunsong.clothingmatcherbycamera.databinding;
import com.eunsong.clothingmatcherbycamera.R;
import com.eunsong.clothingmatcherbycamera.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FaceRecognitionGuideBindingImpl extends FaceRecognitionGuideBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.vertical_guideline_start, 1);
        sViewsWithIds.put(R.id.guide_image, 2);
        sViewsWithIds.put(R.id.vertical_guideline, 3);
        sViewsWithIds.put(R.id.guide_title, 4);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FaceRecognitionGuideBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private FaceRecognitionGuideBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[4]
            , (androidx.constraintlayout.widget.Guideline) bindings[3]
            , (androidx.constraintlayout.widget.Guideline) bindings[1]
            );
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
                return onChangeViewmodelIsDetectedFace((androidx.lifecycle.LiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewmodelIsDetectedFace(androidx.lifecycle.LiveData<java.lang.Boolean> ViewmodelIsDetectedFace, int fieldId) {
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
        boolean androidxDatabindingViewDataBindingSafeUnboxViewmodelIsDetectedFaceGetValue = false;
        java.lang.Boolean viewmodelIsDetectedFaceGetValue = null;
        boolean viewmodelIsDetectedFace = false;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewmodelIsDetectedFace = false;
        androidx.lifecycle.LiveData<java.lang.Boolean> ViewmodelIsDetectedFace1 = null;
        com.eunsong.clothingmatcherbycamera.CameraViewModel viewmodel = mViewmodel;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewmodel != null) {
                    // read viewmodel.isDetectedFace
                    ViewmodelIsDetectedFace1 = viewmodel.isDetectedFace();
                }
                updateLiveDataRegistration(0, ViewmodelIsDetectedFace1);


                if (ViewmodelIsDetectedFace1 != null) {
                    // read viewmodel.isDetectedFace.getValue()
                    viewmodelIsDetectedFaceGetValue = ViewmodelIsDetectedFace1.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(viewmodel.isDetectedFace.getValue())
                androidxDatabindingViewDataBindingSafeUnboxViewmodelIsDetectedFaceGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewmodelIsDetectedFaceGetValue);


                // read !androidx.databinding.ViewDataBinding.safeUnbox(viewmodel.isDetectedFace.getValue())
                viewmodelIsDetectedFace = !androidxDatabindingViewDataBindingSafeUnboxViewmodelIsDetectedFaceGetValue;


                // read androidx.databinding.ViewDataBinding.safeUnbox(!androidx.databinding.ViewDataBinding.safeUnbox(viewmodel.isDetectedFace.getValue()))
                androidxDatabindingViewDataBindingSafeUnboxViewmodelIsDetectedFace = androidx.databinding.ViewDataBinding.safeUnbox(viewmodelIsDetectedFace);
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            com.eunsong.clothingmatcherbycamera.binding.BindingAdaptersKt.showHide(this.mboundView0, androidxDatabindingViewDataBindingSafeUnboxViewmodelIsDetectedFace);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewmodel.isDetectedFace
        flag 1 (0x2L): viewmodel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}