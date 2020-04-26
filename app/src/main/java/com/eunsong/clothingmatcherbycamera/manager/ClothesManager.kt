package com.eunsong.clothingmatcherbycamera.manager

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.Pair
import android.util.Size
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.eunsong.clothingmatcherbycamera.R
import com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic
import com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.face.FirebaseVisionFace
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions
import timber.log.Timber
import java.util.ArrayList
import kotlin.math.max

class ClothesManager(
        /*private val size: Size,*/
//        private val tempView: ImageView,
        private val clothesOverlay: GraphicOverlay,
        private val requestManager: RequestManager
) {
    var clothesBitmap: Bitmap? = null

    /**
     * clothes bitmap 얻어오기
     */
    fun setupImage(targetImage: String) {

//        clothesOverlay.resources.getDrawable(R.drawable.test_image2).run { // TODO 바꾸기
//            clothesBitmap = this.toBitmap()
//        }

//        requestManager
//                .load(targetImage)
//                .centerCrop()
//                .into(tempView)
        Timber.i("url : $targetImage")
        requestManager
                .asBitmap()
                .load(targetImage)
                .into(object: CustomTarget<Bitmap>() {
                    override fun onLoadCleared(placeholder: Drawable?) {

                    }

                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                        clothesBitmap = resource
                    }
                })

    }

    /**
     * 카메라 얼굴크기에 맞춰서
     * 옷 이미지 크기 리사이징하기
     */
    fun resizeClothes(
            /*bgBitmap: Bitmap,*/
            faceInfoOfClothes: FaceContourGraphic.FaceDetectInfo,
            faceInfoOfCamera: FaceContourGraphic.FaceDetectInfo
    ): Bitmap? {
        clothesBitmap?.let {

            // 얼굴 face 사이즈에 맞게 bg resize
            val ratio = faceInfoOfCamera.rectWidth / faceInfoOfClothes.rectWidth
            val clothesSize = Size((it.width * ratio).toInt(), (it.height * ratio).toInt())

            val resizeFace = Bitmap.createScaledBitmap(it, clothesSize.width, clothesSize.height, true)
            Timber.i("resize faceBitmap : ${resizeFace.width} ${resizeFace.height}")

            return resizeFace
        }

        return null
    }


    /**
     * 1. resize
     * 2. face detect onSuccess / onFailure
     * 3. 옷 이미지 편집
     */
    fun processImage(callback: ProcessResult) {

        // resize
        clothesBitmap?.let {clothes ->
            // size check ( > 0)
            val resizedBitmap= resizeImage(/*Size(tempView.width, tempView.height)*/ Size(clothesOverlay.width, clothesOverlay.height), clothes)

            detectFace(FirebaseVisionImage.fromBitmap(resizedBitmap), object: DetectResult {
                override fun onSuccess(faces: List<FirebaseVisionFace>) {
                    // 성공 & 얼굴 정보 얻기
                    getFaceContourInfo(faces, object: FaceContourResult {
                        override fun getPoints(points: ArrayList<FaceContourGraphic.FaceContourData>, faceInfo: FaceContourGraphic.FaceDetectInfo) {
                            // 옷 이미지 편집
                            val editedImage = editClothesImage(resizedBitmap, points, faceInfo)

                            // 덮어쓰면 작은이미지에서 크게 키울경우, 이미지가 꺠질수도있음 **
                            clothesBitmap = editedImage
                            callback.onSuccess(faceInfo, editedImage)
                        }
                    })
                }

                override fun onFailure(e: String?) {
                    clothesOverlay.clear()
                    callback.onFailure(e)
                }
            })
        }
    }

    private fun editClothesImage(
            resizedBitmap: Bitmap,
            points: ArrayList<FaceContourGraphic.FaceContourData>,
            faceContourInfo: FaceContourGraphic.FaceDetectInfo
    ): Bitmap {

        val removeBg = removeImageBackground(resizedBitmap)
        val splitResult = splitImage(removeBg, faceContourInfo)

        return  splitResult
    }

    private fun removeImageBackground(splitResult: Bitmap): Bitmap {
        val points = listOf(
                Size(1, 1),
                Size(1, splitResult.height/4 * 2),
                Size(1, splitResult.height/4 * 3),
                Size(1, splitResult.height -1),
                Size( splitResult.width - 1, 1),
                Size( splitResult.width - 1, splitResult.height/4 * 2),
                Size( splitResult.width - 1, splitResult.height/4 * 3),
                Size( splitResult.width - 1, splitResult.height -1)
        )

        var removedBg: Bitmap? = null

        points.forEach {
            removedBg = removeSameColorArea(removedBg?:splitResult, it.width, it.height)
        }

        return removedBg?: splitResult
    }

    private fun splitImage(targetBitmap: Bitmap, faceContourInfo: FaceContourGraphic.FaceDetectInfo): Bitmap {

        return Bitmap.createBitmap(
                targetBitmap,
                0,
                faceContourInfo.chinBottomPos.py.toInt(),
                targetBitmap.width,
                targetBitmap.height - faceContourInfo.chinBottomPos.py.toInt()
        )
    }

    private fun getFaceContourInfo(faces: List<FirebaseVisionFace>, callback: FaceContourResult) {
        clothesOverlay.clear()

        for (i in faces.indices) {
            val face = faces[i]

            val faceGraphic = FaceContourGraphic(clothesOverlay, face) { points, faceInfo ->
                Timber.i( "point$faceInfo")
                callback.getPoints(points, faceInfo)
            }

            clothesOverlay.add(faceGraphic)
        }
    }

    interface ProcessResult {
        fun onSuccess(faceInfo: FaceContourGraphic.FaceDetectInfo,
                      editedImage: Bitmap)
        fun onFailure(e: String?)
    }

    interface DetectResult {
        fun onSuccess(faces: List<FirebaseVisionFace>)
        fun onFailure(e: String?)
    }

    interface FaceContourResult {
        fun getPoints(points: ArrayList<FaceContourGraphic.FaceContourData>,
                      faceInfo: FaceContourGraphic.FaceDetectInfo)
    }

    private fun detectFace(firebaseVisionImage: FirebaseVisionImage, callback: DetectResult) {
        try {
            val options = FirebaseVisionFaceDetectorOptions.Builder()
                    .setPerformanceMode(FirebaseVisionFaceDetectorOptions.FAST)
                    .setContourMode(FirebaseVisionFaceDetectorOptions.ALL_CONTOURS)
                    .build()
            val detector =
                    FirebaseVision.getInstance().getVisionFaceDetector(options)
            detector.detectInImage(firebaseVisionImage)
                    .addOnSuccessListener { faces ->
                        if (faces.isNotEmpty()) {
                            callback.onSuccess(faces)
                        } else {
                            callback.onFailure("face not found")
                        }
                    }
                    .addOnFailureListener { e ->
                        // Task failed with an exception
                        e.printStackTrace()
                        callback.onFailure(e.message)
                    }
        } catch (e: Exception) {
            e.printStackTrace()
            callback.onFailure(e.message)
        }
    }

    private fun resizeImage(targetSize: Size, selectBitmap: Bitmap): Bitmap {

        val targetedSize: Pair<Int, Int> = Pair(targetSize.width, targetSize.height)
        val targetWidth = targetedSize.first
        val maxHeight = targetedSize.second
        // Determine how much to scale down the image
        val scaleFactor = max(
                targetSize.width.toFloat() / targetWidth.toFloat(),
                targetSize.height.toFloat() / maxHeight.toFloat()
        )
        return Bitmap.createScaledBitmap(
                selectBitmap,
                (targetSize.width / scaleFactor).toInt(),
                (targetSize.height / scaleFactor).toInt(),
                true
        )
    }

    private fun removeSameColorArea(imageBitmap: Bitmap, px: Int, py: Int): Bitmap {
        val oldBitmap: Bitmap = imageBitmap
        val colorToReplace = oldBitmap.getPixel(px, py)
        val width = oldBitmap.width
        val height = oldBitmap.height
        val pixels = IntArray(width * height)
        oldBitmap.getPixels(pixels, 0, width, 0, 0, width, height)
        val rA = Color.alpha(colorToReplace)
        val rR = Color.red(colorToReplace)
        val rG = Color.green(colorToReplace)
        val rB = Color.blue(colorToReplace)
        var pixel: Int
        // iteration through pixels
        for (y in 0 until height) {
            for (x in 0 until width) { // get current index in 2D-matrix
                val index = y * width + x
                pixel = pixels[index]
                val rrA = Color.alpha(pixel)
                val rrR = Color.red(pixel)
                val rrG = Color.green(pixel)
                val rrB = Color.blue(pixel)
                if (rA - COLOR_TOLERANCE < rrA && rrA < rA + COLOR_TOLERANCE && rR - COLOR_TOLERANCE < rrR && rrR < rR + COLOR_TOLERANCE && rG - COLOR_TOLERANCE < rrG && rrG < rG + COLOR_TOLERANCE && rB - COLOR_TOLERANCE < rrB && rrB < rB + COLOR_TOLERANCE
                ) {
                    pixels[index] = Color.TRANSPARENT
                }
            }
        }
        val newBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        newBitmap.setPixels(pixels, 0, width, 0, 0, width, height)
        return newBitmap
    }

    companion object {
        const val COLOR_TOLERANCE = 5f
    }
}