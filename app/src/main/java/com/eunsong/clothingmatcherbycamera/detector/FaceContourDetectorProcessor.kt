package com.eunsong.clothingmatcherbycamera.detector

import android.graphics.Bitmap
import com.eunsong.clothingmatcherbycamera.camera.CameraImageGraphic
import com.eunsong.clothingmatcherbycamera.custom.ImagePreview
import com.eunsong.clothingmatcherbycamera.listener.DetectorCallback
import com.eunsong.clothingmatcherbycamera.model.FrameMetadata
import com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay
import com.eunsong.clothingmatcherbycamera.vision.VisionProcessorBase
import com.google.android.gms.tasks.Task
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.face.FirebaseVisionFace
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions
import kotlinx.coroutines.SupervisorJob
import timber.log.Timber
import java.io.IOException

class FaceContourDetectorProcessor(/*val bgImageView: ImageView,*/
                                   val overlay: GraphicOverlay,
                                   val clothesOverlay: GraphicOverlay,
                                   val clothesPreview: ImagePreview,
                                   private val detectorCallback: DetectorCallback
): VisionProcessorBase<List<FirebaseVisionFace>>(){

    private val detector: FirebaseVisionFaceDetector

    var job = SupervisorJob()

    private lateinit var originBg: Bitmap
    private var bgFaceInfo: FaceContourGraphic.FaceDetectInfo? = null

//    private lateinit var bgImageManager: BgImageManager

    init {
        val options = FirebaseVisionFaceDetectorOptions.Builder()
                .setPerformanceMode(FirebaseVisionFaceDetectorOptions.FAST)
                .setContourMode(FirebaseVisionFaceDetectorOptions.ALL_CONTOURS)
                .build()

        detector = FirebaseVision.getInstance().getVisionFaceDetector(options)


    }

    override fun detectInImage(image: FirebaseVisionImage): Task<List<FirebaseVisionFace>> {
        return detector.detectInImage(image)
    }

    override fun onSuccess(
            originalCameraImage: Bitmap?,
            results: List<FirebaseVisionFace>,
            frameMetadata: FrameMetadata,
            graphicOverlay: GraphicOverlay
    ) {
        graphicOverlay.clear()

        originalCameraImage?.let {
            val imageGraphic =
                    CameraImageGraphic(
                            graphicOverlay,
                            it
                    )
            graphicOverlay.add(imageGraphic)
        }

        if (results.isEmpty()) {
            detectorCallback.onFailureDetector("Face not found")
        } else {
            detectorCallback.onSuccessDetector(originalCameraImage, results, frameMetadata, graphicOverlay)
        }


//////////viewmodel

//        results.forEach {
//            val faceGraphic = FaceContourGraphic(
//                    graphicOverlay,
//                    it,
//                    object : ContourListener {
//                        override fun invoke(points: ArrayList<FaceContourGraphic.FaceContourData>, faceInfo: FaceContourGraphic.FaceDetectInfo) {
////                            originalCameraImage?.let { originFace -> face(originFace, points, faceInfo) }
//                        }
//                    }
//            )
//            graphicOverlay.add(faceGraphic)
//        }
//
//        graphicOverlay.postInvalidate()

    }

    override fun onFailure(e: Exception) {
        Timber.e( "Face detection failed $e")
        detectorCallback.onFailureDetector(e.message)
    }

    override fun stop() {
        try {
            detector.close()
        } catch (e: IOException) {
            Timber.e("Exception thrown while trying to close Face Contour Detector: $e")
        }
        super.stop()
    }
}