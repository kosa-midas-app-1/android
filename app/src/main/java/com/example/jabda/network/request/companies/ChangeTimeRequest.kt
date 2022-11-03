package com.example.jabda.network.request.companies

import com.google.gson.annotations.SerializedName
import java.util.*

data class ChangeTimeRequest(
    @SerializedName("start_at")
    val startAt: Date,
    @SerializedName("end_at")
    val endAt: Date
)