package com.example.jabda.presentation.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityRegisterFinishBinding
import com.example.jabda.presentation.main.MainActivity
import com.example.jabda.presentation.main.MainOwnerActivity

class RegisterFinishActivity: AppCompatActivity() {
    lateinit var binding: ActivityRegisterFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buCom.setOnClickListener {
            startActivity(Intent(this, MainOwnerActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
        }
    }
}