package com.fujiyuu75.sequent;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import java.util.ArrayList;
import java.util.Collections;
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
    private final Direction direction;

    public static class Builder {
        private static final int DEFAULT_OFFSET = 70;
        private static final int DEFAULT_DURATION = 500;

        private ViewGroup vg;
        private int startOffset = DEFAULT_OFFSET;
        private int duration = DEFAULT_DURATION;
        private Direction direction = Direction.FORWARD;

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

        public Builder flow(Direction direction) {
            this.direction = direction;
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
        this.direction = builder.direction;

        fetchChildLayouts(vg);
        arrangeLayouts(viewList);
        setAnimation();
    }

    private void fetchChildLayouts(ViewGroup viewGroup) {
        int count = viewGroup.getChildCount();
        Log.d(TAG, String.format("%s %s", "count", String.valueOf(count)));

        for (int i = 0; i < count; i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof ViewGroup) {
                Log.d(TAG, String.format("%s %s", "find", "viewGroup"));
                fetchChildLayouts((ViewGroup) view);
            } else {
                Log.d(TAG, String.format("%s %s", "find", "view"));
                if(view.getVisibility() == View.VISIBLE){
                    view.setVisibility(View.GONE);
                    viewList.add(view);
                }
//                setAnimation(view);
            }
            Log.d(TAG, String.format("%s %s %s %s", "child", viewGroup.getClass().getName(), "id", String.valueOf(viewGroup.getId())));
        }
    }

    private List<View> arrangeLayouts(List<View> viewList) {
        switch (direction) {
            case BACKWARD:
                Collections.reverse(viewList);
                break;
        }
        return viewList;
    }

    private void setAnimation() {
        int count = viewList.size();
        Log.d(TAG, String.format("%s %s", "viewList.size()", viewList.size()));
        for (int i = 0; i < count; i++) {
            final View view = viewList.get(i);

            ObjectAnimator ob = ObjectAnimator.ofFloat( view, View.ALPHA, 0, 1 );
            ob.setDuration(1).setStartDelay(i * 500);
            ob.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator anim) {
                    view.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationRepeat(Animator anim) {}

                @Override
                public void onAnimationEnd(Animator anim) {
                }

                @Override
                public void onAnimationCancel(Animator anim) {}
            });

            List<Animator> animatorList = new ArrayList<>();
            animatorList.add(ob);
            animatorList.add(ObjectAnimator.ofFloat(view, View.SCALE_X, 0.0f, 1.0f));
            animatorList.add(ObjectAnimator.ofFloat(view, View.SCALE_Y, 0.0f, 1.0f));
            animatorList.add(ObjectAnimator.ofFloat(view, "pivotX", 0.5f));
            animatorList.add(ObjectAnimator.ofFloat(view, "pivotY", 0.5f));

            AnimatorSet set = new AnimatorSet();
            set.playTogether(animatorList);
            set.setDuration(duration);
            set.setStartDelay(i * 500);
            set.setInterpolator(new OvershootInterpolator());
//            set.addListener(new Animator.AnimatorListener() {
//                @Override
//                public void onAnimationStart(Animator anim) {
//                    view.setVisibility(View.VISIBLE);
//                    Log.d(TAG, String.format("%s %s", "VISIBLE", "start"));
//                }
//
//                @Override
//                public void onAnimationRepeat(Animator anim) {}
//
//                @Override
//                public void onAnimationEnd(Animator anim) {
//                }
//
//                @Override
//                public void onAnimationCancel(Animator anim) {}
//            });
            set.start();


//            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat( view, View.ALPHA, 0, 1 );
//            objectAnimator.setDuration(duration);
//            objectAnimator.setStartDelay(i * startOffset);
//            objectAnimator.addListener(new Animator.AnimatorListener() {
//                @Override
//                public void onAnimationStart(Animator anim) {
//                    view.setVisibility(View.VISIBLE);
//                }
//
//                @Override
//                public void onAnimationRepeat(Animator anim) {}
//
//                @Override
//                public void onAnimationEnd(Animator anim) {
//                }
//
//                @Override
//                public void onAnimationCancel(Animator anim) {}
//            });
//            objectAnimator.start();

            Log.d(TAG, String.format("%s %s", i * startOffset, duration));

//            AlphaAnimation anim = new AlphaAnimation(0, 1);
//            anim.setStartOffset(i * startOffset);
//            anim.setDuration(duration);
//            Log.d(TAG, String.format("%s %s", i * startOffset, i * duration));
//            viewList.get(i).setAnimation(anim);
        }
    }

}
