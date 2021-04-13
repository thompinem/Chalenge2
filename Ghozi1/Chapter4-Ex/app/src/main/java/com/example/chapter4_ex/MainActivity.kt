package com.example.chapter4_ex

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), Callback {
    private lateinit var btnPlayer1: Button
    private lateinit var btnPlayer2: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPlayer1 = findViewById(R.id.btnPlayer1)
        btnPlayer2 = findViewById(R.id.btnPlayer2)
        tvStatus = findViewById(R.id.tvStatus)
        val controller = Controller(this)

        btnPlayer1.setOnClickListener {
            val randomNumP1 = (1..10).random()
            val randomNumP2 = (1..10).random()
            btnPlayer2.text = randomNumP2.toString()
            btnPlayer1.text = randomNumP1.toString()
            controller.bandingkanNumbers(randomNumP1, randomNumP2)
        }

        btnPlayer2.setOnClickListener {
            val randomNumP1 = (1..10).random()
            val randomNumP2 = (1..10).random()
            btnPlayer2.text = randomNumP2.toString()
            btnPlayer1.text = randomNumP1.toString()
            controller.bandingkanNumbers(randomNumP1, randomNumP2)
        }
    }

    override fun kirimStatus(status: String) {
        tvStatus.text = status
    }
}