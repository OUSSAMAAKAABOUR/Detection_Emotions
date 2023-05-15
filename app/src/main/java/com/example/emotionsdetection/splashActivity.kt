package com.example.emotionsdetection


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class splashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val iv_log = findViewById<ImageView>(R.id.iv_logo)

        iv_log.alpha = 0f
        with(iv_log.animate().setDuration(2000).alpha(1f)) {

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

    }
}