package com.example.jabda.network.response.staff

import com.google.gson.annotations.SerializedName

data class MyWorkTimeResponse(
    @SerializedName("start_at")
    val startAt: Int,
    @SerializedName("end_at")
    val endAt: Int
)