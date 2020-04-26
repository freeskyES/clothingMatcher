package com.eunsong.clothingmatcherbycamera.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eunsong.clothingmatcherbycamera.adapter.holder.ClothesItemHolder
import com.eunsong.clothingmatcherbycamera.adapter.listener.ClothesListener
import com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem

class ClothesPickerAdapter(
        private val eventListener: ClothesListener
) :
    ListAdapter<ClothesItem, RecyclerView.ViewHolder>(ClothesPickerDiffCallback()) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ClothesItemHolder.from(parent, eventListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ClothesItemHolder).bind(position, getItem(position))
    }

}