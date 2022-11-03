package com.example.jabda.presentation.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityRegisterBinding

class RegisterActivity: AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buNext.setOnClickListener {
            startActivity(Intent(this, RegisterFinishActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
            finish()
        }
    }
}