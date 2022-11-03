package com.example.jabda.network.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class RetrofitClient {


    companion object {
        private const val url = "http://3.37.129.120:8080"
        var server: Retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(provideOkHttpClient(AppInterceptor()))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var api:API = server.create(API::class.java)

        private fun provideOkHttpClient(interceptor: AppInterceptor): OkHttpClient
                = OkHttpClient.Builder().run {
            addInterceptor(interceptor)
            build()
        }
    }

    class AppInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain) : Response = with(chain) {
            val newRequest = request().newBuilder()
                .addHeader("(heaber Key)", "(heaber Value)")
                .build()
            proceed(newRequest)
        }
    }
    private val api = RetrofitClient.server.create(RetrofitClient.AppInterceptor::class.java)
}