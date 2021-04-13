package com.example.rock

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity(),Callback {
    override fun kirimBalikResult(result: Int) {
        vs.setImageResource(result)
    }
    private var  batuCom: ImageView? = null
    private var  kertasCom: ImageView? = null
    private var  guntingCom: ImageView? = null
    private  lateinit var batu1 : ImageView
    private  lateinit var kertas1 : ImageView
    private  lateinit var gunting1 : ImageView
    private  lateinit var refresh: ImageView
    private  lateinit var pemain1Menang: ImageView
    private  lateinit var pemain2Menang: ImageView
    private  lateinit var draw: ImageView
    private  lateinit var vs: ImageView

    @SuppressLint("ResourceAsColor", "NewApi", "UseCompatLoadingForDrawables")
    override fun kirimBalikPilihanCom(pilihanCom: String) {
        if (pilihanCom == "batu") {
            batuCom?.setBackgroundColor(R.color.design_default_color_primary_dark)
        } else if (pilihanCom == "kertas"){
            kertasCom?.setBackgroundColor(R.color.design_default_color_primary_dark)
        } else {
            guntingCom?.setBackgroundColor(R.color.design_default_color_primary_dark)
    }
}

    @SuppressLint("ResourceAsColor", "NewApi", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        batu1 = findViewById(R.id.batuPemain1)
        kertas1 = findViewById(R.id.kertasPemain1)
        gunting1 = findViewById(R.id.guntingPemain1)
        refresh = findViewById(R.id.refresh)
        batuCom = findViewById(R.id.batuCom)
        kertasCom = findViewById(R.id.kertasCom)
        guntingCom = findViewById(R.id.guntingCom)
        pemain1Menang = findViewById(R.id.pemain1Menang)
        pemain2Menang = findViewById(R.id.comMenang)
        draw = findViewById(R.id.draw)
        vs = findViewById(R.id.vs)

        val com = listOf("batu", "kertas", "gunting")
        val chooseCom = (0..2).random()
        var pencet: Boolean = true
        val controller = Controller(this)


        batu1.setOnClickListener {
            if (pencet) {
                val pilihanCom = com.random()
                batu1.setBackgroundColor(R.color.design_default_color_primary_dark)
                controller.simulasi(pilihan = "batu", pilihanCom = pilihanCom)
                pencet = false
            } else {
                Toast.makeText(this, "Direset dulu broo", Toast.LENGTH_LONG).show()
            }
        }
        kertas1.setOnClickListener {
            if (pencet) {
                val pilihanCom = com.random()
                kertas1.setBackgroundColor(R.color.design_default_color_primary_dark)
                controller.simulasi(pilihan = "kertas", pilihanCom = pilihanCom)
                pencet = false
            } else {
                Toast.makeText(this, "Direset dulu broo", Toast.LENGTH_LONG).show()
            }
        }
        gunting1.setOnClickListener {
            if (pencet) {
                val pilihanCom = com.random()
                gunting1.setBackgroundColor(R.color.design_default_color_primary_dark)
                controller.simulasi(pilihan = "gunting", pilihanCom = pilihanCom)
                pencet = false
            } else {
                Toast.makeText(this, "Direset dulu broo", Toast.LENGTH_LONG).show()
            }
        }

        refresh.setOnClickListener {
            batu1.background = getDrawable(android.R.color.transparent)
            kertas1.background = getDrawable(android.R.color.transparent)
            gunting1.background = getDrawable(android.R.color.transparent)
            batuCom?.background = getDrawable(android.R.color.transparent)
            kertasCom?.background = getDrawable(android.R.color.transparent)
            guntingCom?.background = getDrawable(android.R.color.transparent)
            vs.setImageResource(R.drawable.vs)
            pencet = true

        }
    }
}


