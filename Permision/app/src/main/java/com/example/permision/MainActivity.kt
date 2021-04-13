package com.example.permision

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private val REQ_CODE =100
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity","Lagi onCreate Nich")


        val image = findViewById<ImageView>(R.id.image)
        Glide.with(this)
                .load("https://upload.wikimedia.org/wikipedia/id/0/0c/LogoPSMS.png")
                .into(image)

        findViewById<Button>(R.id.).setOnClickListener {
            val permissionCheck = checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)

            if (permissionCheck==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Permision Location Diizinkan",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Permision Location Ditolak",Toast.LENGTH_LONG).show()
                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), REQ_CODE)
            }
        }
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode){
            REQ_CODE ->{
                if(grantResults.isNotEmpty()&& grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"Allow telah dipilih",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Deny telah dipilih",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity","Lagi onStart Nich")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity","Lagi onPause Nich")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity","Lagi onResume Nich")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity","Lagi onStop Nich")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity","Lagi onDestroy Nich")
    }

}
