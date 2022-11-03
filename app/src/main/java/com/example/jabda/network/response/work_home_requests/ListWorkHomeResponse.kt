package com.example.jabda.network.response.work_home_requests

import com.google.gson.annotations.SerializedName

data class ListWorkHomeResponse(
    @SerializedName("staff")
    val staff: List<Staff>
) {
    data class Staff(
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("position")
        val position: String,
        @SerializedName("phone_number")
        val phone: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("date")
        val date: String,
        @SerializedName("reason")
        val reason: String
    )
}