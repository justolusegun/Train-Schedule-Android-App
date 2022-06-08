 package com.example.t169trainapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.t169trainapp.adapter.CustomRecyclerAdapter
import com.example.t169trainapp.models.CustomApi
import com.example.t169trainapp.models.FetchApi
import com.example.t169trainapp.models.PostModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 class HomePage : AppCompatActivity() {
     private lateinit var CustomAdapter : CustomRecyclerAdapter
//     val recycler_view = findViewById<RecyclerView>(R.id.recyclerView)

     private val BASE_URL = "https://traint169.netlify.app"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        getCustomData()

        val searchButton = findViewById<ImageView>(R.id.search)

        searchButton.setOnClickListener {
            val i = Intent(this, SearchScreen::class.java)
            startActivity(i)
        }

        val text = "Fetching Available Schedules!"
        val duration = Toast.LENGTH_LONG

        val toast = Toast.makeText(applicationContext, text, duration).show()

    }


      fun getCustomData(){
          val recycler_view = findViewById<RecyclerView>(R.id.recyclerView)
         val retrofitBuilder = Retrofit.Builder()
             .addConverterFactory(GsonConverterFactory.create())
             .baseUrl(BASE_URL)
             .build()
             .create(FetchApi::class.java)
          val retrofitData = retrofitBuilder.getCustomData()

          retrofitData.enqueue(object : Callback<List<PostModel>?> {
              override fun onResponse(
                  call: Call<List<PostModel>?>,
                  response: Response<List<PostModel>?>
              ) {
                  val responseBody = response.body()!!
                  recycler_view.apply {
                      layoutManager = LinearLayoutManager(context)
                      CustomAdapter = CustomRecyclerAdapter(context)
                      adapter = CustomAdapter
                  }
                  CustomAdapter.submitList(responseBody)
              }

              override fun onFailure(call: Call<List<PostModel>?>, t: Throwable) {
                  Log.d("Home Page", "Error" + t.message)
              }

          })
     }
 }