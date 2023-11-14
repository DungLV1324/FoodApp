package com.dunglv.foodapp.ui.homemain.home.allfood

import android.os.Bundle
import android.view.View
import com.dunglv.foodapp.R
import com.dunglv.foodapp.databinding.FragmentFoodBinding
import com.dunglv.foodapp.ui.adapter.FoodAdapter
import com.dunglv.foodapp.ui.base.BaseBindingFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel

class FoodFragment : BaseBindingFragment<FragmentFoodBinding, MainViewModel>() {

    private val foodAdapter: FoodAdapter by lazy {
        FoodAdapter().apply {

        }
    }


    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_food
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        binding.rcSong.adapter = foodAdapter
        initData()
    }

    private fun initData() {
        mainViewModel.initDataFood(requireContext())
        mainViewModel.listFoodLiveData.observe(viewLifecycleOwner) {
            foodAdapter.submitList(it)
        }
    }
}