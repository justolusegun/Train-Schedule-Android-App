package com.example.t169trainapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton

class SearchScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_screen)

        val goBack = findViewById<ImageView>(R.id.goBack1)
        val searchBtn = findViewById<Button>(R.id.searchBtn)

        goBack.setOnClickListener {
            val i = Intent(this, HomePage::class.java)
            startActivity(i)
        }

        searchBtn.setOnClickListener {
            val s = Intent(this, HomePage::class.java)
            startActivity(s)
        }
    }
}