package com.example.jabda.network.response.work_home_requests

import com.google.gson.annotations.SerializedName

data class HomeWorkCountResponse(
    @SerializedName("count")
    val count: Int
)