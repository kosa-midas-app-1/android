package com.example.jabda.network.request.auth

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("company_id")
    val companyId: String,
    @SerializedName("position")
    val position: String
)