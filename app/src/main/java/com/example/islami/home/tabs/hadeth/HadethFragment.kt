package com.example.islami.home.tabs.hadeth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.Constants
import com.example.islami.databinding.FragmentHadethBinding
import com.example.islami.hadethDetails.HadethDetailsActivity
import com.example.islami.model.Hadeth

class HadethFragment:Fragment() {

    lateinit var viewBinding: FragmentHadethBinding
    lateinit var adapter:HadethRecycleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       viewBinding=FragmentHadethBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
       adapter= HadethRecycleAdapter(null)
        adapter.onnItemClickListener=HadethRecycleAdapter.onItemClickListener{
            pos,hadeth ->
            showHadethDetails(hadeth)
        }
        viewBinding.recycleView.adapter=adapter
    }

    private fun showHadethDetails(hadeth: Hadeth) {
       val intent = Intent(activity,HadethDetailsActivity::class.java)
        intent.putExtra(Constants.EXTRA_HADETH,hadeth)
        startActivity(intent)
    }


    override fun onStart() {
        super.onStart()
        loadHadethFile()
        bindHadethList()
    }

    private fun bindHadethList() {
        adapter.bindItems(hadethList)
    }

    val hadethList= mutableListOf<Hadeth>()

    private fun loadHadethFile() {
        val fileContent=requireActivity().assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        val singleHadethList=fileContent.trim().split("#")
        singleHadethList.forEach {element->
            val lines=element.trim().split("\n")
            val title=lines[0]
            val content=lines.joinToString("\n")
            val hadeth=Hadeth(title,content)
            hadethList.add(hadeth)
        }
    }


}