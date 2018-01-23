package com.fujiyuu75.sequent.sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.fujiyuu75.sequent.Sequent

class SampleFragment1 : Fragment() {

    private var layout: LinearLayout? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sample_1, null)
    }

    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
        super.onViewCreated(v, savedInstanceState)

        layout = v.findViewById(R.id.image_layout)
        Sequent.origin(layout).anim(activity, R.anim.overshoot).start()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

        if (isVisibleToUser && layout != null) {
            Sequent.origin(layout).anim(activity, R.anim.overshoot).start()
        }
    }
}
