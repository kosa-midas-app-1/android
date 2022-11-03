package com.example.jabda.network.request.companies

import com.google.gson.annotations.SerializedName

data class EditCompanyInfoRequest(
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_image_url")
    val profileImage: String,
    @SerializedName("work_system")
    val system: String,
    @SerializedName("apply_work_home")
    val isHomeWork: Boolean
)
