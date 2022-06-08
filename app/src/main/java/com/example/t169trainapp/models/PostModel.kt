package com.example.t169trainapp.models

import java.io.Serializable

data class PostModel (
    var trainNo : String,
    var stationNo : String? = null,
    var stationName : String? = null,
    var arriveTime : String? = null,
    var departTime : String? = null,
    var duration : String? = null,
    var price : String,
    var from: String,
    var to:String
) : Serializable