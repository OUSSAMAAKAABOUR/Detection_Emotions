package com.example.emotionsdetection

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    val login = findViewById<EditText>(R.id.login).text.toString()
    val pass = findViewById<EditText>(R.id.pass).text.toString()
    val err = findViewById<TextView>(R.id.err)
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCRegister=findViewById<Button>(R.id.btnr)
        val btnCsign=findViewById<Button>(R.id.btnc)
        val btnCamere=findViewById<ImageView>(R.id.btncamere)

        // Initialize Firebase Auth
        auth = Firebase.auth

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
//            val intent1= Intent(this,Home::class.java)
//            Intent(this,Home::class.java).also {
//                startActivity(it)
//            }
            if (login.isEmpty() || pass.isEmpty())
                err.text="fill in all the inputs!!"

            auth.signInWithEmailAndPassword(login, pass)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Intent(this,Home::class.java).also {
                            startActivity(it)
                        }
                    } else {
                        // If sign in fails, display a message to the user.
                        err.text = "Email | password is incorrrect!"
                    }
                }

            findViewById<EditText>(R.id.login).setOnClickListener({
                err.text =""
            })
            findViewById<EditText>(R.id.pass).setOnClickListener({
                err.text =""
            })
        })


    }
}