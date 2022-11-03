package com.example.jabda.network.response.staff

import com.google.gson.annotations.SerializedName

data class TimeLineResponse(
    @SerializedName("hours")
    val hours: List<Hour>
) {
    data class Hour(
        @SerializedName("hour")
        val hour: Int,
        @SerializedName("working_staff_count")
        val staffCnt: Int
    )
}
