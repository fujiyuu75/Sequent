package com.fujiyuu75.sequent;

/**
 * Created by y_fujikawa on 2017/05/26.
 */

public enum Animation {
    BOUNCE_IN(R.anim.bounce_in),
    FADE_IN_DOWN(R.anim.fade_in_down),
    FADE_IN_UP(R.anim.fade_in_up),
    FADE_IN_LEFT(R.anim.fade_in_left),
    FADE_IN_RIGHT(R.anim.fade_in_right),
    ROTATE_IN(R.anim.rotate_in),;

    private int animId;

    Animation(int animId) {
        this.animId = animId;
    }

    public int getAnimId() {
        return this.animId;
    }
}
