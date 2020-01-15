package com.example.recyclerviewhomework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*

class ResultViewHolder private constructor(itemView: View): RecyclerView.ViewHolder(itemView){

     fun bind(item: Result) {
        itemView.article_name_text.text = item.webTitle
        Picasso.with(itemView.context)
            .load(item.fields.thumbnail)
            .into(itemView.article_thumbnail_image)
    }

    companion object {
         fun from(parent: ViewGroup): ResultViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val listItemView = layoutInflater.inflate(R.layout.list_item, parent, false)
            return ResultViewHolder(listItemView)
        }
    }

}