package com.example.jabda.presentation.pending

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityPendingBinding

class PendingActivity: AppCompatActivity() {
    lateinit var binding: ActivityPendingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPendingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}