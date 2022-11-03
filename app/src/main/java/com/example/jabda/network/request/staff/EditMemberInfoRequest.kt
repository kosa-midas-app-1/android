package com.example.jabda.network.request.staff

import com.google.gson.annotations.SerializedName

data class EditMemberInfoRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("position")
    val position: String
)
