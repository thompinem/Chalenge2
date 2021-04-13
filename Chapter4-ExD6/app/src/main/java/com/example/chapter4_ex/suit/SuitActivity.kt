package com.example.chapter4_ex.suit

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chapter4_ex.R

class SuitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suit)
        var player1 = 0
        var player2 = 0

        // ini btn player1
        val btn1 = findViewById<Button>(R.id.button4)
        btn1.setOnClickListener {
            player1 = 1
            if (player2 > 0) {
                logic(player1, player2)
            }
        }
        val btn2 = findViewById<Button>(R.id.button5)
        btn2.setOnClickListener {
            player1 = 2
            if (player2 > 0) {
                logic(player1, player2)
            }
        }

        // ini btn player2
        val btn12 = findViewById<Button>(R.id.button7)
        btn12.setOnClickListener {
            player2 = 1
            if (player1 > 0) {
                logic(player1, player2)
            }
        }
        val btn22 = findViewById<Button>(R.id.button8)
        btn22.setOnClickListener {
            player2 = 2
            if (player1 > 0) {
                logic(player1, player2)
            }
        }
    }

    fun logic(player1: Int, player2: Int) {
        if (player1 > player2) {
            Toast.makeText(this, "Player1 Menang", Toast.LENGTH_SHORT).show()
        } else if (player1 < player2) {
            Toast.makeText(this, "Player2 Menang", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "DRAW", Toast.LENGTH_SHORT).show()
        }
    }
}