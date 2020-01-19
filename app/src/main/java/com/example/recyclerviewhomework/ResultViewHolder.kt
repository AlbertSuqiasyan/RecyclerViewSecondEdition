package com.example.recyclerviewhomework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewhomework.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class ResultViewHolder private constructor(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: Result,
        clickListener: ResultListener,
        itemPosition: Int
    ) {
        binding.articleNameText.text = item.webTitle
        binding.listItem.setOnClickListener{view: View? -> clickListener.onClick(item,itemPosition) }
        Picasso.with(itemView.context)
            .load(item.fields.thumbnail)
            .into(binding.articleThumbnailImage)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ResultViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemBinding.inflate(layoutInflater,parent,false)
            return ResultViewHolder(binding)
        }
    }


}
