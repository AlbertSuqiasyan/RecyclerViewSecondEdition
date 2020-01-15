package com.example.recyclerviewhomework


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewhomework.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var viewModel: ResultViewModel
    private lateinit var viewModelFactory: ResultViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
       val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,R.layout.fragment_main,container,false)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        viewModelFactory = ResultViewModelFactory()
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(ResultViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.response.observe(viewLifecycleOwner, Observer {resultList ->
            binding.recyclerView.adapter = ResultAdapter(resultList)
        })
        return binding.root
    }

}
