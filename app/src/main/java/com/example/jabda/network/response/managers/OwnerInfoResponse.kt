package com.example.jabda.network.response.managers

import com.google.gson.annotations.SerializedName

data class OwnerInfoResponse(
    @SerializedName("email")
    val email: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("name")
    val name: String
)
