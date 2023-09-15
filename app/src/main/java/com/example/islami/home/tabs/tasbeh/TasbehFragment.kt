package com.example.islami.home.tabs.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.Constants
import com.example.islami.databinding.FragmentHadethBinding
import com.example.islami.databinding.FragmentRadioBinding
import com.example.islami.databinding.FragmentTasbehBinding

class TasbehFragment:Fragment() {
     lateinit var viewBinding :FragmentTasbehBinding
     var counter=0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding= FragmentTasbehBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.convertText.text=Constants.SOBHAN_ALLAH
        viewBinding.counterSeb7a.text="$counter"

        viewBinding.sebhaBody.setOnClickListener {
            onClickSebhaImage()
        }

    }

    private fun onClickSebhaImage() {
        viewBinding.sebhaBody.rotation=viewBinding.sebhaBody.rotation+5
        counter++
        viewBinding.counterSeb7a.text="$counter"

        if (viewBinding.convertText.text==Constants.ELKETMA){
            viewBinding.convertText.text=Constants.ELKETMA
            counter=0
            viewBinding.counterSeb7a.text="$counter"

        }
        if (counter ==33){

            if (viewBinding.convertText.text==Constants.SOBHAN_ALLAH) {
                viewBinding.convertText.text == Constants.ALHAMDUL_ALLAH
                counter=0
                viewBinding.counterSeb7a.text="$counter"
            }
            else if ( viewBinding.convertText.text == Constants.ALHAMDUL_ALLAH) {
                viewBinding.convertText.text == Constants.ALLAH_AKBAR
                counter = 0
                viewBinding.counterSeb7a.text = "$counter"
            }
            else if(viewBinding.convertText.text == Constants.ALLAH_AKBAR){
                viewBinding.convertText.text == Constants.ELKETMA
                counter = 0
                viewBinding.counterSeb7a.text = "$counter"
            }


        }
    }


}