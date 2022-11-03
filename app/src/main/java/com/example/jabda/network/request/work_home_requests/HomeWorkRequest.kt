package com.example.jabda.network.request.work_home_requests

import com.google.gson.annotations.SerializedName

data class HomeWorkRequest(
    @SerializedName("reason")
    val reason: String,
    @SerializedName("date")
    val date: String
)
