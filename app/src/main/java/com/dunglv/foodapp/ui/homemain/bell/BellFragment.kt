package com.dunglv.foodapp.ui.homemain.bell

import android.os.Bundle
import android.view.View
import com.dunglv.foodapp.R
import com.dunglv.foodapp.databinding.FragmentBellBinding
import com.dunglv.foodapp.ui.adapter.BellAdapter
import com.dunglv.foodapp.ui.base.BaseBindingFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel

class BellFragment : BaseBindingFragment<FragmentBellBinding, MainViewModel>() {
    private val bellAdapter: BellAdapter by lazy {
        BellAdapter().apply {

        }
    }


    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_bell
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        binding.rcSong.adapter = bellAdapter

        initData()
    }

    private fun initData() {
        mainViewModel.initDataBell(requireContext())
        mainViewModel.listBellLiveData.observe(viewLifecycleOwner) {
            bellAdapter.submitList(it)
        }

    }

}