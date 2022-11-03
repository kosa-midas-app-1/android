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

class PendingHomeWorkFragment: Fragment() {
    lateinit var binding: FragmentPendingHomeworkBinding
    lateinit var adapter: HomeWorkListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPendingHomeworkBinding.inflate(inflater, container, false)
        val item = ListWorkHomeResponse.Staff("", "", "", "", "", "", "")
        adapter = HomeWorkListAdapter(ListWorkHomeResponse(listOf(item, item, item, item, item)))
        adapter.setOnClickListener(object : HomeWorkListAdapter.onClickListener {
            override fun accept(position: Int) {
            }

            override fun reject(position: Int) {
            }

        })
        binding.homeworkList.adapter = adapter
        binding.homeworkList.layoutManager = LinearLayoutManager(context)
        return binding.root
    }
}