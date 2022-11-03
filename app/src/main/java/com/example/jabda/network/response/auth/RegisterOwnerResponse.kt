package com.example.jabda.network.request.auth

import com.google.gson.annotations.SerializedName
import java.util.Date

data class RegisterOwnerResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("expired_at")
    val expiredAt: Date,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("authority")
    val authority: String
)