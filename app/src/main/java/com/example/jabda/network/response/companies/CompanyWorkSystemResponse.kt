package com.example.jabda.network.response.companies

import com.google.gson.annotations.SerializedName
import java.util.Date

data class CompanyWorkSystemResponse(
    @SerializedName("apply_work_home")
    val isHomeWork: Boolean,
    @SerializedName("work_system")
    val workSystem: String,
    @SerializedName("required_work_time")
    val requireWorkTime: Time?
){
    data class Time(
        @SerializedName("start_at")
        val startAt: Date,
        @SerializedName("end_at")
        val endAt: Date
    )
}
