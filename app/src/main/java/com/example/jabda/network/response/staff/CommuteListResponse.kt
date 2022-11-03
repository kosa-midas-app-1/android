package com.example.jabda.network.response.staff

import com.google.gson.annotations.SerializedName
import java.util.*

data class CommuteListResponse(
    @SerializedName("staff")
    val staff: List<Staff>
) {
    data class Staff(
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("phone_number")
        val phoneNumber: String,
        @SerializedName("position")
        val position: String,
        @SerializedName("status")
        val status: String,
        @SerializedName("start_at")
        val startAt: Date?,
        @SerializedName("end_at")
        val endAt: Date?
    )
}
