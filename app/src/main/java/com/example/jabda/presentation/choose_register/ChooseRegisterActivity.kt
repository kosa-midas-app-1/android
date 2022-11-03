package com.example.jabda.presentation.choose_register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityChooseRegisterBinding
import com.example.jabda.presentation.register.RegisterActivity
import com.example.jabda.presentation.register.RegisterOwnerActivity

class ChooseRegisterActivity: AppCompatActivity() {
    private lateinit var binding: ActivityChooseRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.staffBtn.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
        }
        binding.manageBtn.setOnClickListener {
            startActivity(Intent(this, RegisterOwnerActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
        }
    }
}