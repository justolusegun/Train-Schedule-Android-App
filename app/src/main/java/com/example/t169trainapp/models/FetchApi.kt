package com.example.t169trainapp.models

import com.example.t169trainapp.models.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface FetchApi {

    @GET("/")
    fun getCustomData() : Call<List<PostModel>>
}