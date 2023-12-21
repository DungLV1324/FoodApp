package com.dunglv.foodapp.ui.homemain.intro

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.dunglv.foodapp.MainActivity
import com.dunglv.foodapp.R
import com.dunglv.foodapp.databinding.ActivityIntroBinding
import com.dunglv.foodapp.ui.adapter.IntroAdapter
import com.dunglv.foodapp.ui.base.BaseBindingActivity
import com.dunglv.foodapp.ui.homemain.HomeMainFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel
import timber.log.Timber

class IntroActivity : BaseBindingActivity<ActivityIntroBinding, MainViewModel>() {

    private val introAdapter: IntroAdapter by lazy {
        IntroAdapter().apply {

        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_intro
    }

    override fun setupView(savedInstanceState: Bundle?) {
        setUpViewPager()
    }

    private fun setUpViewPager() {
        binding.viewPager2.apply {
            adapter = introAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if (position < introAdapter.currentList.size - 1) {
                        binding.tvGet.visibility = View.GONE
                        binding.imNext.visibility = View.VISIBLE
                    } else {
                        binding.tvGet.visibility = View.VISIBLE
                        binding.imNext.visibility = View.GONE
                    }
                }
            })
            binding.dotsIndicator.attachTo(this)
        }
    }


    override fun setupData() {
        binding.viewPager2.adapter = introAdapter
        initData()
        onClick()

    }

    private fun onClick() {

        binding.imNext.setOnClickListener {
            viewModel.listIntroLiveData.value?.size?.let { size ->
                with(binding.viewPager2.currentItem) {
                    if (this < size - 1) {
                        binding.viewPager2.currentItem = this + 1
                    }
                }
            }
        }

        binding.tvGet.setOnClickListener {
            viewModel.listIntroLiveData.value?.size?.let { size ->
                with(binding.viewPager2.currentItem) {
                    if (this == size - 1) {
                        val intent = Intent(this@IntroActivity, MainActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private fun initData() {
        if (viewModel.getTokenFromSharedPreferences(this) != null) {
            Timber.e("dunglv: " + viewModel.getTokenFromSharedPreferences(this))
            val intent = Intent(this@IntroActivity, MainActivity::class.java)
            startActivity(intent)
        } else {
            viewModel.getIntro(this)
            viewModel.listIntroLiveData.observe(this) {
                introAdapter.submitList(it)
            }
        }
    }


    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

}