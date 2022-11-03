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
            .load("data:image/png;base64,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")
            .circleCrop()
            .into(binding.companyimage)
        return binding.root

    }
}