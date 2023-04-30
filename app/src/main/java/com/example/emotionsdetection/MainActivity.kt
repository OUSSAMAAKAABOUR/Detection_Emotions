package com.example.emotionsdetection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCRegister=findViewById<Button>(R.id.btnr)
        btnCRegister.setOnClickListener(View.OnClickListener {
                val intent1= Intent(this,Register::class.java)
                Intent(this,Register::class.java).also {
                    startActivity(it)
                }



        })


    }
}