package com.spartons.paymentappintro.util

import android.graphics.Typeface
import android.app.Activity
import com.spartons.paymentappintro.enum.TypeFaceEnum


class UiHelper {

    /**
     * check which type is requested as an enum parameter and return the actual typeface.
     *
     * @param typeFaceEnum enum type like may be Kingthings_Foundation.ttf
     * @param activity     required for to create assets.
     * @return return a typeface which is requested by as an enum parameter.
     */

    fun getTypeFace(typeFaceEnum: TypeFaceEnum, activity: Activity): Typeface {
        return Typeface.createFromAsset(activity.assets, typeFaceEnum.getName())
    }
}