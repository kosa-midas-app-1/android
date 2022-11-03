package com.example.jabda.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.jabda.R
import com.example.jabda.databinding.FragmentHomeOwnerBinding
import com.example.jabda.network.response.companies.MyCompanyResponse
import com.example.jabda.network.response.join_requests.JoinCountResponse
import com.example.jabda.network.response.managers.OwnerInfoResponse
import com.example.jabda.network.response.work_home_requests.HomeWorkCountResponse
import com.example.jabda.network.retrofit.RetrofitClient
import com.example.jabda.presentation.main.MainOwnerViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeOwnerFragment: Fragment() {
    private lateinit var binding: FragmentHomeOwnerBinding
    val viewModel by activityViewModels<MainOwnerViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeOwnerBinding.inflate(inflater, container, false)
        RetrofitClient.api.myCompany().enqueue(object : Callback<MyCompanyResponse> {
            override fun onResponse(
                call: Call<MyCompanyResponse>,
                response: Response<MyCompanyResponse>
            ) {
                binding.companyName.text = response.body()?.name
                binding.companyNum.text = response.body()?.businessNumber
                binding.staffCnt.text = response.body()?.staffCount.toString()
                when(response.body()?.workSystem) {
                    "FLEXTIME" -> binding.cb4.isChecked = true
                    else -> binding.cb3.isChecked = true
                }
            }

            override fun onFailure(call: Call<MyCompanyResponse>, t: Throwable) {
            }

        })
        RetrofitClient.api.getInfo().enqueue(object : Callback<OwnerInfoResponse> {
            override fun onResponse(
                call: Call<OwnerInfoResponse>,
                response: Response<OwnerInfoResponse>
            ) {
                binding.manageName.text = "이름 : ${response.body()?.name}"
                binding.managePhone.text = "전화번호 : ${response.body()?.phoneNumber}"
                binding.manageMail.text = "이메일 : ${response.body()?.email}"
            }

            override fun onFailure(call: Call<OwnerInfoResponse>, t: Throwable) {
            }
        })
        RetrofitClient.api.joinCount().enqueue(object : Callback<JoinCountResponse> {
            override fun onResponse(
                call: Call<JoinCountResponse>,
                response: Response<JoinCountResponse>
            ) {
                binding.joinCnt.text = response.body()?.count.toString()
            }

            override fun onFailure(call: Call<JoinCountResponse>, t: Throwable) {
            }

        })
        RetrofitClient.api.homeWorkCount().enqueue(object : Callback<HomeWorkCountResponse> {
            override fun onResponse(
                call: Call<HomeWorkCountResponse>,
                response: Response<HomeWorkCountResponse>
            ) {
                binding.homeWorkCnt.text = response.body()?.count.toString()
            }

            override fun onFailure(call: Call<HomeWorkCountResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        binding.registerCntLayout.setOnClickListener {
            if (viewModel.isPending.value != true) {
                activity?.findNavController(R.id.fragment_club)?.navigate(R.id.action_homeFragment_to_pendingRegisterFragment)
            }
            viewModel.setIsPending(true)

        }
        binding.homeWorkCntLayout.setOnClickListener {
            if (viewModel.isPending.value != true) {
                activity?.findNavController(R.id.fragment_club)?.navigate(R.id.action_homeFragment_to_pendingHomeWorkFragment)
            }
            viewModel.setIsPending(true)
        }
        return binding.root
    }
}