package com.example.jabda.network.response.join_requests

import com.google.gson.annotations.SerializedName

data class JoinListResponse(
    @SerializedName("requests")
    val requests: List<request>
) {
    data class request(
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("phone_number")
        val phone: String,
        @SerializedName("position")
        val position: String
    )
}
