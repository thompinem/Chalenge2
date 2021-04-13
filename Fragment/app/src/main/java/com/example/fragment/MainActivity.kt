package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        fm.beginTransaction()
            .add(R.id.fragment1,PertamaFragment))
            .commit()

        val fm = supportFragmentManager
        fm.beginTransaction()
            .add(R.id.fragment2,PertamaFragment))
        .commit()



    }
}