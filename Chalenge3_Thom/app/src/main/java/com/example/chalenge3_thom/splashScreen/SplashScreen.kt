package com.example.chalenge3_thom.splashScreen

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.chalenge3_thom.R
import com.example.chalenge3_thom.second.SecondActivity
import android.os.Handler as Handler1

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {


    private lateinit var imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        imageView = findViewById(R.id.id1)

        Glide.with(this)
            .load("https://i.ibb.co/HC5ZPgD/splash-screen1.png")
            .into(imageView)

        Handler1().postDelayed({
            startActivity(Intent(this,
                SecondActivity::class.java))
            finish()
        }, 2000)
    }
}