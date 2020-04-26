package com.eunsong.clothingmatcherbycamera.util

import android.content.res.Resources

class CommonUtils {

    companion object {
        fun dpToPx(dp: Int): Int {
            return (dp * Resources.getSystem().displayMetrics.density).toInt()
        }
    }
}