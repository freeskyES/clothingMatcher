package com.eunsong.clothingmatcherbycamera

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.hardware.Camera
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.util.Size
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.eunsong.clothingmatcherbycamera.adapter.ClothesPickerAdapter
import com.eunsong.clothingmatcherbycamera.adapter.holder.ClothesItemHolder
import com.eunsong.clothingmatcherbycamera.adapter.listener.ClothesListener
import com.eunsong.clothingmatcherbycamera.adapter.model.ClothesItem
import com.eunsong.clothingmatcherbycamera.camera.CameraSource
import com.eunsong.clothingmatcherbycamera.databinding.ActivityCameraBinding
import com.eunsong.clothingmatcherbycamera.detector.FaceContourDetectorProcessor
import com.eunsong.clothingmatcherbycamera.listener.CameraCallback
import com.eunsong.clothingmatcherbycamera.manager.ClothesManager
import com.eunsong.clothingmatcherbycamera.model.CameraParam
import com.eunsong.clothingmatcherbycamera.util.EventObserver
import com.google.firebase.ml.common.FirebaseMLException
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import kotlinx.android.synthetic.main.activity_camera.*
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber
import java.io.IOException

class CameraActivity : AppCompatActivity(),
    DiscreteScrollView.OnItemChangedListener<ClothesItemHolder>,
    ClothesListener {

    private lateinit var viewDataBinding: ActivityCameraBinding

    private val viewmodel: CameraViewModel by viewModel()

    private var cameraSource: CameraSource? = null
//    private lateinit var faceImagePreview: ImagePreview

    private val requiredPermissions: Array<String?>
        get() {
            return try {
                val info = this.packageManager
                        .getPackageInfo(this.packageName, PackageManager.GET_PERMISSIONS)
                val ps = info.requestedPermissions
                if (ps != null && ps.isNotEmpty()) {
                    ps
                } else {
                    arrayOfNulls(0)
                }
            } catch (e: Exception) {
                arrayOfNulls(0)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.apply { statusBarColor = Color.WHITE}

        val cameraParam = intent.getSerializableExtra(CAMERA_PARAM)

        cameraParam?.let {
            viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_camera)
            viewDataBinding.viewmodel = viewmodel
            viewDataBinding.lifecycleOwner = this

            // image setting
            val metrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(metrics)

            viewmodel.setupClothesManager(ClothesManager(/*viewDataBinding.tempView*//*Size(metrics.widthPixels, metrics.heightPixels)*/ viewDataBinding.clothesOverlay, Glide.with(this)))
            viewmodel.setImages(it as CameraParam)
            viewmodel.setSelectedImage(0)
            // default frontFacing
            viewmodel.setFrontFacing(true)

            viewDataBinding.facingSwitch.setOnClickListener {
                changeFacing()
            }

            checkCamera()
            setupCamera()
            setupEvents()
            setupPicker()

        }?: run {
            Timber.e("camera param is null")
            finish()
        }
    }

    private fun setupPicker() {
        viewDataBinding.picker.apply {
            adapter = ClothesPickerAdapter(this@CameraActivity).apply {
                submitList(viewmodel.images.value?.toMutableList())
            }

            setItemTransformer(ScaleTransformer.Builder()
                    .setMinScale(0.82f)
                    .build()
            )
            addOnItemChangedListener(this@CameraActivity)
            setSlideOnFling(true)
            smoothScrollToPosition(0)
            setItemTransitionTimeMillis(300)
//            addItemDecoration(HorizontalSpaceDecoration(CommonUtils.dpToPx(16)))
        }

    }

    override fun onCurrentItemChanged(
            holder: ClothesItemHolder?,
            position: Int
    ) {

        viewmodel.setSelectedImage(position)
    }

    override fun onClothesItemClicked(
            pos: Int,
            clothesItem: ClothesItem
    ) {
        viewDataBinding.picker.smoothScrollToPosition(pos)
        viewmodel.setSelectedImage(pos)
    }

    private fun setupCamera() {
        if (allPermissionsGranted()) {
            createCameraSource()
        } else {
            getRuntimePermissions()
        }
    }

    private fun setupEvents() {
        viewDataBinding.backKey.setOnClickListener {
            finish()
        }

        viewDataBinding.facingSwitch.setOnClickListener {

        }

        viewmodel.updateClothesPreview.observe(this, EventObserver {
            viewmodel.faceInfoOfClothes?.run { viewDataBinding.clothesView.updatePreviewInfo(this, Size(viewDataBinding.clothesOverlay.width, viewDataBinding.clothesOverlay.height)) }
        })

        viewmodel.pasteClothes.observe(this, EventObserver {
            viewmodel.faceInfoOfCamera?.let { faceInfoOfCam ->
                viewmodel.finalClothes?.let {
                    viewDataBinding.clothesView.run(it, faceInfoOfCam)
                }
            }
        })
    }

    private fun getRuntimePermissions() {
        val allNeededPermissions = arrayListOf<String>()
        for (permission in requiredPermissions) {
            permission?.run {
                if (!isPermissionGranted(this)) allNeededPermissions.add(permission)
            }
        }

        if (allNeededPermissions.isNotEmpty()) {
            ActivityCompat.requestPermissions(
                    this, allNeededPermissions.toTypedArray(),
                    PERMISSION_REQUESTS
            )
        }
    }

    private fun createCameraSource() {
        cameraSource?:run{
            cameraSource = CameraSource(this, overlay, object: CameraCallback {
                override fun readyCamera() {
                    Log.v("test","1."+viewDataBinding.cameraPreview.height);
                    Log.v("test","2."+viewDataBinding.previewContainer.height);
                    Log.v("test","3."+viewDataBinding.overlay.height);

                    viewDataBinding.previewContainer.layoutParams = ConstraintLayout.LayoutParams(viewDataBinding.overlay.width, viewDataBinding.overlay.height).apply {
                        topToBottom = viewDataBinding.toolbar.id
                        bottomToTop = viewDataBinding.bottomContainer.id
//                        topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    }
                    viewDataBinding.previewContainer.requestLayout()


                }
            })
        }

        try {

            Timber.i( "Using Face Contour Detector Processor")
            cameraSource?.setMachineLearningFrameProcessor(
                FaceContourDetectorProcessor(viewDataBinding.overlay, viewDataBinding.clothesOverlay, viewDataBinding.clothesView, viewmodel)
            )

        } catch (e: FirebaseMLException) {
            Timber.e( "can not create camera source: Face Contour")
        }
    }

    /**
     * camera 가 1개일경우, front camera 접근 막기
     */
    private fun checkCamera() {
        if (Camera.getNumberOfCameras() == 1) {
            viewDataBinding.facingSwitch.visibility = View.GONE
            viewmodel.setFrontFacing(false)
        }
    }

    private fun changeFacing() {
        cameraSource?.let {
            viewmodel.toggleFrontFacing()

            if (viewmodel.isFrontFacing.value == true) {
                it.setFacing(CameraSource.CAMERA_FACING_FRONT)
            } else {
                it.setFacing(CameraSource.CAMERA_FACING_BACK)
            }
        }
        viewDataBinding.cameraPreview.stop()
        startCamera()

    }

    private fun startCamera() {
        cameraSource?.let { cameraSource ->
            try {
                viewDataBinding.cameraPreview.start(cameraSource, viewDataBinding.overlay)

            } catch (e: IOException) {
                Timber.e("Unable to start camera source.")
                cameraSource.release()
                this.cameraSource = null
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume")
        startCamera()

    }

    override fun onPause() {
        super.onPause()
        viewDataBinding.cameraPreview.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraSource?.release()
    }

    private fun allPermissionsGranted(): Boolean {
        for(permission in requiredPermissions) {
            permission?.run {
                if (!isPermissionGranted(this)) return false
            }
        }
        return true
    }

    private fun isPermissionGranted(permission: String): Boolean {
        if (ContextCompat.checkSelfPermission(this, permission)
                == PackageManager.PERMISSION_GRANTED) {
            Timber.i("Permission granted: $permission")
            return true
        }
        Timber.i("Permission NOT granted: $permission")
        return false
    }

    companion object {
        private const val PERMISSION_REQUESTS = 1

        private const val CAMERA_PARAM = "camera_param"

        @JvmStatic
        fun startIntent(context: Context, cameraParam: CameraParam): Intent =
                Intent(context, CameraActivity::class.java).apply {
                    putExtra(CAMERA_PARAM, cameraParam)
                }
    }

}
