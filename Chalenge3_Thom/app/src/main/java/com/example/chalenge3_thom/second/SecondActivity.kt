package com.example.chalenge3_thom.second

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.chalenge3_thom.R
import com.example.chalenge3_thom.page1Fragment.Page1Fragment
import com.example.chalenge3_thom.page2Fragment.Page2Fragment
import com.example.chalenge3_thom.page3Fragment.Page3Fragment
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val dataFragment = mutableListOf(
                Page1Fragment(),
                Page2Fragment(),
                Page3Fragment())
        val adapter = SecondAdapter(this)
        adapter.setData(dataFragment)

        val viewPager2 = findViewById<ViewPager2>(R.id.viewpager2)
        val dotsIndicator = findViewById<SpringDotsIndicator>(R.id.spring_dots_indicator)
        viewPager2.adapter = adapter
        dotsIndicator.setViewPager2(viewPager2)

        viewPager2.currentItem = 0
    }
}

