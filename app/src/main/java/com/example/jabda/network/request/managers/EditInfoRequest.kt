package com.example.jabda.network.request.managers

import com.google.gson.annotations.SerializedName

data class EditInfoRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("name")
    val name: String
)
