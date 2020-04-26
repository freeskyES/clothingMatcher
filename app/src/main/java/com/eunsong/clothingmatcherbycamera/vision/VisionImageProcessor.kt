package com.eunsong.clothingmatcherbycamera.vision

import com.eunsong.clothingmatcherbycamera.model.FrameMetadata
import com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay
import com.google.firebase.ml.common.FirebaseMLException
import java.nio.ByteBuffer

interface VisionImageProcessor {
    /** Processes the images with the underlying machine learning models.  */
    @Throws(FirebaseMLException::class)
    fun process(data: ByteBuffer, frameMetadata: FrameMetadata, graphicOverlay: GraphicOverlay)

    /** Processes the bitmap images.  */
//    fun process(bitmap: Bitmap?, graphicOverlay: GraphicOverlay?)

    /** Stops the underlying machine learning model and release resources.  */
    fun stop()
}