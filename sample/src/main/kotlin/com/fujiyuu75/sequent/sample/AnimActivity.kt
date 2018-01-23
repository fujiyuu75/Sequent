package com.fujiyuu75.sequent.sample

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner

import com.fujiyuu75.sequent.Animation
import com.fujiyuu75.sequent.Sequent

class AnimActivity : AppCompatActivity() {

    private var layout: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim)

        layout = findViewById(R.id.layout)

        findViewById<View>(R.id.button).setOnClickListener { startActivity(Intent(applicationContext, SampleActivity::class.java)) }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.animation, menu)

        val item = menu.findItem(R.id.spinner)
        val spinner = item.actionView as Spinner

        val adapter = ArrayAdapter.createFromResource(this,
                R.array.anims, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                when (position) {
                    0 -> Sequent.origin(layout).anim(applicationContext, Animation.BOUNCE_IN).start()
                    1 -> Sequent.origin(layout).anim(applicationContext, Animation.FADE_IN).start()
                    2 -> Sequent.origin(layout).anim(applicationContext, Animation.FADE_IN_DOWN).start()
                    3 -> Sequent.origin(layout).anim(applicationContext, Animation.FADE_IN_LEFT).start()
                    4 -> Sequent.origin(layout).anim(applicationContext, Animation.FADE_IN_RIGHT).start()
                    5 -> Sequent.origin(layout).anim(applicationContext, Animation.FADE_IN_UP).start()
                    6 -> Sequent.origin(layout).anim(applicationContext, Animation.ROTATE_IN).start()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        return true
    }
}
