package com.example.recyclerviewhomework


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.recyclerviewhomework.databinding.FragmentClicketItemBinding
import com.squareup.picasso.Picasso

class ClicketItemFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentClicketItemBinding>(inflater,R.layout.fragment_clicket_item,container,false)
        val args = ClicketItemFragmentArgs.fromBundle(arguments!!)
        val key = args.resultId

        val application = requireNotNull(this.activity).application
        val dataSource = DownloadedRoomDataBase.getInstance(application).downloadedDataDao
        val viewModelFactory = ClicketItemViewModelFactory(dataSource,application,key)
        val clicketitemViewModel = ViewModelProviders.of(this,viewModelFactory).get(ClicketitemViewModel::class.java)
        binding.setLifecycleOwner(this)
        binding.clicketItemViewModel = clicketitemViewModel
        val item: Result? = clicketitemViewModel.item
        binding.articleDateText.text = item?.webPublicationDate
        binding.articleHeadlineText.text = item?.fields?.headline
        binding.articleRatingText.text = item?.fields?.starRating
        Picasso.with(this.context)
            .load(item?.fields?.thumbnail)
            .into(binding.articleImage)

            return binding.root
    }
}
