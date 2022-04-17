package com.example.midterm_francis_adrian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class RemoveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remove)

        val titleView = findViewById<TextView>(R.id.remove_title)
        val userIdView = findViewById<TextView>(R.id.remove_userId)
        val idView = findViewById<TextView>(R.id.remove_Id)
        val completedView = findViewById<TextView>(R.id.remove_completed)
        titleView.text = intent.getStringExtra("Title")
        userIdView.text = intent.getStringExtra("UserID")
        idView.text = intent.getStringExtra("ID")
        completedView.text = intent.getStringExtra("Completed")

        findViewById<Button>(R.id.button_remove).setOnClickListener() {

            val db = FirebaseFirestore.getInstance()
            val midTermCol = db.collection("midterm")
            midTermCol.document(intent.getStringExtra("Title").toString())
                .delete()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}