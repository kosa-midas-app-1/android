package com.example.jabda.presentation.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityLoginBinding
import com.example.jabda.network.request.auth.RegisterOwnerRequest
import com.example.jabda.network.request.auth.RegisterOwnerResponse
import com.example.jabda.network.retrofit.RetrofitClient
import com.example.jabda.network.retrofit.SharedPreFerences
import com.example.jabda.presentation.main.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity: AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
            finish()
            val call = RetrofitClient.api.registerOwner(RegisterOwnerRequest(companyImage = String(), password = String(), email = String(), companyName = String(), companyNumber = String(), companySystem = String(), name = String(), phoneNumber = "", isHomeWork = false))
            call.enqueue(object : Callback<RegisterOwnerResponse>{
                override fun onResponse(
                    call: Call<RegisterOwnerResponse>,
                    response: Response<RegisterOwnerResponse>
                ) {
                    if (response.code() == 200) {
                        SharedPreFerences(this@LoginActivity).data = response.body()?.accessToken
                    }
                }
                override fun onFailure(call: Call<RegisterOwnerResponse>, t: Throwable) {
                    Log.d("상태",t.message.toString())
                    TODO("Not yet implemented")
                }
            })
        }

    }
}