package com.example.jabda.presentation.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.jabda.R
import com.example.jabda.databinding.ActivityMainOwnerBinding

class MainOwnerActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainOwnerBinding
    private val viewModel by viewModels<MainOwnerViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainOwnerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNav()
        binding.notificationBtn.setOnClickListener {
            findNavController(R.id.fragment_club).navigate(R.id.notificationFragment)
            viewModel.setIsNotification(true)
        }
        viewModel.isNotification.observe(this) {
            if (it) {
                binding.bottomNavigation.visibility = View.GONE
            } else {
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }
    }

    private fun initBottomNav() {
        val navController =
            supportFragmentManager.findFragmentById(R.id.fragment_club)?.findNavController()
        val nav = binding.bottomNavigation
        navController?.let {
            nav.setupWithNavController(navController)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        viewModel.setIsNotification(false)
    }
}