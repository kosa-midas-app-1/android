package com.example.jabda.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jabda.databinding.ItemRegisterBinding
import com.example.jabda.network.response.join_requests.JoinListResponse

class RegisterListAdapter(val itemList: JoinListResponse): RecyclerView.Adapter<RegisterListAdapter.ViewHolder>() {
    interface onClickListener {
        fun accept(position: Int)
        fun reject(position: Int)
    }

    lateinit var itemClickListener: onClickListener

    fun setOnClickListener(clickListener: onClickListener) {
        this.itemClickListener = clickListener
    }

    class ViewHolder(binding: ItemRegisterBinding, itemClickListener: onClickListener): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: JoinListResponse.request) {

        }

        init {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRegisterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), itemClickListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList.requests[position])
    }

    override fun getItemCount(): Int = itemList.requests.size
}