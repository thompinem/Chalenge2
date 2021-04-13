package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.viewpager)

        val fragment : ArrayList<Fragment> = arrayListOf(
            Page1Fragment(),
            Page2Fragment(),
            Page3Fragment()
        )
        val adapter: ViewPagerAdapter = ViewPagerAdapter(fragment, this )
        viewPager.adapter = adapter

        val dotsIndicator = findViewById<SpringDotsIndicator>(R.id.spring_dots_indicator)
        //val viewPager = findViewById<ViewPager>(R.id.view_pager)
        //val adapter = ViewPagerAdapter()
        //viewPager.adapter = adapter
        dotsIndicator.setViewPager2(viewPager)

        viewPager.currentItem = 2
    }
}