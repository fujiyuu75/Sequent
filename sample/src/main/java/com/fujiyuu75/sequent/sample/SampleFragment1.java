package com.fujiyuu75.sequent.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.fujiyuu75.sequent.Sequent;

public class SampleFragment1 extends Fragment {

    private LinearLayout layout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_sample_1, container);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        layout = v.findViewById(R.id.image_layout);
        Sequent.origin(layout).anim(getActivity(), R.anim.overshoot).start();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser && layout != null) {
            Sequent.origin(layout).anim(getActivity(), R.anim.overshoot).start();
        }
    }
}
