package com.example.islami.chapterDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemChapterNameBinding
import com.example.islami.databinding.ItemVerseBinding

class VersesAdapter( val  verses:List<String>) :RecyclerView.Adapter<VersesAdapter.viewHolder>() {


    class viewHolder(val viewBinding:ItemVerseBinding):RecyclerView.ViewHolder(viewBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val viewBinding =ItemVerseBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.viewBinding.content.text=verses[position]
    }

    override fun getItemCount(): Int {
        return verses.size
    }
}