package com.example.jabda.network.retrofit

import com.example.jabda.network.request.auth.RegisterOwnerRequest
import com.example.jabda.network.request.auth.RegisterOwnerResponse
import com.example.jabda.network.request.auth.RegisterRequest
import com.example.jabda.network.response.auth.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface API {
    @POST("/auth/managers")
    fun registerOwner(
        @Body body: RegisterOwnerRequest
    ): Call<RegisterOwnerResponse>
    @POST("/auth/staff")
    fun register(
        @Body body: RegisterRequest
    ): Call<RegisterResponse>
    @POST("/auth")
    fun login(
        @Body body: 
    )
}