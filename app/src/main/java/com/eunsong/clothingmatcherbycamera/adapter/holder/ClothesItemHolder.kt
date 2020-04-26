package com.eunsong.clothingmatcherbycamera.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eunsong.clothingmatcherbycamera.CameraViewModel
import com.eunsong.clothingmatcherbycamera.adapter.listener.ClothesListener
import com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem
import com.eunsong.clothingmatcherbycamera.databinding.RvClothesItemBinding

class ClothesItemHolder private constructor(private val binding: RvClothesItemBinding,
                        private val eventListener: ClothesListener
): RecyclerView.ViewHolder(binding.root) {
    fun bind(pos: Int, item: ClothesItem) {
        binding.item = item
        binding.position = pos
        binding.eventListener = eventListener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup, eventListener: ClothesListener): RecyclerView.ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = RvClothesItemBinding.inflate(layoutInflater, parent, false)
            return ClothesItemHolder(binding, eventListener)
        }
    }
}