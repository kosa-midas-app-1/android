package com.example.jabda.presentation.homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.jabda.databinding.FragmentHomeworkBinding
import com.example.jabda.presentation.main.MainViewModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

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
        binding.calendar.setOnDateChangeListener{ view, year,month,dayOfMonth ->
            var day : String = "${year}년 ${month}월 ${dayOfMonth}일"

            binding.date.text = day
        }
        return binding.root
    }
}