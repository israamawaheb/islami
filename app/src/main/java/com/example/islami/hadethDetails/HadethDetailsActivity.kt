package com.example.islami.hadethDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.Constants
import com.example.islami.databinding.ActivityHadethDetailsBinding
import com.example.islami.model.Hadeth

class HadethDetailsActivity:AppCompatActivity(){

    lateinit var viewBinding:ActivityHadethDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
        initParams()
        bindHadeth()



    }

    private fun initViews() {
        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title=null
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
        finish()
        return true
    }

    private fun bindHadeth() {
        viewBinding.titleTv.text=hadeth?.title
        viewBinding.content.content.text=hadeth?.content
    }

    var hadeth: Hadeth?=null
    private fun initParams() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth= intent.getParcelableExtra(Constants.EXTRA_HADETH,Hadeth::class.java)
        }else{
            hadeth= intent.getParcelableExtra(Constants.EXTRA_HADETH)
        }
    }

}