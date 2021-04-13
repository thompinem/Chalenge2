package com.example.fragment5.secondActivity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.text.FieldPosition

abstract class SecondAdapter (fa:FragmentManager): FragmentStatePagerAdapter(fa){
    private val data = mutableListOf<Fragment>()

    fun setData (data:MutableList<Fragment>){
        this.data.clear()
        this.data.addAll(data)
    }
    fun getItemCount(): Int = data.size
    fun createFragment(position: Int): Fragment = data[position]
}