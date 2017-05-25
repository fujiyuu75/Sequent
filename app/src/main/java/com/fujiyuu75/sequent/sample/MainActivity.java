package com.fujiyuu75.sequent.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

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

        int count = layout.getChildCount();
        Log.d(TAG, String.format("%s %s", "count", String.valueOf(count)));

        for(int i = 0; i < count; ++i) {
            View child = layout.getChildAt(i);

            AlphaAnimation aa = new AlphaAnimation(0, 1);
            aa.setStartOffset(i * 50);
            aa.setDuration(i * 500);

            child.setAnimation(aa);

            Log.d(TAG, String.format("%s %s %s %s", "child", child.getClass().getName(), "id", String.valueOf(i * 1000)));
        }
    }
}
