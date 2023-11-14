package com.dunglv.foodapp.ui.homemain.search

import android.os.Bundle
import android.view.View
import com.dunglv.foodapp.R
import com.dunglv.foodapp.databinding.FragmentSearchBinding
import com.dunglv.foodapp.ui.adapter.SearchAdapter
import com.dunglv.foodapp.ui.base.BaseBindingFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel

class SearchFragment : BaseBindingFragment<FragmentSearchBinding, MainViewModel>() {
    private val searchAdapter: SearchAdapter by lazy {
        SearchAdapter().apply {

        }
    }


    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_search
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        binding.rcSong.adapter =searchAdapter
        initData()
    }

    private fun initData() {
        mainViewModel.initDataSearch(requireContext())
        mainViewModel.listSearchLiveData.observe(viewLifecycleOwner) {
            searchAdapter.submitList(it)
        }
    }

}