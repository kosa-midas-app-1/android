package com.example.jabda.network.response.staff

import com.google.gson.annotations.SerializedName

data class TimeAverageResponse(
    @SerializedName("average_start_at")
    val startAt: Int,
    @SerializedName("average_end_at")
    val endAt: Int
)
