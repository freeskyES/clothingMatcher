package com.eunsong.clothingmatcherbycamera.binding

import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.eunsong.clothingmatcherbycamera.R
import com.eunsong.clothingmatcherbycamera.adapter.ClothesPickerAdapter
import com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem
import com.yarolegovich.discretescrollview.DiscreteScrollView
import timber.log.Timber


@BindingAdapter("visibleGone")
fun showHide(view: View, show: Boolean) {
    Timber.tag("visibleGone").i("$show")
    view.visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter(value = ["imageUrl"], requireAll = false)
fun imageUrl(imageView: ImageView, imageUrl: String?) {
    Glide.with(imageView)
            .load(imageUrl?.toUri())
            .placeholder(ColorDrawable(imageView.context.getColor(R.color.grayColor)))
            .error(Glide.with(imageView).load(R.drawable.ic_gomst_error).centerCrop())
            .override(imageView.width, imageView.width)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)
}

@BindingAdapter("clothesItems")
fun DiscreteScrollView.setClothesItem(items: List<ClothesItem>) {

    adapter?.let {
        if (adapter is ClothesPickerAdapter) {
            (adapter as ClothesPickerAdapter).submitList(items.toMutableList())
        }
    }
}
