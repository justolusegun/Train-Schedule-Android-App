package com.example.t169trainapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getStarted = findViewById<Button>(R.id.onboardbtn)

        getStarted.setOnClickListener {
            val i = Intent(this, HomePage::class.java)
            startActivity(i)
        }
    }
}