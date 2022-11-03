package com.example.jabda.network.response.auth

import com.google.gson.annotations.SerializedName
import java.util.*

data class RefreshResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("expired_at")
    val expiredAt: Date,
    @SerializedName("refresh_token")
    val refreshToken: String
)