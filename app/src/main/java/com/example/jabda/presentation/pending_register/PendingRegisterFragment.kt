package com.example.jabda.presentation.pending_register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jabda.adapter.RegisterListAdapter
import com.example.jabda.databinding.FragmentPendingRegisterBinding
import com.example.jabda.network.response.join_requests.JoinListResponse

class PendingRegisterFragment: Fragment() {
    lateinit var binding: FragmentPendingRegisterBinding
    lateinit var adapter: RegisterListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPendingRegisterBinding.inflate(inflater, container, false)
        val item = JoinListResponse.request("", "", "", "", "")
        adapter = RegisterListAdapter(JoinListResponse(listOf(item, item, item, item)))
        adapter.setOnClickListener(object : RegisterListAdapter.onClickListener {
            override fun accept(position: Int) {
            }

            override fun reject(position: Int) {
            }
        })
        binding.registerList.adapter = adapter
        binding.registerList.layoutManager = LinearLayoutManager(context)
        return binding.root
    }
}