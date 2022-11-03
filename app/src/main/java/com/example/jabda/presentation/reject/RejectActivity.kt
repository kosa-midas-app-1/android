package com.example.jabda.presentation.reject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityRejectBinding

class RejectActivity: AppCompatActivity() {
    lateinit var binding: ActivityRejectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRejectBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}