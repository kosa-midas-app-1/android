package com.example.jabda.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jabda.databinding.ItemHomeworkBinding
import com.example.jabda.network.response.work_home_requests.ListWorkHomeResponse

class HomeWorkListAdapter(val itemList: ListWorkHomeResponse): RecyclerView.Adapter<HomeWorkListAdapter.ViewHolder>() {
    interface onClickListener {
        fun accept(position: Int)
        fun reject(position: Int)
    }

    lateinit var itemClickListener: onClickListener

    fun setOnClickListener(clickListener: onClickListener) {
        this.itemClickListener = clickListener
    }

    class ViewHolder(val binding: ItemHomeworkBinding, val itemClickListener: onClickListener): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListWorkHomeResponse.Staff, position: Int) {
//            binding.nameTxt.text= item.name
//            binding.positionTxt.text = item.position
//            binding.phoneTxt.text = item.phone
//            binding.emailTxt.text = item.email
//            binding.dateTxt.text = item.date
//            binding.reasonTxt.text = item.reason
//            binding.approveBtn.setOnClickListener {
//                itemClickListener.accept(position)
//            }
//            binding.rejectBtn.setOnClickListener {
//                itemClickListener.reject(position)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHomeworkBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), itemClickListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList.staff[position], position)
    }

    override fun getItemCount(): Int = itemList.staff.size
}