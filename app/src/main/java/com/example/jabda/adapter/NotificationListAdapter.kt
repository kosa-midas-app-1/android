package com.example.jabda.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jabda.databinding.ItemNotificationBinding
import com.example.jabda.network.response.notices.NoticesResponse

class NotificationListAdapter(val itemList: NoticesResponse): RecyclerView.Adapter<NotificationListAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemNotificationBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NoticesResponse.Notice) {
//            binding.content.text = item.content
//            binding.date.text = item.createdAt.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNotificationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList.notices[position])
    }

    override fun getItemCount(): Int = itemList.notices.size
}