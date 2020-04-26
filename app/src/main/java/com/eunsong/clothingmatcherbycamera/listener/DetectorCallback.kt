package com.eunsong.clothingmatcherbycamera.listener

import android.graphics.Bitmap
import com.eunsong.clothingmatcherbycamera.model.FrameMetadata
import com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay
import com.google.firebase.ml.vision.face.FirebaseVisionFace

interface DetectorCallback {
    fun onSuccessDetector(
            originalCameraImage: Bitmap?,
            results: List<FirebaseVisionFace>,
            frameMetadata: FrameMetadata,
            graphicOverlay: GraphicOverlay
    )

    fun onFailureDetector(e: String?)
}