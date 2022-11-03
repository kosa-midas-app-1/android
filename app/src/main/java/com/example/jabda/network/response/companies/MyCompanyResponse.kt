package com.example.jabda.network.response.companies

import com.google.gson.annotations.SerializedName
import java.util.Date

data class MyCompanyResponse(
    @SerializedName("profile_image_url")
    val profileImage: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("business_number")
    val businessNumber: String,
    @SerializedName("staff_count")
    val staffCount: Int,
    @SerializedName("apply_work_home")
    val isHomeWork: Boolean,
    @SerializedName("work_system")
    val workSystem: String,
    @SerializedName("required_work_time")
    val requireWorkTime: WorkTime,
) {
    data class WorkTime(
        @SerializedName("start_at")
        val startAt: Date,
        @SerializedName("end_at")
        val endAt: Date
    )
}