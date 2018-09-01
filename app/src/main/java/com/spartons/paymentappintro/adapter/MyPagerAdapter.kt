package com.spartons.paymentappintro.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var fragmentList: MutableList<Fragment> = ArrayList()

    override fun getItem(position: Int) = fragmentList[position]

    override fun getCount() = fragmentList.size

    fun addFragments(fragment: Fragment) = fragmentList.add(fragment)
}