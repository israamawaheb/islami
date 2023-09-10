package com.example.islami.chapterDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.Constants
import com.example.islami.databinding.ActivityChapterDetailsBinding
import kotlin.properties.Delegates

class ChapterDetailsActivity:AppCompatActivity() {

    lateinit var viewBinding:ActivityChapterDetailsBinding
    lateinit var chapterName :String
    var chapterIndex :Int=0
    lateinit var adapter: VersesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding=ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initParams()
        initViews()
        loadChapterFile()



    }

    private fun initViews() {
        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        viewBinding.titleTvSura.text=chapterName
        supportActionBar?.title=""
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true

    }

    private fun loadChapterFile() {
        val fileContent= assets.open("$chapterIndex.txt").bufferedReader().use { it.readText() }
        val lines= fileContent.trim().split("\n")
        bindVerses(lines)

    }

    private fun bindVerses( verses: List<String>) {
         adapter=VersesAdapter(verses)
         viewBinding.content.versesRecycleView.adapter=adapter
    }


    private fun initParams() {
        chapterName= intent.getStringExtra(Constants.EXTRE_CHAPTER_NAME)?:""
        chapterIndex=intent.getIntExtra(Constants.EXTRE_CHAPTER_INDEX,0 )
    }

}