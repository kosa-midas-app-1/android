package com.example.jabda.presentation.manage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jabda.R
import com.example.jabda.adapter.MemberListAdapter
import com.example.jabda.databinding.FragmentManageBinding
import com.example.jabda.network.response.staff.CommuteListResponse
import com.example.jabda.network.retrofit.RetrofitClient
import com.example.jabda.presentation.main.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ManageFragment: Fragment() {
    private lateinit var binding: FragmentManageBinding
    private lateinit var adapter: MemberListAdapter
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManageBinding.inflate(inflater, container, false)
//        RetrofitClient.api.commuteList().enqueue(object : Callback<CommuteListResponse> {
//            override fun onResponse(
//                call: Call<CommuteListResponse>,
//                response: Response<CommuteListResponse>
//            ) {
//                adapter = MemberListAdapter(response.body()!!)
//                adapter.setOnClickListener(object : MemberListAdapter.onClickListener{
//                    override fun detail(position: Int) {
//                        activity?.findNavController(R.id.fragment_club)?.navigate(R.id.action_manageFragment_to_detailMemberFragment)
//                        viewModel.setIsDetail(true)
//                    }
//                })
//                binding.memberList.adapter = adapter
//                binding.memberList.layoutManager = LinearLayoutManager(context)
//            }
//
//            override fun onFailure(call: Call<CommuteListResponse>, t: Throwable) {
//            }
//        })
        val item = CommuteListResponse.Staff("", "", "", "", "", "", Date(), Date())
        adapter = MemberListAdapter(CommuteListResponse(listOf(item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item)))
        adapter.setOnClickListener(object : MemberListAdapter.onClickListener{
            override fun detail(position: Int) {
                activity?.findNavController(R.id.fragment_club)?.navigate(R.id.action_manageFragment_to_detailMemberFragment)
                viewModel.setIsDetail(true)
            }
        })
        binding.memberList.adapter = adapter
        binding.memberList.layoutManager = LinearLayoutManager(context)
        return binding.root
    }
}