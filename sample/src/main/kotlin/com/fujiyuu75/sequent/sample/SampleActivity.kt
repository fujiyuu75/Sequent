package com.fujiyuu75.sequent.sample

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout

class SampleActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var navi1: LinearLayout
    private lateinit var navi2: LinearLayout
    private lateinit var navi3: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        viewPager = findViewById(R.id.pager)
        navi1 = findViewById(R.id.navi1)
        navi2 = findViewById(R.id.navi2)
        navi3 = findViewById(R.id.navi3)

        viewPager.apply {
            adapter = SampleViewPagerAdapter(supportFragmentManager)
            offscreenPageLimit = 0
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageSelected(position: Int) {}

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

                override fun onPageScrollStateChanged(state: Int) {
                    if (state != ViewPager.SCROLL_STATE_SETTLING) {
                        return
                    }
                    val page = viewPager.currentItem
                    when (page) {
                        0 -> {
                            navi1.setBackgroundResource(R.drawable.tutorial_swipe_navi_selected)
                            navi2.setBackgroundResource(R.drawable.tutorial_swipe_navi)
                            navi3.setBackgroundResource(R.drawable.tutorial_swipe_navi)
                        }
                        1 -> {
                            navi1.setBackgroundResource(R.drawable.tutorial_swipe_navi)
                            navi2.setBackgroundResource(R.drawable.tutorial_swipe_navi_selected)
                            navi3.setBackgroundResource(R.drawable.tutorial_swipe_navi)
                        }
                        2 -> {
                            navi1.setBackgroundResource(R.drawable.tutorial_swipe_navi)
                            navi2.setBackgroundResource(R.drawable.tutorial_swipe_navi)
                            navi3.setBackgroundResource(R.drawable.tutorial_swipe_navi_selected)
                        }
                    }
                }
            })
        }
    }

}
