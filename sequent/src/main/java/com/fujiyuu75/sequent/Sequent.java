package com.fujiyuu75.sequent;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sequent {
    private List<View> viewList = new ArrayList<>();
    private final int startOffset;
    private final int duration;
    private final int delay;
    private final Direction direction;
    private final Context context;
    private final int animId;
    private final Animation anim;

    public static class Builder {
        private static final int DEFAULT_OFFSET = 100;
        private static final int DEFAULT_DURATION = 500;
        private static final int DEFAULT_DELAY = 0;

        private ViewGroup vg;
        private int startOffset = DEFAULT_OFFSET;
        private int duration = DEFAULT_DURATION;
        private int delay = DEFAULT_DURATION;
        private Direction direction = Direction.FORWARD;
        private Context context;
        private int animId;
        private Animation anim;

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

        public Builder delay(int delay) {
            this.delay = delay;
            return this;
        }

        public Builder flow(Direction direction) {
            this.direction = direction;
            return this;
        }

        public Builder anim(Context context, int animId) {
            this.context = context;
            this.animId = animId;
            return this;
        }

        public Builder anim(Context context, Animation anim) {
            this.context = context;
            this.anim = anim;
            return this;
        }

        public Sequent start() {
            return new Sequent(this);
        }
    }

    public static Builder origin(ViewGroup vg) {
        return new Builder(vg);
    }

    private Sequent(Builder builder) {
        this.startOffset = builder.startOffset;
        this.duration = builder.duration;
        this.delay = builder.delay;
        this.direction = builder.direction;
        this.context = builder.context;
        this.animId = builder.animId;
        this.anim = builder.anim;

        ViewGroup vg = builder.vg;
        fetchChildLayouts(vg);
        arrangeLayouts(viewList);
        setAnimation();
    }

    private void fetchChildLayouts(ViewGroup viewGroup) {
        int count = viewGroup.getChildCount();

        for (int i = 0; i < count; i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof ViewGroup) {
                fetchChildLayouts((ViewGroup) view);
            } else {
                if (view.getVisibility() == View.VISIBLE) {
                    view.setVisibility(View.INVISIBLE);
                    viewList.add(view);
                }
            }
        }
    }

    private List<View> arrangeLayouts(List<View> viewList) {
        switch (direction) {
            case BACKWARD:
                Collections.reverse(viewList);
                break;
            case RANDOM:
                Collections.shuffle(viewList);
                break;
        }
        return viewList;
    }

    private void setAnimation() {
        int count = viewList.size();
        for (int i = 0; i < count; i++) {
            final View view = viewList.get(i);
            final int offset = i * startOffset;

            resetAnimation(view);

            List<Animator> animatorList = new ArrayList<>();
            animatorList.add(getStartObjectAnimator(offset, view));

            if (animId != 0) {
                animatorList.add(getResAnimator(context, animId, view));
            } else if (anim != null){
                animatorList.add(getResAnimator(context, anim.getAnimId(), view));
            } else {
                animatorList.add(ObjectAnimator.ofFloat(view, View.ALPHA, 0, 1));
            }

            AnimatorSet set = new AnimatorSet();
            set.playTogether(animatorList);
            set.setDuration(duration);
            if (delay == 0) {
                set.setStartDelay(i * startOffset);
            } else if (i == 0) {
                set.setStartDelay(delay);
            } else {
                set.setStartDelay((i * startOffset) + delay);
            }
            set.start();
        }
    }

    private void resetAnimation(View view) {
        ViewCompat.setAlpha(view, 1);
        ViewCompat.setScaleX(view, 1);
        ViewCompat.setScaleY(view, 1);
        ViewCompat.setTranslationX(view, 0);
        ViewCompat.setTranslationY(view, 0);
        ViewCompat.setRotation(view, 0);
        ViewCompat.setRotationY(view, 0);
        ViewCompat.setRotationX(view, 0);
    }

    private ObjectAnimator getStartObjectAnimator(int offset, final View view) {
        ObjectAnimator ob = ObjectAnimator.ofFloat(view, View.ALPHA, 0, 1);
        ob.setDuration(1).setStartDelay(offset);
        ob.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator anim) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animator anim) {
            }

            @Override
            public void onAnimationEnd(Animator anim) {
            }

            @Override
            public void onAnimationCancel(Animator anim) {
            }
        });
        return ob;
    }

    private Animator getResAnimator(Context context, int animId, View view) {
        Animator anim = AnimatorInflater.loadAnimator(context, animId);
        anim.setTarget(view);
        return anim;
    }
}
