package com.example.jabda.network.retrofit

import com.example.jabda.JabdaApp
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object RetrofitClient {


    private const val url = "http://3.37.129.120:8080"
    var server: Retrofit = Retrofit.Builder()
        .baseUrl(url)
            .client(provideOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var api:API = server.create(API::class.java)

    private fun provideOkHttpClient(): OkHttpClient
            = OkHttpClient.Builder().run {
        addInterceptor(LoginInterceptor())
        build()
    }

    class LoginInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
            val req =
                request().newBuilder().addHeader("Authorization", "Bearer ${JabdaApp.prefs.data}")
                    .build()
            return proceed(req)
        }
    }
}