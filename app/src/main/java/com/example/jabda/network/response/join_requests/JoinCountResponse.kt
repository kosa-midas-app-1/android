package com.example.jabda.network.response.join_requests

import com.google.gson.annotations.SerializedName

data class JoinCountResponse(
    @SerializedName("count")
    val count: Int
)