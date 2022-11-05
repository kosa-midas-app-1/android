package com.example.jabda.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.jabda.databinding.FragmentHomeBinding
import com.example.jabda.network.response.notices.RecentNoticeResponse
import com.example.jabda.network.response.staff.MyWorkTimeWeekResponse
import com.example.jabda.network.retrofit.RetrofitClient
import com.example.jabda.presentation.main.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment: Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val viewModel by activityViewModels<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel.setIsCard(false)
//        RetrofitClient.api.myWorkTimeWeek().enqueue(object : Callback<MyWorkTimeWeekResponse> {
//            override fun onResponse(
//                call: Call<MyWorkTimeWeekResponse>,
//                response: Response<MyWorkTimeWeekResponse>
//            ) {
//                binding.weekTimeProgress.progress = (response.body()?.workCnt ?: 0 * 2.5).toInt()
//                binding.weekTimeTxt.text = "40시간/${response.body()?.workCnt}시간"
//            }
//
//            override fun onFailure(call: Call<MyWorkTimeWeekResponse>, t: Throwable) {
//            }
//        })
        binding.weekTimeProgress.progress = (20 * 2.5).toInt()
        binding.weekTimeTxt.text = "40시간/${20}시간"
        RetrofitClient.api.recentNotice().enqueue(object : Callback<RecentNoticeResponse> {
            override fun onResponse(
                call: Call<RecentNoticeResponse>,
                response: Response<RecentNoticeResponse>
            ) {
                binding.text.text = response.body()?.content
                binding.day.text = response.body()?.createdAt.toString()
            }

            override fun onFailure(call: Call<RecentNoticeResponse>, t: Throwable) {
            }

        })
        return binding.root
    }
}