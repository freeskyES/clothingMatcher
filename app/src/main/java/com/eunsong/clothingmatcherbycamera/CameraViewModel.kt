package com.eunsong.clothingmatcherbycamera

import android.graphics.Bitmap
import androidx.lifecycle.*
import com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem
import com.eunsong.clothingmatcherbycamera.detector.ContourListener
import com.eunsong.clothingmatcherbycamera.detector.FaceContourGraphic
import com.eunsong.clothingmatcherbycamera.listener.DetectorCallback
import com.eunsong.clothingmatcherbycamera.manager.ClothesManager
import com.eunsong.clothingmatcherbycamera.model.CameraParam
import com.eunsong.clothingmatcherbycamera.model.FrameMetadata
import com.eunsong.clothingmatcherbycamera.overlay.GraphicOverlay
import com.eunsong.clothingmatcherbycamera.util.Event
import com.google.firebase.ml.vision.face.FirebaseVisionFace
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class CameraViewModel(): ViewModel(), DetectorCallback {

    private val _isFrontFacing = MutableLiveData<Boolean>().apply { value = false }
    val isFrontFacing: LiveData<Boolean> = _isFrontFacing

    private val _isDetectedFace = MutableLiveData<Boolean>().apply { value = false }
    val isDetectedFace: LiveData<Boolean> = _isDetectedFace

    private val _isDetectedClothes = MutableLiveData<Boolean>().apply { value = true }
    val isDetectedClothes: LiveData<Boolean> = _isDetectedClothes

    private val _images = MutableLiveData<List<ClothesItem>>().apply { value = emptyList() }
    val images: LiveData<List<ClothesItem>> = _images

    private val _selectedImage = MutableLiveData<ClothesItem>()
    val selectedImage: LiveData<ClothesItem> = _selectedImage

    private val _selectedImageName = MutableLiveData<String>()
    val selectedImageName: LiveData<String> = _selectedImageName

    private val _updateClothesPreview = MutableLiveData<Event<Unit>>()
    val updateClothesPreview: LiveData<Event<Unit>> = _updateClothesPreview

    private val _pasteClothes = MutableLiveData<Event<Unit>>()
    val pasteClothes: LiveData<Event<Unit>> = _pasteClothes

    var faceInfoOfClothes: FaceContourGraphic.FaceDetectInfo? = null

    private lateinit var clothesManager: ClothesManager

    var finalClothes: Bitmap? = null
    var faceInfoOfCamera: FaceContourGraphic.FaceDetectInfo? = null


    fun setupClothesManager(clothesManager: ClothesManager) {
        this.clothesManager = clothesManager
    }

    fun setSelectedImage(pos: Int) {
        images.value?.run {
            if (this.size > pos) {
                _selectedImage.value = this[pos]
                onChangedSelectedImage(this[pos].productLink)
            }
        }
    }

    private fun onChangedSelectedImage(url: String) {
        clothesManager.setupImage(url)

        selectedImage.value?.run { _selectedImageName.value = this.productName }
        _isDetectedClothes.value = true
        faceInfoOfClothes = null
    }

    fun setImages(cameraParam: CameraParam) {
        _images.value = cameraParam.images
    }

    fun setFrontFacing(isFrontFacing: Boolean) {
        _isFrontFacing.value = isFrontFacing
    }

    fun toggleFrontFacing() {
        _isFrontFacing.value = isFrontFacing.value != true
    }

    override fun onSuccessDetector(originalCameraImage: Bitmap?, results: List<FirebaseVisionFace>, frameMetadata: FrameMetadata, graphicOverlay: GraphicOverlay) {
        if (isDetectedFace.value != true) _isDetectedFace.value = true

        setupClothes(results, graphicOverlay)

        setFaceContour(originalCameraImage, results, frameMetadata, graphicOverlay)
    }

    private fun setFaceContour(
            originalCameraImage: Bitmap?,
            results: List<FirebaseVisionFace>,
            frameMetadata: FrameMetadata,
            graphicOverlay: GraphicOverlay
    ) {
        results.forEach {
            val faceGraphic = FaceContourGraphic(
                    graphicOverlay,
                    it,
                    object : ContourListener {
                        override fun invoke(points: ArrayList<FaceContourGraphic.FaceContourData>, faceInfo: FaceContourGraphic.FaceDetectInfo) {
//                            originalCameraImage?.let { originFace -> face(originFace, points, faceInfo) }
                            updateClothes(originalCameraImage, points, faceInfo)
                        }
                    }
            )
            graphicOverlay.add(faceGraphic)
        }

        graphicOverlay.postInvalidate()
    }


    /**
     * 얼굴 감지 실패
     */
    override fun onFailureDetector(e: String?) {
        Timber.tag("onFailureDetector").i("$e")
        if (isDetectedFace.value != false) _isDetectedFace.value = false
    }

    /**
     * 카메라 얼굴 감지되었을떄,
     * 옷을 카메라 얼굴에 맞게 업데이트하기
     */
    private fun updateClothes(
            originalCameraImage: Bitmap?,
            points: ArrayList<FaceContourGraphic.FaceContourData>,
            faceInfoOfCam: FaceContourGraphic.FaceDetectInfo) {

        originalCameraImage?.let { originFace ->
            faceInfoOfClothes?.let {
                viewModelScope.launch(Dispatchers.IO) {
                    clothesManager.resizeClothes(it, faceInfoOfCam)?.run {
                        finalClothes = this
                        faceInfoOfCamera = faceInfoOfCam
                        withContext(Dispatchers.Main) {
                            _pasteClothes.value = Event(Unit)
                        }
                    }
                }
            }



        }
    }

    private fun setupClothes(
            results: List<FirebaseVisionFace>,
            graphicOverlay: GraphicOverlay
    ) {
        // 선택된 이미지의 정보 한번만 얻어오기
        if (faceInfoOfClothes == null && isDetectedClothes.value == true) {
            viewModelScope.launch(Dispatchers.IO) {
                clothesManager.processImage(object : ClothesManager.ProcessResult {
                    override fun onSuccess(faceInfo: FaceContourGraphic.FaceDetectInfo, editedImage: Bitmap) {
                        // 옷 얼굴 감지됨
                        Timber.tag("setupClothes").i("onSuccess")
                        if (isDetectedClothes.value != true) _isDetectedClothes.value = true

                        faceInfoOfClothes = faceInfo
                        _updateClothesPreview.value = Event(Unit)
                    }

                    override fun onFailure(e: String?) {
                        Timber.tag("setupClothes").i("onFailure $e")
                        if (isDetectedClothes.value != false) _isDetectedClothes.value = false

                    }
                })
            }
        }
    }

}