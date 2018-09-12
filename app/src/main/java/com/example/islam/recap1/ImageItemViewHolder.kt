package com.example.islam.recap1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import android.widget.Toast
import com.squareup.picasso.Callback


class ImageItemViewHolder(view: View ,private var context: Context) : RecyclerView.ViewHolder(view ) {
    val imageViewItem=view.image_view_item
    fun bindDataToView(url: String){
        val picasso = Picasso.Builder(context)
                .listener { _, _, e -> e.printStackTrace() }
                .build()
        picasso.load(url).into(imageViewItem)
        //imageViewItem.text=url
    }
}