package com.example.jabda.network.request.staff

import com.google.gson.annotations.SerializedName

data class EditMyInfoRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("phone_number")
    val phone: String,
    @SerializedName("position")
    val position: String
)
