package com.example.jabda.presentation.start

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityStartBinding
import com.example.jabda.presentation.choose_register.ChooseRegisterActivity
import com.example.jabda.presentation.login.LoginActivity
import com.example.jabda.presentation.register.RegisterActivity

class StartActivity: AppCompatActivity() {
    lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
        }
        binding.registerBtn.setOnClickListener {
            startActivity(Intent(this, ChooseRegisterActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
        }
    }
}