package com.example.emotionsdetection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val text=findViewById<TextView>(R.id.aleardy)
        text.setOnClickListener(View.OnClickListener {
            val intent1= Intent(this,MainActivity::class.java)
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }



        })


    }
}