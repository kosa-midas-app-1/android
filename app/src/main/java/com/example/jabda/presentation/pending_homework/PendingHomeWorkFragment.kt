package com.example.jabda.presentation.pending_homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jabda.databinding.FragmentPendingHomeworkBinding

class PendingHomeWorkFragment: Fragment() {
    lateinit var binding: FragmentPendingHomeworkBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPendingHomeworkBinding.inflate(inflater, container, false)
        return binding.root
    }
}