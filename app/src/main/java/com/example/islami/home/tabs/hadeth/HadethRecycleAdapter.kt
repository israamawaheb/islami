package com.example.islami.home.tabs.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemHadethBinding
import com.example.islami.model.Hadeth

class HadethRecycleAdapter(var items:List<Hadeth>?):RecyclerView.Adapter<HadethRecycleAdapter.viewHolder>() {


    class viewHolder(val viewBinding:ItemHadethBinding):RecyclerView.ViewHolder(viewBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val viewBinding=ItemHadethBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return viewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.viewBinding.title.text=items!![position].title
        if (onnItemClickListener!=null){
            holder.viewBinding.root.setOnClickListener {
                onnItemClickListener?.onItemClick(position,items!![position])
            }
        }

    }

    override fun getItemCount(): Int {
        return items?.size ?:0
    }
    fun bindItems(newList: List<Hadeth>){
         items=newList
        notifyDataSetChanged()
    }

    var onnItemClickListener:onItemClickListener?=null
    fun interface onItemClickListener {
        fun onItemClick(position: Int,item:Hadeth)

    }
}