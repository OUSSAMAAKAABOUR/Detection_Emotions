package com.example.emotionsdetection

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCRegister=findViewById<Button>(R.id.btnr)
        val btnCsign=findViewById<Button>(R.id.btnc)
        val btnCamere=findViewById<ImageView>(R.id.btncamere)
        btnCRegister.setOnClickListener(View.OnClickListener {
                val intent1= Intent(this,Register::class.java)
                Intent(this,Register::class.java).also {
                    startActivity(it)
                }
        })


        btnCamere.setOnClickListener(View.OnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        })
        btnCsign.setOnClickListener(View.OnClickListener {
            val intent1= Intent(this,Home::class.java)
            Intent(this,Home::class.java).also {
                startActivity(it)
            }
        })


    }
}