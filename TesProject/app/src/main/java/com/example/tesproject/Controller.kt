package com.example.chalenge3_thom.controler

import com.example.chalenge3_thom.callback.Callback

class Controller (private var callback : Callback) {

    private var result = ""

    fun logic(player1: String, player2: String) {
        result = if (player1 == player2) {
            "SERI!"
            //Log.d("result", "draw")
            //R.drawable.draw



        } else if (player1 == "batu" && player2 == "gunting" ||
            player1 == "kertas" && player2 == "batu" ||
            player1 == "gunting" && player2 == "kertas") {

            //Log.d("result", "menang")
            //R.drawable.p1menang
            "Menang"

        } else {
            //Log.d("result", "CPU Menang")
            //R.drawable.p2menang
            "Player2 \n Menang"
        }

        callback.kirimBalikResult(result)


    }
}


