package com.krishanshamod.simple_android_application_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krishanshamod.simple_android_application_8.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}