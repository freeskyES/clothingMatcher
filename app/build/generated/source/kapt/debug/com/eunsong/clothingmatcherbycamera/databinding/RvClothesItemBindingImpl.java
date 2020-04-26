package com.eunsong.clothingmatcherbycamera.databinding;
import com.eunsong.clothingmatcherbycamera.R;
import com.eunsong.clothingmatcherbycamera.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class RvClothesItemBindingImpl extends RvClothesItemBinding implements com.eunsong.clothingmatcherbycamera.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    @NonNull
    private final android.widget.ImageView mboundView1;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public RvClothesItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }
    private RvClothesItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            );
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.ImageView) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.eunsong.clothingmatcherbycamera.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.item == variableId) {
            setItem((com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem) variable);
        }
        else if (BR.eventListener == variableId) {
            setEventListener((com.eunsong.clothingmatcherbycamera.adapter.listener.ClothesListener) variable);
        }
        else if (BR.position == variableId) {
            setPosition((java.lang.Integer) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setEventListener(@Nullable com.eunsong.clothingmatcherbycamera.adapter.listener.ClothesListener EventListener) {
        this.mEventListener = EventListener;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.eventListener);
        super.requestRebind();
    }
    public void setPosition(@Nullable java.lang.Integer Position) {
        this.mPosition = Position;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.position);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem item = mItem;
        com.eunsong.clothingmatcherbycamera.adapter.listener.ClothesListener eventListener = mEventListener;
        java.lang.Integer position = mPosition;
        java.lang.String itemProductLink = null;

        if ((dirtyFlags & 0x9L) != 0) {



                if (item != null) {
                    // read item.productLink
                    itemProductLink = item.getProductLink();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            com.eunsong.clothingmatcherbycamera.binding.BindingAdaptersKt.imageUrl(this.mboundView1, itemProductLink);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // item
        com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem item = mItem;
        // eventListener
        com.eunsong.clothingmatcherbycamera.adapter.listener.ClothesListener eventListener = mEventListener;
        // position
        java.lang.Integer position = mPosition;
        // eventListener != null
        boolean eventListenerJavaLangObjectNull = false;



        eventListenerJavaLangObjectNull = (eventListener) != (null);
        if (eventListenerJavaLangObjectNull) {




            eventListener.onClothesItemClicked(position, item);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): eventListener
        flag 2 (0x3L): position
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}