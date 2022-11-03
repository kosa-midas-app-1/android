package com.example.jabda.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buNext.setOnClickListener {
            startActivity(Intent(this, LoginFinishActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
            finish()
        }
    }
}