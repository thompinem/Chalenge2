package com.example.cobain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ActivityDau : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dau)

        val name = intent.getStringExtra("Name")
        Toast.makeText(this,"Keterima $name",Toast.LENGTH_SHORT).show()
    }
}