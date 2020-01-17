package com.example.recyclerviewhomework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewhomework.databinding.ListItemBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*

class ResultViewHolder private constructor(val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Result, clickListener: ResultListener) {
        binding.articleNameText.text = item.webTitle
        binding.clickListener = clickListener
        Picasso.with(itemView.context)
            .load(item.fields.thumbnail)
            .into(itemView.article_thumbnail_image)
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
