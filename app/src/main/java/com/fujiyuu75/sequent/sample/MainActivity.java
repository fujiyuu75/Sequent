package com.fujiyuu75.sequent.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private int number = 0;
    SparseArray<View> array = new SparseArray<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Sequent sequent = new Sequent(contentView);
//        Log.d(TAG, String.format("%s %s", "count", sequent.getCount()));

        LinearLayout layout = (LinearLayout)findViewById(R.id.layout);
        Log.d(TAG, String.format("%s %s %s %s", "layout", layout.getClass().getName(), "id", layout.getId()));

        View contentView = findViewById(android.R.id.content);
        Log.d(TAG, String.format("%s %s %s %s", "contentView", contentView.getClass().getName(), "id", contentView.getId()));

        ViewGroup rootView = (ViewGroup)contentView.getRootView();
        Log.d(TAG, String.format("%s %s %s %s", "rootView", rootView.getClass().getName(), "id", rootView.getId()));

        findChildLayouts(layout);
    }

    private void setAnimation(View v) {
        AlphaAnimation anim = new AlphaAnimation(0, 1);
        anim.setStartOffset(number * 50);
        anim.setDuration(number * 500);
        v.setAnimation(anim);

        number++;
    }

    private void findChildLayouts(ViewGroup viewGroup) {
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
                array.put(view.getId(), view);
            }
            Log.d(TAG, String.format("%s %s %s %s", "child", viewGroup.getClass().getName(), "id", String.valueOf(viewGroup.getId())));
        }
    }

}
