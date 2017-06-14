package com.fujiyuu75.sequent.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.fujiyuu75.sequent.Animation;
import com.fujiyuu75.sequent.Sequent;

public class AnimActivity extends AppCompatActivity {

    private final static String TAG = AnimActivity.class.getSimpleName();
    private LinearLayout layout;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        layout = (LinearLayout) findViewById(R.id.layout);
        spinner = (Spinner) findViewById(R.id.spinner);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SampleActivity.class));
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemString = (String) parent.getItemAtPosition(position);
                Log.d(TAG, String.format("%s %s", "selectedItemString", selectedItemString));
                Log.d(TAG, String.format("%s %s", "position", position));

                switch (position){
                    case 0:
                        Sequent.origin(layout).anim(getApplicationContext(), Animation.BOUNCE_IN).start();
                        break;
                    case 1:
                        Sequent.origin(layout).anim(getApplicationContext(), Animation.FADE_IN_DOWN).start();
                        break;
                    case 2:
                        Sequent.origin(layout).anim(getApplicationContext(), Animation.FADE_IN_LEFT).start();
                        break;
                    case 3:
                        Sequent.origin(layout).anim(getApplicationContext(), Animation.FADE_IN_RIGHT).start();
                        break;
                    case 4:
                        Sequent.origin(layout).anim(getApplicationContext(), Animation.FADE_IN_UP).start();
                        break;
                    case 5:
                        Sequent.origin(layout).anim(getApplicationContext(), Animation.ROTATE_IN).start();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
