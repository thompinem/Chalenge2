package com.example.chalenge3_thom.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chalenge3_thom.callback.Callback
import com.example.chalenge3_thom.controler.Controller
import com.example.tesproject.R

open class MainActivity : AppCompatActivity(), Callback {
    override fun kirimBalikResult(result: String) {
        vs.setImageResource(0)
    }

    private lateinit var batu: ImageView
    private lateinit var kertas: ImageView
    private lateinit var gunting: ImageView
    private lateinit var refresh: ImageView
    private lateinit var vs : ImageView
    private lateinit var batuCom : ImageView
    private lateinit var kertasCom : ImageView
    private lateinit var guntingCom: ImageView
    private lateinit var pemain1Menang: ImageView
    private lateinit var pemain2Menang: ImageView
    private lateinit var draw: ImageView
    private lateinit var nameUser: TextView
    private lateinit var close:ImageView
    private lateinit var  player1 : String
    private lateinit var player2 : String


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




        val controller = Controller(this)

        batu.setOnClickListener {
            player1 = "batu"
            if (player2 != "") {
                controller.logic(player1 = "batu", player2 = player2)
                //batu.setBackgroundColor(design_default_color_primary_dark)
                //Toast.makeText(this,"Pemain2 memilih $player2",Toast.LENGTH_LONG).show()
                //pencet = false
            } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }
        kertas.setOnClickListener {
            player1 = "kertas"
            if (player2 != "") {
                //kertas.setBackgroundColor(design_default_color_primary_dark)
                controller.logic(player1 = "kertas", player2 =  player2)
                //Toast.makeText(this,"Pemain2 memilih $player2",Toast.LENGTH_LONG).show()
                //pencet = false
            } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }
        gunting.setOnClickListener {
            player1="gunting"
            if (player2 != "") {
                //gunting.setBackgroundColor(design_default_color_primary_dark)
                controller.logic(player1 = "gunting", player2 = player2)
                //Toast.makeText(this,"Pemain2 memilih $player2",Toast.LENGTH_LONG).show()
                //pencet = false
            } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }
        batuCom.setOnClickListener {
            player2 = "batu"
            if (player1 != "") {
                //batuCom.setBackgroundColor(design_default_color_primary_dark)
                controller.logic(player1 = player1, player2 = "batu")
                //Toast.makeText(this,"Pemain2 memilih $player2",Toast.LENGTH_LONG).show()
                //pencet = false
            } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }
        kertasCom.setOnClickListener {
            player2 = "kertas"
            if (player1 != "") {
                //kertasCom.setBackgroundColor(design_default_color_primary_dark)
                controller.logic(player1 = player1, player2 =  "kertas")
                //Toast.makeText(this,"Pemain2 memilih $player2",Toast.LENGTH_LONG).show()
                //pencet = false
            } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }
        guntingCom.setOnClickListener {
            player2 = "gunting"
            if (player1 != "") {
                //guntingCom.setBackgroundColor(design_default_color_primary_dark)
                controller.logic(player1 = player1, player2 = "gunting")
                //Toast.makeText(this,"Pemain2 memilih $player2",Toast.LENGTH_LONG).show()
                //pencet = false
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


        }
        close.setOnClickListener {
            this.finishAffinity()
        }
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

    }
        public void onBackPressed() {
            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", null).show();
        }
}
