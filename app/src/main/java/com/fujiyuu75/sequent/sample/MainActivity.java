package com.fujiyuu75.sequent.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.fujiyuu75.sequent.Sequent;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = (LinearLayout)findViewById(R.id.layout);
        Sequent.origin(layout).start();

        Log.d(TAG, String.format("%s %s %s %s", "layout", layout.getClass().getName(), "id", layout.getId()));
    }
}
