package com.example.jabda.network.response.companies

import com.google.gson.annotations.SerializedName

data class CompaniesResponse(
    @SerializedName("companies")
    val companies: List<Company>
) {
    data class Company(
        @SerializedName("name")
        val name: String,
        @SerializedName("manager_name")
        val managerName: String,
        @SerializedName("manager_phone_number")
        val managePhone: String
    )
}
