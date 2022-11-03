package com.example.jabda.presentation.detail_member

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jabda.databinding.FragmentDetailMemberBinding

class DetailMemberFragment: Fragment() {
    lateinit var binding: FragmentDetailMemberBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailMemberBinding.inflate(inflater, container, false)
        return binding.root
    }
}