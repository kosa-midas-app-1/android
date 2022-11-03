package com.example.jabda.network.response.notices

import com.google.gson.annotations.SerializedName
import java.util.Date

data class RecentNoticeResponse(
    @SerializedName("content")
    val content: String,
    @SerializedName("created_at")
    val createdAt: Date
)
