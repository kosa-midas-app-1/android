package com.example.jabda.network.request.notices

import com.google.gson.annotations.SerializedName

data class NoticeRequest(
    @SerializedName("content")
    val content: String
)