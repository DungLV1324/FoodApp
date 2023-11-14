package com.dunglv.foodapp.ui.homemain

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.dunglv.foodapp.R
import com.dunglv.foodapp.databinding.FragmentMainBinding
import com.dunglv.foodapp.ui.adapter.ViewPagerBottonNavAdapter
import com.dunglv.foodapp.ui.base.BaseBindingFragment

class HomeMainFragment : BaseBindingFragment<FragmentMainBinding, MainViewModel>() {

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        setAdapter()
    }

    private fun setAdapter() {
        ViewPagerBottonNavAdapter(childFragmentManager, lifecycle).apply {


            binding.viewPager2.adapter = this
            binding.viewPager2.offscreenPageLimit =5
            binding.viewPager2.isUserInputEnabled = false
            binding.bottomNavigation.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.search -> {
                        binding.viewPager2.setCurrentItem(1,false)
                    }

                    R.id.chuong -> {
                        binding.viewPager2.setCurrentItem(2,false)
                    }

                    R.id.start -> {
                        binding.viewPager2.setCurrentItem(3,false)
                    }

                    R.id.use -> {
                        binding.viewPager2.setCurrentItem(4,false)
                    }

                    else -> {
                        binding.viewPager2.setCurrentItem(0,false)
                    }
                }
                true
            }
            binding.viewPager2.registerOnPageChangeCallback(object : OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when (position) {
                        0 -> binding.bottomNavigation.selectedItemId = R.id.home
                        1 -> binding.bottomNavigation.selectedItemId = R.id.search
                        2 -> binding.bottomNavigation.selectedItemId = R.id.chuong
                        3 -> binding.bottomNavigation.selectedItemId = R.id.start
                        4 -> binding.bottomNavigation.selectedItemId = R.id.use
                    }
                }
            })
        }
    }
}

