package com.example.jabda.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.jabda.R
import com.example.jabda.databinding.FragmentHomeOwnerBinding
import com.example.jabda.presentation.main.MainOwnerViewModel

class HomeOwnerFragment: Fragment() {
    private lateinit var binding: FragmentHomeOwnerBinding
    val viewModel by activityViewModels<MainOwnerViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeOwnerBinding.inflate(inflater, container, false)
        binding.registerCntLayout.setOnClickListener {
            if (viewModel.isPending.value != true) {
                activity?.findNavController(R.id.fragment_club)?.navigate(R.id.action_homeFragment_to_pendingRegisterFragment)
            }
            viewModel.setIsPending(true)
        }
        binding.homeWorkCntLayout.setOnClickListener {
            if (viewModel.isPending.value != true) {
                activity?.findNavController(R.id.fragment_club)?.navigate(R.id.action_homeFragment_to_pendingHomeWorkFragment)
            }
            viewModel.setIsPending(true)
        }
        return binding.root
    }
}