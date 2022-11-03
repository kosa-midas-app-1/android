package com.example.jabda.network.response.staff

import com.google.gson.annotations.SerializedName

data class MyInfoResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("phone_number")
    val phone: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("company_name")
    val companyName: String?,
    @SerializedName("position")
    val position: String?
)
