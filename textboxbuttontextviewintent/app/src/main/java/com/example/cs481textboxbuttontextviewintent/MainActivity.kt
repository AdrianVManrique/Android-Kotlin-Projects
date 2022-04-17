package com.example.cs481textboxbuttontextviewintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.bEnter).setOnClickListener {
            val firstName = findViewById<EditText>(R.id.txFirstName).text.toString()
            val lastName = findViewById<EditText>(R.id.txLastName).text.toString()
            val tvdisplay = findViewById<TextView>(R.id.tvDisplay)
            if (firstName.isNotEmpty() && lastName.isNotEmpty()){
                tvdisplay.text = "Your full name " + firstName.plus(" ").plus(lastName)
            } else{
                Toast.makeText(this, "Enter Full Name", Toast.LENGTH_LONG).show()
            }
        }

        findViewById<Button>(R.id.bGrade).setOnClickListener {
            startActivity(Intent(this, GradeActivity::class.java))
        }
    }
}