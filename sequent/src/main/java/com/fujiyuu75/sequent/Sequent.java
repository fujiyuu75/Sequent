package com.fujiyuu75.sequent;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import static android.content.ContentValues.TAG;

/**
 * Created by y_fujikawa on 2017/05/24.
 */
public class Sequent {

    private static int number = 0;
    private static int startOffset = 50;
    private static int duration = 500;

    public static void start(ViewGroup vg) {
        findChildLayouts(vg);
    }

    private static void findChildLayouts(ViewGroup viewGroup) {
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

    private static void setAnimation(View v) {
        AlphaAnimation anim = new AlphaAnimation(0, 1);
        anim.setStartOffset(number * startOffset);
        anim.setDuration(number * duration);
        v.setAnimation(anim);

        number++;
    }
}
