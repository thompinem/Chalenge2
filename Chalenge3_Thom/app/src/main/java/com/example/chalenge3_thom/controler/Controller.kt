package com.example.chalenge3_thom.controler

import com.example.chalenge3_thom.callback.Callback

class Controller (private var callback : Callback) {

    private var result = ""

    fun simulasi(
        pilihanCom: String,
        pilihan: String
    ) {
        result = if (pilihanCom == pilihan) {
            "SERI!"
            //Log.d("result", "draw")
            //R.drawable.draw



        } else if (pilihan == "batu" && pilihanCom == "gunting" ||
                pilihan == "kertas" && pilihanCom == "batu" ||
                pilihan == "gunting" && pilihanCom == "kertas") {

            //Log.d("result", "menang")
            //R.drawable.p1menang
            "Menang"

        } else {
            //Log.d("result", "CPU Menang")
            //R.drawable.p2menang
            "CPU \n Menang"
        }

        callback.kirimBalikResult(result)
        callback.kirimLagiPilihanCom(pilihanCom)
    }
}


