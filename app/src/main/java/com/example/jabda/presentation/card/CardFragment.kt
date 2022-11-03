package com.example.jabda.presentation.card

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.nfc.NfcAdapter
import android.os.Bundle
import android.util.Log
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
//        viewModel.setIsCard(true)
        Glide.with(this)
            .load("https://static-whale.pstatic.net/main/img_darkmode_v12@2x.png")
            .circleCrop()
            .into(binding.companyimage)
        return binding.root

    }
}