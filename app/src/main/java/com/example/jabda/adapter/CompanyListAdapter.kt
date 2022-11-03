package com.example.jabda.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jabda.databinding.ItemCompanyBinding
import com.example.jabda.network.response.companies.CompaniesResponse

class CompanyListAdapter(val itemList: CompaniesResponse): RecyclerView.Adapter<CompanyListAdapter.ViewHolder>() {
    interface onClickListener {
        fun select(position: Int)
    }

    lateinit var itemClickListener: onClickListener

    fun setOnClickListener(clickListener: onClickListener) {
        this.itemClickListener = clickListener
    }

    class ViewHolder(binding: ItemCompanyBinding, itemClickListener: onClickListener): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CompaniesResponse.Company) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCompanyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), itemClickListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList.companies[position])
    }

    override fun getItemCount(): Int = itemList.companies.size
}