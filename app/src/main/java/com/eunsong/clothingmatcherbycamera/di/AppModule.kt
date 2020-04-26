package com.eunsong.clothingmatcherbycamera.di

import com.eunsong.clothingmatcherbycamera.CameraViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cameraModule = module {

    viewModel { CameraViewModel() }

}