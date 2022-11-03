package com.example.jabda.presentation.start

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityStartBinding

class StartActivity: AppCompatActivity() {
    lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}