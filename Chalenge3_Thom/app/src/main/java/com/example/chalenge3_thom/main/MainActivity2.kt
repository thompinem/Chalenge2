package com.example.chalenge3_thom.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chalenge3_thom.R
import com.example.chalenge3_thom.R.color.design_default_color_primary_dark
import com.example.chalenge3_thom.callback.Callback2
import com.example.chalenge3_thom.controler.Controller2

class MainActivity2 : AppCompatActivity(), Callback2 {
    override fun kirimBalikResult2(result2: String) {
        //Receive Bundle UserName from MenuActivity
        val bundle = intent.extras
        val name = bundle?.getString("name")

        //AlertDialog
        val view = LayoutInflater.from(this).inflate(
            R.layout.dialog,
            null, false
        )
        val alert = androidx.appcompat.app.AlertDialog.Builder(this)

        alert.setView(view)
        alert.setCancelable(false)
        val dialog = alert.create()
        dialog.show()


        val btnReplay = view.findViewById<Button>(R.id.btnAlert1)
        btnReplay.setOnClickListener {
            dialog.dismiss()
        }

        val btnBack =view.findViewById<Button>(R.id.btnAlert2)

        btnBack.setOnClickListener {
            finish()
        }
        val hasil = view.findViewById<TextView>(R.id.textView2)
        val hasil1 =
            if(result2 == "Menang"){
                "$name \n Menang"
            }else{
                result2
            }
        hasil.text = hasil1
    }

    private lateinit var batu: ImageView
    private lateinit var kertas: ImageView
    private lateinit var gunting: ImageView
    private lateinit var refresh: ImageView
    private lateinit var vs: ImageView
    private lateinit var batuCom: ImageView
    private lateinit var kertasCom: ImageView
    private lateinit var guntingCom: ImageView
    private lateinit var pemain1Menang: ImageView
    private lateinit var pemain2Menang: ImageView
    private lateinit var draw: ImageView
    private lateinit var nameUser1: TextView
    private lateinit var close: ImageView



    @SuppressLint("ResourceAsColor", "NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

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
        nameUser1 = findViewById(R.id.cpu)
        close = findViewById(R.id.close)


        val controller = Controller2(this)
        var pencet: Boolean = true
        var pencetCom = true
        var player1 = ""
        var player2 = ""

        batu.setOnClickListener {
            player1 = "batu"
            batu.setBackgroundColor(design_default_color_primary_dark)
            if(player2 != ""&& pencet){
                controller.logic("batu","")
                Toast.makeText(this,"$nameUser1 memilih batu",Toast.LENGTH_LONG).show()
                pencet = false
                 } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }
        kertas.setOnClickListener {
            player1 = "kertas"
            kertas.setBackgroundColor(design_default_color_primary_dark)
            if(player2 != ""&& pencet){
                controller.logic("kertas","")

                Toast.makeText(this,"$nameUser1 memilih kertas",Toast.LENGTH_LONG).show()
                pencet = false
            } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }
        gunting.setOnClickListener {
            player1 = "gunting"
            gunting.setBackgroundColor(design_default_color_primary_dark)
            if(player2 != ""&& pencet){
                controller.logic("gunting","")

                Toast.makeText(this,"$nameUser1 memilih gunting",Toast.LENGTH_LONG).show()
                pencet = false
            } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }
        batuCom.setOnClickListener {
            player2 = "batu"
            if(player1 != ""&& pencetCom){
                controller.logic("","batu")
                batuCom.setBackgroundColor(design_default_color_primary_dark)
                Toast.makeText(this,"Player2 memilih batu",Toast.LENGTH_LONG).show()
                pencetCom = false
            } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }
        kertasCom.setOnClickListener {
            player2 = "kertas"


            if(player1 != ""&& pencetCom){
                controller.logic("","kertas")
                kertasCom.setBackgroundColor(design_default_color_primary_dark)

                Toast.makeText(this,"Player2 memilih kertas",Toast.LENGTH_LONG).show()
                pencetCom = false
            } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }
        guntingCom.setOnClickListener {
            player2 = "gunting"

            if(player1 != ""&& pencetCom){
                controller.logic("","gunting")
                guntingCom.setBackgroundColor(design_default_color_primary_dark)
                Toast.makeText(this,"Player2 memilih gunting",Toast.LENGTH_LONG).show()
                pencetCom = false
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
            pencetCom = true
            vs.setImageResource(R.drawable.vs)
            player1 = ""
            player2 = ""
        }
        close.setOnClickListener {
            finish()
        }

        //Receive Bundle UserName from MenuActivity
        val bundle = intent.extras
        val name = bundle?.getString("name")
        nameUser1.text = "$name"

    }
}


