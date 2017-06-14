package com.fujiyuu75.sequent.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.fujiyuu75.sequent.Animation;
import com.fujiyuu75.sequent.Sequent;

public class TutorialFragment extends Fragment {

    private final static String TAG = TutorialFragment.class.getSimpleName();
    private LinearLayout layout;
    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_tutorial, null);
    }

    @Override
    public void onViewCreated(View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        layout = (LinearLayout) v.findViewById(R.id.layout);
        spinner = (Spinner) v.findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemString = (String) parent.getItemAtPosition(position);
                Log.d(TAG, String.format("%s %s", "selectedItemString", selectedItemString));
                Log.d(TAG, String.format("%s %s", "position", position));

                switch (position){
                    case 0:
                        Sequent.origin(layout).anim(getActivity(), Animation.BOUNCE_IN).start();
                        break;
                    case 1:
                        Sequent.origin(layout).anim(getActivity(), Animation.FADE_IN_DOWN).start();
                        break;
                    case 2:
                        Sequent.origin(layout).anim(getActivity(), Animation.FADE_IN_LEFT).start();
                        break;
                    case 3:
                        Sequent.origin(layout).anim(getActivity(), Animation.FADE_IN_RIGHT).start();
                        break;
                    case 4:
                        Sequent.origin(layout).anim(getActivity(), Animation.FADE_IN_UP).start();
                        break;
                    case 5:
                        Sequent.origin(layout).anim(getActivity(), Animation.ROTATE_IN).start();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

//        if (isVisibleToUser && layout != null) {
//            Sequent.origin(layout).anim(getActivity(), Animation.BOUNCE_IN).start();
//        }
    }
}
