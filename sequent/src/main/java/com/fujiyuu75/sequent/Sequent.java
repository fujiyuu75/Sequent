package com.fujiyuu75.sequent;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

/**
 * Created by y_fujikawa on 2017/05/24.
 */
public class Sequent {
    private static final String TAG = "Sequent";

    private static final int DEFAULT_OFFSET = 50;
    private static final int DEFAULT_DURATION = 300;

    private static int number = 0;
    private static int startOffset = 50;
    private static int duration = 500;

    public static void start(ViewGroup vg) {
        Log.d(TAG, String.format("%s %s", "start", "in"));
        findChildLayouts(vg);
    }

    protected static void findChildLayouts(ViewGroup viewGroup) {
        int count = viewGroup.getChildCount();
        Log.d(TAG, String.format("%s %s", "count", String.valueOf(count)));

        for (int i = 0; i < count; i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof ViewGroup) {
                Log.d(TAG, String.format("%s %s", "find", "viewGroup"));
                findChildLayouts((ViewGroup) view);
            } else {
                Log.d(TAG, String.format("%s %s", "find", "view"));
                setAnimation(view);
            }
            Log.d(TAG, String.format("%s %s %s %s", "child", viewGroup.getClass().getName(), "id", String.valueOf(viewGroup.getId())));
        }


    }

    protected static void setAnimation(View v) {
        AlphaAnimation anim = new AlphaAnimation(0, 1);
        anim.setStartOffset(number * startOffset);
        anim.setDuration(number * duration);
        v.setAnimation(anim);

        number++;
    }
}
