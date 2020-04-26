package com.eunsong.clothingmatcherbycamera.adapter

import androidx.recyclerview.widget.DiffUtil
import com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem

class ClothesPickerDiffCallback : DiffUtil.ItemCallback<ClothesItem>() {
    override fun areItemsTheSame(oldItem: ClothesItem, newItem: ClothesItem): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: ClothesItem, newItem: ClothesItem): Boolean {
        return oldItem.productLink == newItem.productLink
    }
}