package com.spartons.paymentappintro

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.spartons.paymentappintro.adapter.MyPagerAdapter
import com.spartons.paymentappintro.enum.TypeFaceEnum
import com.spartons.paymentappintro.fragments.IntroFirstFragment
import com.spartons.paymentappintro.fragments.IntroSecondFragment
import com.spartons.paymentappintro.fragments.IntroThirdFragment
import com.spartons.paymentappintro.listener.ViewPagerListener
import com.spartons.paymentappintro.util.UiHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val MIN_SCALE = 0.65f
        private const val MIN_ALPHA = 0.3f
    }

    private lateinit var pagerAdapterView: MyPagerAdapter
    private val uiHelper = UiHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        pagerAdapterView = MyPagerAdapter(supportFragmentManager)
        addPagerFragments()
        myViewPager.adapter = pagerAdapterView
        myViewPager.setPageTransformer(true, this::zoomOutTransformation)
        getStartedButton.typeface = uiHelper.getTypeFace(TypeFaceEnum.BUTTON_TEXT, this)
        myViewPager.addOnPageChangeListener(ViewPagerListener(this::onPageSelected))
    }

    private fun onPageSelected(position: Int) {
        when (position) {
            0 -> {
                firstDotImageView.setImageResource(R.drawable.current_position_icon)
                secondDotImageView.setImageResource(R.drawable.disable_position_icon)
                thirdDotImageView.setImageResource(R.drawable.disable_position_icon)
            }
            1 -> {
                firstDotImageView.setImageResource(R.drawable.disable_position_icon)
                secondDotImageView.setImageResource(R.drawable.current_position_icon)
                thirdDotImageView.setImageResource(R.drawable.disable_position_icon)
            }
            2 -> {
                firstDotImageView.setImageResource(R.drawable.disable_position_icon)
                secondDotImageView.setImageResource(R.drawable.disable_position_icon)
                thirdDotImageView.setImageResource(R.drawable.current_position_icon)
            }
        }
    }

    private fun addPagerFragments() {
        pagerAdapterView.addFragments(IntroFirstFragment())
        pagerAdapterView.addFragments(IntroSecondFragment())
        pagerAdapterView.addFragments(IntroThirdFragment())
    }

    private fun zoomOutTransformation(page: View, position: Float) {
        when {
            position < -1 ->
                page.alpha = 0f
            position <= 1 -> {
                page.scaleX = Math.max(MIN_SCALE, 1 - Math.abs(position))
                page.scaleY = Math.max(MIN_SCALE, 1 - Math.abs(position))
                page.alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position))
            }
            else -> page.alpha = 0f
        }
    }
}
