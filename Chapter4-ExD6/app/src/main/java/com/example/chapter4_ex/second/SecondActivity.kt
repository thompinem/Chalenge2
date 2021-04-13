package com.example.chapter4_ex.second

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.chapter4_ex.R
import com.example.chapter4_ex.duaFragment.DuaFragment
import com.example.chapter4_ex.satuFragment.SatuFragment
import com.example.chapter4_ex.tigaFragment.TigaFragment
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val dataFragment = mutableListOf(SatuFragment(), DuaFragment(), TigaFragment())
        val adapter = SecondAdapter(this)
        adapter.setData(dataFragment)

        val viewPager = findViewById<ViewPager2>(R.id.viewpager2)
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        viewPager.adapter = adapter
        dotsIndicator.setViewPager2(viewPager)

        viewPager.currentItem = 2
    }
}