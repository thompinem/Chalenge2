
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.R


abstract class MainActivity : AppCompatActivity(), CallBack {

    private var refresh = 0
    private var guntingPemain1 = 0
    private var kertasPemain1 = 0
    private var batuPemain1 = 0
    private var batuCom = 0
    private var kertasCom = 0
    private var guntingCom = 0

    @SuppressLint("ResourceAsColor", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        batuPemain1 = findViewById(R.id.batuPemain1)
        kertasPemain1 = findViewById(R.id.kertasPemain1)
        guntingPemain1 = findViewById(R.id.guntingPemain1)
        refresh = findViewById (R.id.refresh)


        val com = arrayOf("batu", "kertas", "gunting")
        var clicked: Boolean = true
        val controller = Controller(this)

        batuPemain1.setOnClickListener {
            if (clicked) {
                val pilihanCom = com.random()
                controller.operasi("batu", pilihanCom)
                batuPemain1.setBackgroundColor(R.color.design_default_color_primary_dark)
                clicked = false
            } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }
        kertasPemain1.setOnClickListener {
            if (clicked) {
                val pilihanCom = com.random()
                controller.operasi("kertas", pilihanCom)
                kertasPemain1.setBackgroundColor(R.color.design_default_color_primary_dark)
                clicked = false
            } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }
        guntingPemain1.setOnClickListener {
            if (clicked) {
                val pilihanCom = com.random()
                controller.operasi("gunting", pilihanCom)
                guntingPemain1.setBackgroundColor(R.color.design_default_color_primary_dark)
                clicked = false
            } else {
                Toast.makeText(this, "Reset dulu Boss", Toast.LENGTH_LONG).show()
            }
        }

        refresh.setOnClickListener {
            batuPemain1.background = getDrawable(android.R.color.transparent)
            batuCom.background = getDrawable(android.R.color.transparent)
            kertasPemain1.background = getDrawable(android.R.color.transparent)
            kertasCom.background = getDrawable(android.R.color.transparent)
            guntingPemain1.background = getDrawable(android.R.color.transparent)
            guntingCom.background = getDrawable(android.R.color.transparent)
            clicked = true
        }
    }
}

