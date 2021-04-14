@file:Suppress("Annotator", "SyntaxError", "SyntaxError", "SyntaxError")

package com.example.chalenge3_thom.menu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.chalenge3_thom.R
import com.example.chalenge3_thom.main.MainActivity
import com.example.chalenge3_thom.main.MainActivity2
import com.google.android.material.snackbar.Snackbar

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val tvReceive1 = findViewById<TextView>(R.id.tvreceive1)
        val tvReceive2 = findViewById<TextView>(R.id.tvreceive2)
        val btn1 = findViewById<Button>(R.id.btn1)
        val userVsPemain = findViewById<ImageView>(R.id.iv2)
        val userVsCPU = findViewById<ImageView>(R.id.iv3)


        val name = intent.getStringExtra("name")
        //Toast.makeText(this,"$name",Toast.LENGTH_LONG).show()
        tvReceive1.text = "$name vs Pemain"
        tvReceive2.text = "$name vs CPU"

        val snackbar = Snackbar.make(btn1, "Selamat Datang $name", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("Tutup") {
            snackbar.dismiss()
        }
        snackbar.show()


        //User Vs Pemain Button
        userVsPemain.setOnClickListener {
            val intent = Intent(this@MenuActivity, MainActivity2::class.java)
            val bundle = Bundle()
            bundle.putString("name", "$name")
            intent.putExtras(bundle)
            startActivity(intent)

        }

        //User Vs CPU Button
        userVsCPU.setOnClickListener {

            val intent = Intent(this@MenuActivity, MainActivity::class.java)
            val bundle = Bundle()
            bundle.putString("name", "$name")
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
        //Close Button
    override fun onBackPressed() {
        finishAffinity()
    }
}
