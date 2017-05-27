package com.fujiyuu75.sequent.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TutorialViewPagerAdapter extends FragmentPagerAdapter {

    public TutorialViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private String[] pageTitle = {"ホーム", "タイムライン", "アクティビティ"};

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new TutorialFragment();
            case 1:
                return new TutorialFragment1();
            case 2:
                return new TutorialFragment2();
            case 3:
                return new TutorialFragment3();
            default:
                return new TutorialFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitle[position];
    }

}
