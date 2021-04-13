package com.example.rock

import android.util.Log

class Controller(private var callback: Callback) {

    private var result = 0

    fun simulasi(pilihan: String, pilihanCom: String) {
        result = if (pilihan == pilihanCom){
            Log.d("result","draw")
            R.drawable.draw

        }else if(pilihan == "batu" && pilihanCom == "gunting"||
                pilihan == "kertas"&& pilihanCom == "batu"||
                pilihan == "gunting"&& pilihanCom == "kertas"){
            Log.d("result","Player 1 Menang")
            R.drawable.p1menang

        }else{
            Log.d("result","Player 2 Menang")
            R.drawable.p2menang

        }

        callback.kirimBalikPilihanCom(pilihanCom)
        callback.kirimBalikResult(result)
    }
}