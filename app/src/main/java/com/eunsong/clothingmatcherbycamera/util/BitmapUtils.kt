package com.eunsong.clothingmatcherbycamera.util

import android.graphics.*
import android.hardware.Camera
import com.eunsong.clothingmatcherbycamera.model.FrameMetadata
import com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata
import timber.log.Timber
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

/** Utils functions for bitmap conversions.  */
object BitmapUtils {
    // Convert NV21 format byte buffer to bitmap.
    fun getBitmap(data: ByteBuffer, metadata: FrameMetadata): Bitmap? {
        data.rewind()
        val imageInBuffer = ByteArray(data.limit())
        data[imageInBuffer, 0, imageInBuffer.size]
        try {
            val image = YuvImage(
                    imageInBuffer, ImageFormat.NV21, metadata.width, metadata.height, null)
            if (image != null) {
                val stream = ByteArrayOutputStream()
                image.compressToJpeg(Rect(0, 0, metadata.width, metadata.height), 80, stream)
                val bmp = BitmapFactory.decodeByteArray(stream.toByteArray(), 0, stream.size())
                stream.close()
                return rotateBitmap(bmp, metadata.rotation, metadata.cameraFacing)
            }
        } catch (e: Exception) {
            Timber.tag("VisionProcessorBase").e("Error: %s", e.message)
        }
        return null
    }

    // Rotates a bitmap if it is converted from a bytebuffer.
    private fun rotateBitmap(bitmap: Bitmap, rotation: Int, facing: Int): Bitmap {
        val matrix = Matrix()
        var rotationDegree = 0
        when (rotation) {
            FirebaseVisionImageMetadata.ROTATION_90 -> rotationDegree = 90
            FirebaseVisionImageMetadata.ROTATION_180 -> rotationDegree = 180
            FirebaseVisionImageMetadata.ROTATION_270 -> rotationDegree = 270
            else -> {
            }
        }
        // Rotate the image back to straight.}
        matrix.postRotate(rotationDegree.toFloat())
        return if (facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
            Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
        } else { // Mirror the image along X axis for front-facing camera image.
            matrix.postScale(-1.0f, 1.0f)
            Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
        }
    }
}

