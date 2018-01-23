package com.fujiyuu75.sequent.sample;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class SampleActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout navi1;
    private LinearLayout navi2;
    private LinearLayout navi3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        viewPager = findViewById(R.id.pager);
        navi1 = findViewById(R.id.navi1);
        navi2 = findViewById(R.id.navi2);
        navi3 = findViewById(R.id.navi3);

        viewPager.setAdapter(new SampleViewPagerAdapter(
                getSupportFragmentManager()));

        viewPager.setOffscreenPageLimit(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_SETTLING) {
                    final int page = viewPager.getCurrentItem();
                    switch (page) {
                        case 0:
                            navi1.setBackgroundResource(R.drawable.tutorial_swipe_navi_selected);
                            navi2.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            navi3.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            break;
                        case 1:
                            navi1.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            navi2.setBackgroundResource(R.drawable.tutorial_swipe_navi_selected);
                            navi3.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            break;
                        case 2:
                            navi1.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            navi2.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            navi3.setBackgroundResource(R.drawable.tutorial_swipe_navi_selected);
                            break;
                    }
                }
            }
        });
    }
}
