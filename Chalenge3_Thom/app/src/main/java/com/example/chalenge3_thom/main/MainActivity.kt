package com.example.chalenge3_thom.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.chalenge3_thom.callback.Callback
import com.example.chalenge3_thom.controler.Controller
import com.example.chalenge3_thom.R
import com.example.chalenge3_thom.R.color.design_default_color_primary_dark

open class MainActivity : AppCompatActivity(),

    Callback {
    override fun kirimBalikResult(result: String) {

        //Receive Bundle UserName from MenuActivity
        val bundle = intent.extras
        val name = bundle?.getString("name")

        //AlertDialog
        val view = LayoutInflater.from(this).inflate(R.layout.dialog,
                null,false)
        val alert = androidx.appcompat.app.AlertDialog.Builder(this)

        alert.setView(view)
        alert.setCancelable(false)
        val dialog = alert.create()
        dialog.show()



        val btnReplay =view.findViewById<Button>(R.id.btnAlert1)
        btnReplay.setOnClickListener {
           dialog.dismiss()
        }

        val btnBack =view.findViewById<Button>(R.id.btnAlert2)

        btnBack.setOnClickListener {
            finish()
        }
        val hasil = view.findViewById<TextView>(R.id.textView2)
        val hasil1 =
        if(result == "Menang"){
            "$name \n Menang"
        }else{
            result
        }
        hasil.text = hasil1
    }

    private lateinit var batu: ImageView
    private lateinit var kertas: ImageView
    private lateinit var gunting: ImageView
    private lateinit var refresh: ImageView
    private lateinit var vs : ImageView
    private lateinit var batuCom : ImageView
    private lateinit var kertasCom : ImageView
    private lateinit var guntingCom: ImageView
    private  lateinit var pemain1Menang: ImageView
    private  lateinit var pemain2Menang: ImageView
    private  lateinit var draw: ImageView
    private  lateinit var nameUser: TextView
    private lateinit var close:ImageView


    @SuppressLint("ResourceAsColor")
    override fun kirimLagiPilihanCom(pilihanCom : String) {

        if (pilihanCom == "batu") {
            batuCom.setBackgroundColor(design_default_color_primary_dark)
        } else if (pilihanCom == "kertas") {
            kertasCom.setBackgroundColor(design_default_color_primary_dark)
        } else {
            guntingCom.setBackgroundColor(design_default_color_primary_dark)
        }
    }
    @SuppressLint("ResourceAsColor", "NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        batu = findViewById(R.id.batuPemain1)
        kertas = findViewById(R.id.kertasPemain1)
        gunting = findViewById(R.id.guntingPemain1)
        refresh = findViewById(R.id.refresh)
        vs = findViewById(R.id.vs)
        pemain1Menang = findViewById(R.id.pemain1Menang)
        pemain2Menang = findViewById(R.id.comMenang)
        draw = findViewById(R.id.draw)
        batuCom = findViewById(R.id.batuCom)
        kertasCom = findViewById(R.id.kertasCom)
        guntingCom = findViewById(R.id.guntingCom)
        nameUser = findViewById(R.id.user)
        close= findViewById(R.id.close)


        var pencet: Boolean = true
        val com = arrayOf("batu", "kertas", "gunting")
        val controller = Controller(this)


        batu.setOnClickListener {
            if (pencet) {
                batu.setBackgroundColor(design_default_color_primary_dark)
                val pilihanCom = com.random()
                controller.simulasi(pilihanCom = pilihanCom,pilihan = "batu")
                Toast.makeText(this,"CPU memilih $pilihanCom",Toast.LENGTH_LONG).show()
                pencet = false
            } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }
        kertas.setOnClickListener {
            if (pencet) {
                kertas.setBackgroundColor(design_default_color_primary_dark)
                val pilihanCom = com.random()
                controller.simulasi(
                    pilihanCom = pilihanCom,
                    pilihan = "kertas"
                )
                Toast.makeText(this,"CPU memilih $pilihanCom",Toast.LENGTH_LONG).show()
                pencet = false
            } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }
        gunting.setOnClickListener {
            if (pencet) {
                gunting.setBackgroundColor(design_default_color_primary_dark)
                val pilihanCom = com.random()
                controller.simulasi(
                    pilihanCom = pilihanCom,
                    pilihan = "gunting"
                )
                Toast.makeText(this,"CPU memilih $pilihanCom",Toast.LENGTH_LONG).show()
                pencet = false
            } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }
        refresh.setOnClickListener {
            batu.background = getDrawable(android.R.color.transparent)
            kertas.background = getDrawable(android.R.color.transparent)
            gunting.background = getDrawable(android.R.color.transparent)
            batuCom.background = getDrawable(android.R.color.transparent)
            kertasCom.background = getDrawable(android.R.color.transparent)
            guntingCom.background = getDrawable(android.R.color.transparent)
            pencet = true
            vs.setImageResource(R.drawable.vs)
        }
        close.setOnClickListener {
            finish()
        }

        //Receive Bundle UserName from MenuActivity
        val bundle = intent.extras
        val name = bundle?.getString("name")
        nameUser.text = "$name"
    }
}
