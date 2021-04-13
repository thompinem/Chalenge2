package com.example.chapter4_ex.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.chapter4_ex.R

class ContohDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contoh_dialog)

        findViewById<Button>(R.id.button).setOnClickListener {
            val view = LayoutInflater.from(this).inflate(R.layout.dialog, null, false)
            val alert = AlertDialog.Builder(this)
            alert.setView(view)
            alert.setCancelable(false)

            val dialog = alert.create()
            dialog.show()

            val btnOk = view.findViewById<Button>(R.id.btnOk)
            btnOk.setOnClickListener {

            }
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Test Dialog Biasa")
            alert.setMessage("Hai Aku dialog")
            alert.setCancelable(false)
            alert.setNegativeButton("cancel", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    dialog?.dismiss()
                }

            })
            alert.show()
        }

        findViewById<Button>(R.id.button3).setOnClickListener {

        }
    }
}