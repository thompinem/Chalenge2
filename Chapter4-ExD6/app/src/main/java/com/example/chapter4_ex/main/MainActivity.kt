package com.example.chapter4_ex.main

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.chapter4_ex.R
import com.example.chapter4_ex.duaFragment.DuaFragment
import com.example.chapter4_ex.satuFragment.SatuFragment
import com.example.chapter4_ex.tigaFragment.TigaFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataFragment = mutableListOf(SatuFragment(), DuaFragment(), TigaFragment())
        var posisi = 0

        val fm = supportFragmentManager
        fm.beginTransaction()
            .add(R.id.container, dataFragment[0])
            .commit()

        findViewById<Button>(R.id.next).setOnClickListener {
            if (posisi < dataFragment.size.minus(1)) {
                posisi++
                changeFragment(dataFragment[posisi])
                findViewById<Button>(R.id.prev).isEnabled = true
            } else {
                findViewById<Button>(R.id.next).isEnabled = false
                Toast.makeText(this, "Sudah Habis Coyy!!", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.prev).setOnClickListener {
            if (posisi > 0) {
                posisi--
                changeFragment(dataFragment[posisi])
                findViewById<Button>(R.id.next).isEnabled = true
            } else {
                Toast.makeText(this, "Sudah Habis Bro!!", Toast.LENGTH_SHORT).show()
                findViewById<Button>(R.id.prev).isEnabled = false
            }
        }
    }

    fun changeFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        fm.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}