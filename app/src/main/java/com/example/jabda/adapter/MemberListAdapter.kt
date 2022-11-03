package com.example.jabda.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jabda.databinding.ItemMemberBinding
import com.example.jabda.network.response.staff.CommuteListResponse

class MemberListAdapter(val itemList: CommuteListResponse): RecyclerView.Adapter<MemberListAdapter.ViewHolder>() {
    interface onClickListener {
        fun detail(position: Int)
    }

    lateinit var itemClickListener: onClickListener

    fun setOnClickListener(clickListener: onClickListener) {
        this.itemClickListener = clickListener
    }

    class ViewHolder(binding: ItemMemberBinding, itemClickListener: onClickListener): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CommuteListResponse.Staff) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMemberBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), itemClickListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList.staff[position])
    }

    override fun getItemCount(): Int = itemList.staff.size
}