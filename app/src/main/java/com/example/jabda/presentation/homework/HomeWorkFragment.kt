package com.example.jabda.presentation.homework

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.jabda.databinding.FragmentHomeworkBinding
import com.example.jabda.network.request.work_home_requests.HomeWorkRequest
import com.example.jabda.network.retrofit.RetrofitClient
import com.example.jabda.presentation.main.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
//        val call = RetrofitClient.api.requestHomeWork(HomeWorkRequest(reason = "", date = ""))
//        call.enqueue(object : Callback<Void> {
//            override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onFailure(call: Call<Void>, t: Throwable) {
//                Log.d("상태",t.message.toString())
//                TODO("Not yet implemented")
//            }
//        })
        return binding.root
    }
}