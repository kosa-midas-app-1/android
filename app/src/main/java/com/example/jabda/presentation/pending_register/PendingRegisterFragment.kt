package com.example.jabda.presentation.pending_register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jabda.databinding.FragmentPendingRegisterBinding

class PendingRegisterFragment: Fragment() {
    lateinit var binding: FragmentPendingRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPendingRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }
}