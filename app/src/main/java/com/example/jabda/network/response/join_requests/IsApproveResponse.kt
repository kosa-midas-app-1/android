package com.example.jabda.network.response.join_requests

import com.google.gson.annotations.SerializedName

data class IsApproveResponse(
    @SerializedName("approve-status")
    val isApprove: String
)
