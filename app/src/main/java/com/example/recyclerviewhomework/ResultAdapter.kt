package com.example.recyclerviewhomework

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ResultAdapter(private val list: List<Result>) : RecyclerView.Adapter<ResultViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val item: Result = list[position]
        holder.bind(item)
    }
}




// how to pass the result id?
//delete the class is program works(sort of)
class ResultListener(val clickListener: ()){
    fun onClick(item: Result) =
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