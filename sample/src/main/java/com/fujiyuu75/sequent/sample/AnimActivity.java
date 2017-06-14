package com.fujiyuu75.sequent.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.fujiyuu75.sequent.Animation;
import com.fujiyuu75.sequent.Sequent;

public class AnimActivity extends AppCompatActivity {

    private final static String TAG = AnimActivity.class.getSimpleName();
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        layout = (LinearLayout) findViewById(R.id.layout);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SampleActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.animation, menu);

        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.anims, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemString = (String) parent.getItemAtPosition(position);
                Log.d(TAG, String.format("%s %s", "selectedItemString", selectedItemString));
                Log.d(TAG, String.format("%s %s", "position", position));

                switch (position) {
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

        return true;
    }
}
