package com.eunsong.clothingmatcherbycamera

import android.app.Application
import com.eunsong.clothingmatcherbycamera.di.cameraModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class CameraApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        initTimber()

        startKoin {
            androidLogger()
            androidContext(this@CameraApplication)
            modules(mutableListOf(cameraModule))
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }


}