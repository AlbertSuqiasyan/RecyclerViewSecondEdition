package com.example.recyclerviewhomework

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ResultAdapter(private val list: List<Result>,val clickListener: ResultListener) : ListAdapter<Result,ResultViewHolder>(ResultDiffCallback(list)) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val item: Result = list[position]
        holder.bind(item,clickListener)

    }
}




// try diffutil again later
class ResultDiffCallback(private val list: List<Result>) : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.webTitle == newItem.webTitle
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }

}