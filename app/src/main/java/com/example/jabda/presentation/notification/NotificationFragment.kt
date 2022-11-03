package com.example.jabda.presentation.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jabda.adapter.NotificationListAdapter
import com.example.jabda.databinding.FragmentNotificationBinding
import com.example.jabda.network.response.notices.NoticesResponse
import java.util.*

class NotificationFragment: Fragment() {
    lateinit var binding: FragmentNotificationBinding
    lateinit var adapter: NotificationListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        val item = NoticesResponse.Notice("", Date())
        adapter = NotificationListAdapter(NoticesResponse(listOf(item, item, item, item, item)))
        binding.notificationList.adapter = adapter
        binding.notificationList.layoutManager = LinearLayoutManager(context)
        return binding.root
    }
}