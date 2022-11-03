package com.example.jabda.network.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private const val url = ""
        private var server: Retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var api:API = server.create(API::class.java)
    }
}