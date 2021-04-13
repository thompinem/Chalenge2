package com.example.cobain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fn = supportFragmentManager
        fn.beginTransaction()
            .add(R.id.container,FragmentMario())
            .commit()
    }
}