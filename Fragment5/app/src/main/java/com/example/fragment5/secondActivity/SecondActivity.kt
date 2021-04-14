package com.example.fragment5.secondActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.fragment5.R
import com.example.fragment5.duaFragment.DuaFragment
import com.example.fragment5.satuFragment.SatuFragment
import com.example.fragment5.tigaFragment.TigaFragment

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val dataFragment = mutableListOf(SatuFragment(),
            DuaFragment(), TigaFragment()
        )
        val adapter = SecondAdapter(this)
        adapter.setData(dataFragment)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager2)
        viewPager.adapter = adapter
    }
}