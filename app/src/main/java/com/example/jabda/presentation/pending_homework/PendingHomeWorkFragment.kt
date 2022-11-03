package com.example.jabda.presentation.pending_homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jabda.adapter.HomeWorkListAdapter
import com.example.jabda.databinding.FragmentPendingHomeworkBinding
import com.example.jabda.network.response.work_home_requests.ListWorkHomeResponse
import com.example.jabda.network.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PendingHomeWorkFragment: Fragment() {
    lateinit var binding: FragmentPendingHomeworkBinding
    lateinit var adapter: HomeWorkListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPendingHomeworkBinding.inflate(inflater, container, false)
        RetrofitClient.api.listWorkHome().enqueue(object : Callback<ListWorkHomeResponse> {
            override fun onResponse(
                call: Call<ListWorkHomeResponse>,
                response: Response<ListWorkHomeResponse>
            ) {
                adapter = HomeWorkListAdapter(response.body()!!)
                adapter.setOnClickListener(object : HomeWorkListAdapter.onClickListener {
                    override fun accept(position: Int) {
                        RetrofitClient.api.approveHomeWork(response.body()?.staff?.get(position)?.id!!)
                    }

                    override fun reject(position: Int) {
                        RetrofitClient.api.rejectHomeWork(response.body()?.staff?.get(position)?.id!!)
                    }
                })
                binding.homeworkList.adapter = adapter
                binding.homeworkList.layoutManager = LinearLayoutManager(context)
            }

            override fun onFailure(call: Call<ListWorkHomeResponse>, t: Throwable) {
            }
        })
        return binding.root
    }
}