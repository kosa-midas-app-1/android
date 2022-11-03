package com.example.jabda.network.response.staff

import com.google.gson.annotations.SerializedName

data class TodayStaffResponse(
    @SerializedName("commuting")
    val commuting: Int,
    @SerializedName("non_commuting")
    val noCommuting: Int
)