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

    class ViewHolder(val binding: ItemMemberBinding, itemClickListener: onClickListener): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CommuteListResponse.Staff) {
            binding.nameTxt.text = item.name
            binding.positionTxt.text = item.position
            binding.todayWork.text = "오늘 근무 시간 ${(item.endAt?.time ?: 0 - item.startAt!!.time)}"
            binding.state.text = when(item.status) {
                "NO_DATA" -> "첫 출근전"
                "WORKING" -> "출근중"
                "LEAVE_WORK" -> "퇴근"
                "LEAVE_EARLY" ->  "조퇴"
                "WORK_HOME" -> "재택근무중"
                else -> "데이터 없음"
            }
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