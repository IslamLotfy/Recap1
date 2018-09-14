package com.example.islam.recap1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class ImageRecyclerViewAdapter(private var response:Response ) : RecyclerView.Adapter<ImageItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageItemViewHolder {
        return ImageItemViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.recycler_view_item,parent,false),parent?.context)
    }

    override fun getItemCount(): Int {
        return response.results.size
    }

    override fun onBindViewHolder(p0: ImageItemViewHolder, p1: Int) {
        p0.bindDataToView(response.results[p1].poster_path)
    }
}