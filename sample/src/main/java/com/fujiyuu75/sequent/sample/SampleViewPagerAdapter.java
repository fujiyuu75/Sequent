package com.fujiyuu75.sequent.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class SampleViewPagerAdapter extends FragmentPagerAdapter {

    SampleViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private String[] pageTitle = {"page1", "page2", "page3"};

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new SampleFragment1();
            case 1:
                return new SampleFragment2();
            case 2:
                return new SampleFragment3();
            default:
                return new SampleFragment1();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitle[position];
    }

}
