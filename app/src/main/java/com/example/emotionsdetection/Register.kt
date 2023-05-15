package com.example.emotionsdetection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {
    val email = findViewById<EditText>(R.id.add).text.toString()
    val password = findViewById<EditText>(R.id.pswrd).text.toString()
    val passwordConf = findViewById<EditText>(R.id.rpswrd).text.toString()
    val btnrg = findViewById<Button>(R.id.btnrg)
    val text=findViewById<TextView>(R.id.aleardy)
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize Firebase Auth
        auth = Firebase.auth
        btnrg.setOnClickListener({
            if (email.isEmpty() || password.isEmpty())
                Toast.makeText(this,"fill all inputs!!",Toast.LENGTH_SHORT).show()
            if(!password.equals(passwordConf))
                Toast.makeText(this,"passwords don't match!!",Toast.LENGTH_SHORT).show()


            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        Toast.makeText(
                            baseContext,
                            "Account created.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }

        })



        text.setOnClickListener(View.OnClickListener {
            val intent1= Intent(this,MainActivity::class.java)
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }





        })


    }
}