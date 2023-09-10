package com.example.islami.home.tabs.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemChapterNameBinding

class ChapterNamesRecycleAdapter(private val names:List<String>):RecyclerView.Adapter<ChapterNamesRecycleAdapter.viewHolder>() {

    class viewHolder(val viewBinding:ItemChapterNameBinding):RecyclerView.ViewHolder(viewBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val viewBinding=ItemChapterNameBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.viewBinding.title.text=names[position]
        if (onnItemClickListener!=null){
            holder.viewBinding.root.setOnClickListener{
                onnItemClickListener?.onItemClick(position,names[position])
            }

        }
    }

    override fun getItemCount(): Int =names.size





    var onnItemClickListener: onItemClickListener?=null
     fun interface onItemClickListener{
        fun onItemClick(position: Int,name :String)
    }
}