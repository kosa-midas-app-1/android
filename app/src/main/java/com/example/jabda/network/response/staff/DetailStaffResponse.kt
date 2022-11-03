package com.example.jabda.network.response.staff

import com.google.gson.annotations.SerializedName
import java.util.Date

data class DetailStaffResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone_number")
    val phone: String,
    @SerializedName("start_at")
    val startAt: Date,
    @SerializedName("end_at")
    val endAt: Date,
    @SerializedName("total_work")
    val totalWork: Int,
    @SerializedName("today_work")
    val todayWork: Int,
    @SerializedName("average_work")
    val averageWork: Int,
    @SerializedName("average_start")
    val averageStart: String
)