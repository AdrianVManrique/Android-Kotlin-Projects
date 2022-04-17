package com.example.hw2_adrian_francis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val barFragment = BarFragment()
        val lineFragment = LineFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_fContainer,lineFragment)
            commit()
        }
        findViewById<Button>(R.id.main_barButton).setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.main_fContainer,barFragment)
                commit()
            }
        }

        findViewById<Button>(R.id.main_lineButton).setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.main_fContainer,lineFragment)
                commit()
            }
        }
    }
}