package com.example.jabda.presentation.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.jabda.databinding.FragmentCardBinding
import com.example.jabda.presentation.main.MainViewModel


class CardFragment: Fragment() {
    private lateinit var binding: FragmentCardBinding
    private val viewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardBinding.inflate(inflater, container, false)
        viewModel.setIsApprove(true)
        viewModel.isMe.observe(viewLifecycleOwner) {
            if (it) {
                viewModel.setIsCard(true)
                binding.cardLayout.visibility = View.VISIBLE
            }
        }
        Glide.with(this)
            .load("https://static-whale.pstatic.net/main/img_darkmode_v12@2x.png")
            .circleCrop()
            .into(binding.companyimage)
        return binding.root

    }
}