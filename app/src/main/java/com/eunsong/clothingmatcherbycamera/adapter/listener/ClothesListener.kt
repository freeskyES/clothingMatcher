package com.eunsong.clothingmatcherbycamera.adapter.listener

import com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem

interface ClothesListener {

    fun onClothesItemClicked(pos: Int, clothesItem: ClothesItem)
}