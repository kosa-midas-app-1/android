package com.example.jabda.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityLoginFinishBinding
import com.example.jabda.presentation.main.MainActivity

class LoginFinishActivity: AppCompatActivity() {
    lateinit var binding: ActivityLoginFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buCom.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
        }
    }
}