package com.fujiyuu75.sequent.sample;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TutorialActivity extends AppCompatActivity {

    private final static String TAG = TutorialActivity.class.getSimpleName();
    private ViewPager viewPager;
    private LinearLayout navi1;
    private LinearLayout navi2;
    private LinearLayout navi3;
    private LinearLayout navi4;
    private Button nextBtn;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        viewPager = (ViewPager) findViewById(R.id.pager);
        navi1 = (LinearLayout) findViewById(R.id.navi1);
        navi2 = (LinearLayout) findViewById(R.id.navi2);
        navi3 = (LinearLayout) findViewById(R.id.navi3);
        navi4 = (LinearLayout) findViewById(R.id.navi4);

        viewPager.setAdapter(new TutorialViewPagerAdapter(
                getSupportFragmentManager()));

        viewPager.setOffscreenPageLimit(0);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
                    // Button nextBtn = (Button)
                    // findViewById(R.id.tutorial_next_button);
                    switch (page) {
                        case 0:
                            navi1.setBackgroundResource(R.drawable.tutorial_swipe_navi_selected);
                            navi2.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            navi3.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            navi4.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            break;
                        case 1:
                            navi1.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            navi2.setBackgroundResource(R.drawable.tutorial_swipe_navi_selected);
                            navi3.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            navi4.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            break;
                        case 2:
                            navi1.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            navi2.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            navi3.setBackgroundResource(R.drawable.tutorial_swipe_navi_selected);
                            navi4.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            break;
                        case 3:
                            navi1.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            navi2.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            navi3.setBackgroundResource(R.drawable.tutorial_swipe_navi);
                            navi4.setBackgroundResource(R.drawable.tutorial_swipe_navi_selected);
                            break;
                    }
                }
            }
        });

    }

    @SuppressWarnings("deprecation")
    public Drawable getDrawableResource(int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return getDrawable(id);
        } else {
            return getResources().getDrawable(id);
        }
    }
}
