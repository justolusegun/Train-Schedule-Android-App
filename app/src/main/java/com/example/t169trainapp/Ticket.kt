package com.example.t169trainapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Trace
import android.widget.Button
import android.widget.ImageView
import com.example.t169trainapp.models.PostModel

class Ticket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)

//        val train: PostModel = intent.getBundleExtra("ticket") as PostModel

        val goBack = findViewById<ImageView>(R.id.goBack)

        goBack.setOnClickListener {
            val i = Intent(this, HomePage::class.java)
            startActivity(i)
        }
    }
}