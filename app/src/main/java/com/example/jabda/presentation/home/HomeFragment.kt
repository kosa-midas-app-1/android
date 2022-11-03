package com.example.jabda.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.jabda.databinding.FragmentHomeBinding
import com.example.jabda.presentation.main.MainViewModel

class HomeFragment: Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val viewModel by activityViewModels<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.setIsCard(false)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
}