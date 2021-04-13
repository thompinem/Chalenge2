package com.example.chapter4_ex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), CallBackFragment2, CallBackFragment1 {

    private lateinit var pertamaFragment: PertamaFragment
    private lateinit var duaFragment: DuaFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        duaFragment = DuaFragment()
        pertamaFragment = PertamaFragment()

        val fm = supportFragmentManager
        fm.beginTransaction()
            .add(R.id.fragment1, duaFragment)
            .commit()

        fm.beginTransaction()
            .add(R.id.fragment2, pertamaFragment)
            .commit()
    }

    override fun messageDariFragment2(msg: String) {
        pertamaFragment.showMessageDariFragment2(msg)
    }

    override fun messageDariFragment1(msg: String) {
        duaFragment.showMessageDariFragment1(msg)
    }
}