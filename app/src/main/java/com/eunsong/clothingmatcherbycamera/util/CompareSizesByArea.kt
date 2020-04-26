package com.eunsong.clothingmatcherbycamera.util

import androidx.annotation.RequiresApi
import com.eunsong.clothingmatcherbycamera.camera.CameraSource
import com.google.android.gms.common.images.Size
import java.lang.Long.signum

import java.util.Comparator

/**
 * Compares two `Size`s based on their areas.
 */
@RequiresApi(21)
internal class CompareSizesByArea : Comparator<CameraSource.SizePair> {

    // We cast here to ensure the multiplications won't overflow
    override fun compare(lhs: CameraSource.SizePair, rhs: CameraSource.SizePair) =
            signum(lhs.preview.width.toLong() * lhs.preview.height - rhs.preview.width.toLong() * rhs.preview.height)

}
