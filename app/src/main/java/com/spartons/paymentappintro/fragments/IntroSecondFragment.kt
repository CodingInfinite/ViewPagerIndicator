package com.spartons.paymentappintro.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.spartons.paymentappintro.R
import com.spartons.paymentappintro.enum.TypeFaceEnum
import com.spartons.paymentappintro.util.UiHelper

class IntroSecondFragment : Fragment() {

    private val uiHelper = UiHelper()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.intro_second_fragment, container, false)
        view.findViewById<TextView>(R.id.easyPaymentTextView).typeface = uiHelper.getTypeFace(TypeFaceEnum.HEADING_TYPEFACE, activity!!)
        view.findViewById<TextView>(R.id.easyPaymentSubTitleTextView).typeface = uiHelper.getTypeFace(TypeFaceEnum.SEMI_TITLE_TYPEFACE, activity!!)
        return view
    }
}