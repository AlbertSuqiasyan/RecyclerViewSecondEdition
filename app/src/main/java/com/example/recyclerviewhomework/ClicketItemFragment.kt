package com.example.recyclerviewhomework


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.recyclerviewhomework.databinding.FragmentClicketItemBinding

class ClicketItemFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentClicketItemBinding>(inflater,R.layout.fragment_clicket_item,container,false)
//        val args = MainFragmentArgs.fromBundle(arguments!!)
//        val downloadedRoomDataBase = DownloadedRoomDataBase.getInstance()
        binding.articleDateText.text =

        return binding.root
    }


}
