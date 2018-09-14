package com.example.islam.recap1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_view_item.view.*


class ImageItemViewHolder(var view: View ,private var context: Context) : RecyclerView.ViewHolder(view ) {
    fun bindDataToView(url: String){
        val picasso = Picasso.Builder(view.context)
                .listener { _, _, e -> e.printStackTrace() }
                .build()
        picasso.load("http://image.tmdb.org/t/p/w342/"+url).into(view.image_view_item)
    }
}