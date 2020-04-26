package com.eunsong.clothingmatcherbycamera.model

import com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem
import java.io.Serializable

data class CameraParam(
        val images: List<ClothesItem>
): Serializable