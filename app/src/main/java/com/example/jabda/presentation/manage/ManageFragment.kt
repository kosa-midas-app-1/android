package com.example.jabda.presentation.manage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jabda.databinding.FragmentManageBinding

class ManageFragment: Fragment() {
    private lateinit var binding: FragmentManageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManageBinding.inflate(inflater, container, false)
        return binding.root
    }
}