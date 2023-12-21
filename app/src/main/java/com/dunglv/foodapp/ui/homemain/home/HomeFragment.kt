package com.dunglv.foodapp.ui.homemain.home

import android.os.Bundle
import android.view.View
import com.dunglv.foodapp.R
import com.dunglv.foodapp.bottonsheet.BottomSheetAdress
import com.dunglv.foodapp.databinding.FragmentHomeBinding
import com.dunglv.foodapp.ui.adapter.ViewPagerAdapter
import com.dunglv.foodapp.ui.base.BaseBindingFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseBindingFragment<FragmentHomeBinding, MainViewModel>() {


    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    private val bottomSheetAddres: BottomSheetAdress by lazy {
        BottomSheetAdress().apply {
        }
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        ViewPagerAdapter(childFragmentManager, lifecycle).apply {
            binding.viewPager2.adapter = this
            binding.viewPager2.offscreenPageLimit=5
            binding.viewPager2.isUserInputEnabled=false
            TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
                tab.text = getString(
                    when (position) {
                        1 -> (R.string.pizza)
                        2 -> (R.string.top)
                        3 -> (R.string.all_menu)
                        4 -> (R.string.food)
                        else -> (R.string.populer)
                    }
                )
            }.attach()
        }
        onClick()
    }

    private fun onClick() {
        binding.imDiaChi.setOnClickListener {
            bottomSheetAddres.show(childFragmentManager, bottomSheetAddres.tag)
        }
        binding.imSearch.setOnClickListener {
            navigateFragment(R.id.fragment_research)
        }
    }
}