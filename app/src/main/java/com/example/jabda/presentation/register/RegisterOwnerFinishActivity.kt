package com.example.jabda.presentation.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityRegisterOwnerFinishBinding
import com.example.jabda.presentation.main.MainOwnerActivity

class RegisterOwnerFinishActivity: AppCompatActivity() {
    private lateinit var binding: ActivityRegisterOwnerFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterOwnerFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.finishBtn.setOnClickListener {
            startActivity(Intent(this, MainOwnerActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
            finish()
        }
    }
}