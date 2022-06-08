package com.example.t169trainapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Train  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.traincardview)

//        val train: PostModel = intent.getBundleExtra("ticket") as PostModel
//
//        val getTicket = findViewById<Button>(R.id.getTicket)
//
//        getTicket.setOnClickListener {
//            val i = Intent(this, Ticket::class.java)
//            startActivity(i)
//        }
    }
}