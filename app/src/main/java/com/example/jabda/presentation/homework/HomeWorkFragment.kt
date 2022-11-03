package com.example.jabda.presentation.homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.jabda.databinding.FragmentHomeworkBinding
import com.example.jabda.presentation.main.MainViewModel

class HomeWorkFragment: Fragment() {
    lateinit var binding: FragmentHomeworkBinding
    private val viewModel by activityViewModels<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.setIsCard(false)
        binding = FragmentHomeworkBinding.inflate(inflater, container, false)
        return binding.root
    }
}