package com.example.chalenge2_thom

import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.ImageView
import android.view.View.GONE
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var pilihan = ""
    private var pemenang = ""
    private var pilihanCom = ""


    private lateinit var batu: ImageView
    private lateinit var kertas: ImageView
    private lateinit var gunting: ImageView
    private lateinit var batuCom: ImageView
    private lateinit var kertasCom: ImageView
    private lateinit var guntingCom: ImageView
    private lateinit var refresh: ImageView
    private lateinit var draw: ImageView
    private lateinit var pemain1Menang: ImageView
    private lateinit var comMenang: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        batu = findViewById(R.id.batuPemain1)
        kertas = findViewById(R.id.kertasPemain1)
        gunting = findViewById(R.id.guntingPemain1)
        batuCom = findViewById(R.id.batuCom)
        kertasCom = findViewById(R.id.kertasCom)
        guntingCom = findViewById(R.id.guntingCom)
        refresh = findViewById(R.id.refresh)
        pemain1Menang = findViewById(R.id.pemain1Menang)
        comMenang = findViewById(R.id.comMenang)
        draw = findViewById(R.id.draw)

        batu.setOnClickListener {
            scaleBtn(it)
            playBtn("batu")
            scaleBtnCom("batu")
        }
        kertas.setOnClickListener {
            scaleBtn(it)
            playBtn("kertas")
            scaleBtnCom("kertas")
        }
        gunting.setOnClickListener {
            scaleBtn(it)
            playBtn("gunting")
            scaleBtnCom("gunting")
        }
        refresh.setOnClickListener { refreshBtn() }
    }

    //Permainan--> Random COM dan membandingkan
    private fun playBtn(args: String) {
        val opsiCom = listOf("batu", "kertas", "gunting")
        val comChoseNum = (0..2).random()
        pilihanCom = opsiCom[comChoseNum]

        if (pilihan == pilihanCom) {
            pemenang = "draw"
            result(pemenang)
        } else if (pilihan == "kertas" && pilihanCom == "batu" ||
            pilihan == "gunting" && pilihanCom == "kertas" ||
            pilihan == "batu" && pilihanCom == "gunting"
        ) {

            pemenang = "pemain1Menang"
            result(pemenang)

        } else {
            pemenang = "comMenang"
            result(pemenang)
        }

        println("Pilihan Pemain1 adalah : $pilihan")
        println("Pilihan COM adalah : $pilihanCom")
    }

    //Mengeluarkan Image View Pemenang
    private fun result(args: String) {
        if (pemenang == "draw") {
            pemain1Menang.visibility = GONE
            draw.visibility = VISIBLE
            comMenang.visibility = GONE
        } else if (pemenang == "comMenang") {
            pemain1Menang.visibility = GONE
            draw.visibility = GONE
            comMenang.visibility = VISIBLE
        } else {
            pemain1Menang.visibility = VISIBLE
            draw.visibility = GONE
            comMenang.visibility = GONE
        }
        println("Pemenangnya adalah : $pemenang")
    }

    //Refresh Button
    private fun refreshBtn() {
        pilihan = ""
        pemain1Menang.visibility = GONE
        draw.visibility = GONE
        comMenang.visibility = GONE
        resetScaledBtns()
        resetScaledBtnsCom()
    }

    //Scale ImageView Pemain
    private fun scaleBtn(args: Any) {
        if (args === batu) {
            batu.scaleX = "0.75".toFloat()
            batu.scaleY = "0.75".toFloat()
            pilihan = "batu"

            kertas.scaleX = "1".toFloat()
            kertas.scaleY = "1".toFloat()
            gunting.scaleX = "1".toFloat()
            gunting.scaleY = "1".toFloat()

        } else if (args === kertas) {
            kertas.scaleX = "0.75".toFloat()
            kertas.scaleY = "0.75".toFloat()
            pilihan = "kertas"

            batu.scaleX = "1".toFloat()
            batu.scaleY = "1".toFloat()
            gunting.scaleX = "1".toFloat()
            gunting.scaleY = "1".toFloat()

        } else if (args === gunting) {
            gunting.scaleX = "0.75".toFloat()
            gunting.scaleY = "0.75".toFloat()
            pilihan = "gunting"

            batu.scaleX = "1".toFloat()
            batu.scaleY = "1".toFloat()
            kertas.scaleX = "1".toFloat()
            kertas.scaleY = "1".toFloat()
        } else {
            resetScaledBtns()
        }
    }

    //Reset Scale ImageView Pemain
    private fun resetScaledBtns() {
        batu.scaleX = "1".toFloat()
        batu.scaleY = "1".toFloat()
        kertas.scaleX = "1".toFloat()
        kertas.scaleY = "1".toFloat()
        gunting.scaleX = "1".toFloat()
        gunting.scaleY = "1".toFloat()
    }

    //Scale ImageView COM
    private fun scaleBtnCom(args: Any) {
        if (pilihanCom == "batu") {
            batuCom.scaleX = "0.75".toFloat()
            batuCom.scaleY = "0.75".toFloat()

            kertasCom.scaleX = "1".toFloat()
            kertasCom.scaleY = "1".toFloat()
            guntingCom.scaleX = "1".toFloat()
            guntingCom.scaleY = "1".toFloat()

        } else if (pilihanCom== "kertas") {
            kertasCom.scaleX = "0.75".toFloat()
            kertasCom.scaleY = "0.75".toFloat()

            batuCom.scaleX = "1".toFloat()
            batuCom.scaleY = "1".toFloat()
            guntingCom.scaleX = "1".toFloat()
            guntingCom.scaleY = "1".toFloat()

        } else if (pilihanCom == "gunting") {
            guntingCom.scaleX = "0.75".toFloat()
            guntingCom.scaleY = "0.75".toFloat()

            batuCom.scaleX = "1".toFloat()
            batuCom.scaleY = "1".toFloat()
            kertasCom.scaleX = "1".toFloat()
            kertasCom.scaleY = "1".toFloat()
        } else {
            resetScaledBtnsCom()
        }
    }

    //Reset Scale ImageView COM
    private fun resetScaledBtnsCom() {
        batuCom.scaleX = "1".toFloat()
        batuCom.scaleY = "1".toFloat()
        kertasCom.scaleX = "1".toFloat()
        kertasCom.scaleY = "1".toFloat()
        guntingCom.scaleX = "1".toFloat()
        guntingCom.scaleY = "1".toFloat()
    }
}





















