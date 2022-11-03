package com.example.jabda.network.request.`work-home-requests`

import com.google.gson.annotations.SerializedName

data class HomeWorkRequest(
    @SerializedName("reason")
    val reason: String,
    @SerializedName("date")
    val date: String
)
