package com.dunglv.foodapp.ui.homemain.home.allfood

import android.os.Bundle
import android.view.View
import com.dunglv.foodapp.R
import com.dunglv.foodapp.databinding.FragmentAllmenuBinding
import com.dunglv.foodapp.ui.adapter.AllMenuAdapter
import com.dunglv.foodapp.ui.base.BaseBindingFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel

class AllMenuFragment : BaseBindingFragment<FragmentAllmenuBinding, MainViewModel>() {

    private val allMenuAdapter: AllMenuAdapter by lazy {
        AllMenuAdapter().apply {
        }

    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_allmenu
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        binding.rcSong.adapter = allMenuAdapter
        initData()
    }

    private fun initData() {
        mainViewModel.initDataAllMenu(requireContext())
        mainViewModel.listAllMenuLiveData.observe(viewLifecycleOwner) {
            allMenuAdapter.submitList(it)
        }
    }
}