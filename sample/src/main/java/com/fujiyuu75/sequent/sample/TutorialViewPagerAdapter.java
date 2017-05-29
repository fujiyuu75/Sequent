package com.fujiyuu75.sequent.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class TutorialViewPagerAdapter extends FragmentPagerAdapter {

    TutorialViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private String[] pageTitle = {"page1", "page2", "page3"};

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
