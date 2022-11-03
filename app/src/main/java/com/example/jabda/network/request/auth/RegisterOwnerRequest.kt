package com.example.jabda.network.request.auth

import com.google.gson.annotations.SerializedName

data class RegisterOwnerRequest(
    @SerializedName("password")
    val password: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("company_name")
    val companyName: String,
    @SerializedName("company_business_number")
    val companyNumber: String,
    @SerializedName("company_profile_image_url")
    val companyImage: String,
    @SerializedName("company_work_system")
    val companySystem: String,
    @SerializedName("comapany_apply_work_home")
    val isHomeWork: Boolean
)