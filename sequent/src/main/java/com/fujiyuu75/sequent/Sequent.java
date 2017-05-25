package com.fujiyuu75.sequent;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by y_fujikawa on 2017/05/24.
 */
public class Sequent {
    private static final String TAG = "Sequent";

    private List<View> viewList = new ArrayList<>();
    private ViewGroup vg;
    private final int startOffset;
    private final int duration;

    public static class Builder {
        private static final int DEFAULT_OFFSET = 50;
        private static final int DEFAULT_DURATION = 300;

        private ViewGroup vg;
        private int startOffset = DEFAULT_OFFSET;
        private int duration = DEFAULT_DURATION;

        Builder(ViewGroup vg) {
            this.vg = vg;
        }

        public Builder offset(int offset) {
            this.startOffset = offset;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Sequent start() {
            return new Sequent(this);
        }
    }

    public static Builder origin(ViewGroup vg) {
        Log.d(TAG, String.format("%s %s", "origin", "in"));
        return new Builder(vg);
    }

    private Sequent(Builder builder) {
        this.vg = builder.vg;
        this.startOffset = builder.startOffset;
        this.duration = builder.duration;

        fetchChildLayouts(vg);
        setAnimation();
    }

    protected void fetchChildLayouts(ViewGroup viewGroup) {
        int count = viewGroup.getChildCount();
        Log.d(TAG, String.format("%s %s", "count", String.valueOf(count)));

        for (int i = 0; i < count; i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof ViewGroup) {
                Log.d(TAG, String.format("%s %s", "find", "viewGroup"));
                fetchChildLayouts((ViewGroup) view);
            } else {
                Log.d(TAG, String.format("%s %s", "find", "view"));
                viewList.add(view);
//                setAnimation(view);
            }
            Log.d(TAG, String.format("%s %s %s %s", "child", viewGroup.getClass().getName(), "id", String.valueOf(viewGroup.getId())));
        }
    }

    protected void setAnimation() {
        int count = viewList.size();
        Log.d(TAG, String.format("%s %s", "viewList.size()", viewList.size()));
        for (int i = 0; i < count; i++){
            AlphaAnimation anim = new AlphaAnimation(0, 1);
            anim.setStartOffset(i * startOffset);
            anim.setDuration(duration);
            Log.d(TAG, String.format("%s %s", i * startOffset, i * duration));
            viewList.get(i).setAnimation(anim);
        }
    }
}
