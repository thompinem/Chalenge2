package com.example.fragment5.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragment5.R
import com.example.fragment5.duaFragment.DuaFragment
import com.example.fragment5.satuFragment.SatuFragment
import com.example.fragment5.tigaFragment.TigaFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataFragment = mutableListOf(SatuFragment(),
            DuaFragment(), TigaFragment()
        )
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
                Toast.makeText(this, "Sudah habis bang", Toast.LENGTH_LONG).show()
            }
        }

        findViewById<Button>(R.id.prev).setOnClickListener {
            if (posisi > 0) {
                posisi--
                changeFragment(dataFragment[posisi])
                findViewById<Button>(R.id.next).isEnabled = true
            } else {
                findViewById<Button>(R.id.prev).isEnabled = false
                Toast.makeText(this, "Sudah habis bang", Toast.LENGTH_LONG).show()
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


