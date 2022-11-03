package com.example.jabda.presentation.manage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jabda.adapter.MemberListAdapter
import com.example.jabda.databinding.FragmentManageBinding
import com.example.jabda.network.response.staff.CommuteListResponse
import java.util.*

class ManageFragment: Fragment() {
    private lateinit var binding: FragmentManageBinding
    private lateinit var adapter: MemberListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManageBinding.inflate(inflater, container, false)
        val item = CommuteListResponse.Staff("", "", "", "", "", "", Date(), Date())
        adapter = MemberListAdapter(CommuteListResponse(listOf(item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item, item)))
        adapter.setOnClickListener(object : MemberListAdapter.onClickListener{
            override fun detail(position: Int) {

            }
        })
        binding.memberList.adapter = adapter
        binding.memberList.layoutManager = LinearLayoutManager(context)
        return binding.root
    }
}