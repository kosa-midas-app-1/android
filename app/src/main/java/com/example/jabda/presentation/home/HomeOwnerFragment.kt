package com.example.jabda.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jabda.databinding.FragmentHomeOwnerBinding

class HomeOwnerFragment: Fragment() {
    private lateinit var binding: FragmentHomeOwnerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeOwnerBinding.inflate(inflater, container, false)
        return binding.root
    }
}