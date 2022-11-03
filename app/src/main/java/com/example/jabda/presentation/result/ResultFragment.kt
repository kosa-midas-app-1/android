package com.example.jabda.presentation.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jabda.databinding.FragmentResultBinding

class ResultFragment: Fragment() {
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }
}