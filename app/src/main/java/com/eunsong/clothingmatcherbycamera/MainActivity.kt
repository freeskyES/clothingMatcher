package com.eunsong.clothingmatcherbycamera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem
import com.eunsong.clothingmatcherbycamera.model.CameraParam

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startCamera()
    }

    private fun startCamera() {
        val cameraParam = CameraParam(listOf(/*"https://gomst-images.s3.us-west-2.amazonaws.com/products/a99a5dab6fd55ee98b96478f2102a11f_o",*/
                ClothesItem("1", "name1", "https://gomst-images.s3.us-west-2.amazonaws.com/products/bb02538b93e7f9569966df300478d13f_o"),
                ClothesItem("2","name2","https://gomst-images.s3.us-west-2.amazonaws.com/products/984f51c519fc6361a8a3f92058c2155c_l"),
                ClothesItem("3","name3","https://gomst-images.s3.us-west-2.amazonaws.com/products/e3847190757010d8bcce434d6dec5ec7_o"),
                ClothesItem("4","name4","https://gomst-images.s3.us-west-2.amazonaws.com/products/e3847190757010d8bcce434d6dec5ec7_o"),
                ClothesItem("5","name5","https://gomst-images.s3.us-west-2.amazonaws.com/products/e3847190757010d8bcce434d6dec5ec7_o"),
                ClothesItem("6","name6","https://gomst-images.s3.us-west-2.amazonaws.com/products/e3847190757010d8bcce434d6dec5ec7_o"),
                ClothesItem("7","name7","https://gomst-images.s3.us-west-2.amazonaws.com/products/e3847190757010d8bcce434d6dec5ec7_o")))
        val requestCode = 1

        startActivityForResult(CameraActivity.startIntent(this, cameraParam), requestCode)
    }
}
