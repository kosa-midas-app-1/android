package com.example.jabda.network.response.staff

import com.google.gson.annotations.SerializedName

data class MyWorkTimeWeekResponse(
    @SerializedName("work_count")
    val workCnt: Int
)
