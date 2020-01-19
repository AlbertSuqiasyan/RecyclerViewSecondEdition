package com.example.recyclerviewhomework

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//class ResultAdapter(private val list: List<Result>,val clickListener: ResultListener) : ListAdapter<Result,ResultViewHolder>(ResultDiffCallback(list))

class ResultAdapter(private val list: List<Result>,val clickListener: ResultListener) : RecyclerView.Adapter<ResultViewHolder>() {
    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val item: Result = list[position]
        val itemPosition = position
        holder.bind(item,clickListener,itemPosition)

    }
}
class ResultListener(val clickListener: (resultId: String,itemPosition: Int) -> Unit) {
    fun onClick(result: Result, itemPosition: Int) = clickListener(result.id,itemPosition)
}

// try diffutil again later
//class ResultDiffCallback(private val list: List<Result>) : DiffUtil.ItemCallback<Result>() {
//    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
//        return oldItem.webTitle == newItem.webTitle
//    }
//
//    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
//        return oldItem == newItem
//    }
//
//}