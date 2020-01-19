package com.example.recyclerviewhomework


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewhomework.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*


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
            binding.recyclerView.adapter = ResultAdapter(resultList,ResultListener { resultId,itemPosition ->
                Log.i("resultId","$resultId")
                binding.recyclerView.findViewHolderForItemId(itemPosition.toLong())?.itemView?.findNavController()
                ?.navigate(MainFragmentDirections.actionMainFragmentToClicketItemFragment(resultId))
                 })
        })

        return binding.root
    }

}
