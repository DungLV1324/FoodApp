package com.dunglv.foodapp.ui.homemain.home.allfood

import android.os.Bundle
import android.view.View
import com.dunglv.foodapp.R
import com.dunglv.foodapp.databinding.FragmentTopBinding
import com.dunglv.foodapp.ui.adapter.HomeAdapter
import com.dunglv.foodapp.ui.adapter.TopAdapter
import com.dunglv.foodapp.ui.base.BaseBindingFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel

class TopFragment : BaseBindingFragment<FragmentTopBinding, MainViewModel>() {

    private val topAdapter: TopAdapter by lazy {
        TopAdapter().apply {

        }
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_top
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        binding.rcSong.adapter = topAdapter
        initData()
    }

    private fun initData() {
        mainViewModel.initDataTop(requireContext())

        mainViewModel.listTopLiveData.observe(viewLifecycleOwner) {
            topAdapter.submitList(it)
        }
    }
}