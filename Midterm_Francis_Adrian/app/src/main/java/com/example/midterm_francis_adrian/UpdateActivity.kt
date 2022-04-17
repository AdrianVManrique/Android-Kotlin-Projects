package com.example.midterm_francis_adrian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore

class UpdateActivity : AppCompatActivity() {
    private lateinit var signup_storeEmail: TextInputEditText
    private lateinit var signup_storepassword: TextInputEditText
    private lateinit var signup_confirmpassword: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        signup_storeEmail = findViewById(R.id.signup_storeEmail)
        signup_storepassword = findViewById(R.id.signup_storepassword)
        signup_confirmpassword = findViewById(R.id.signup_confirmpassword)

        findViewById<Button>(R.id.signup_buttonsubmission).setOnClickListener() {

            val email = findViewById<TextInputEditText>(R.id.signup_storeEmail).text.toString()
            val password = findViewById<TextInputEditText>(R.id.signup_storepassword).text.toString()
            val confirmpassword = findViewById<TextInputEditText>(R.id.signup_confirmpassword).text.toString()

            val db = FirebaseFirestore.getInstance()
            val entry: MutableMap<String, Any> = HashMap()


                entry["userId"] = password
                entry["id"] = confirmpassword
                entry["title"] = email
                entry["completed"] = false

                db.collection("midterm").document(email)
                    .set(entry)
                    .addOnSuccessListener {
                        Log.d("db addEntry", "Success")
                    }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            }
        }
    }