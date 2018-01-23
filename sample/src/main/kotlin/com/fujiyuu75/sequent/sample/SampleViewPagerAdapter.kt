package com.fujiyuu75.sequent.sample

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

internal class SampleViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val pageTitle = arrayOf("page1", "page2", "page3")

    override fun getItem(i: Int): Fragment = when (i) {
            0 -> SampleFragment1()
            1 -> SampleFragment2()
            2 -> SampleFragment3()
            else -> SampleFragment1()
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return pageTitle[position]
    }

}
