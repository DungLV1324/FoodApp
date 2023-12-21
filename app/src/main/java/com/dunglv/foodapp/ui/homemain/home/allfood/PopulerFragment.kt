package com.dunglv.foodapp.ui.homemain.home.allfood

import android.os.Bundle
import android.view.View
import com.dunglv.foodapp.R
import com.dunglv.foodapp.common.Constant
import com.dunglv.foodapp.databinding.FragmentPopulerBinding
import com.dunglv.foodapp.ui.adapter.PopulerAdapter
import com.dunglv.foodapp.ui.base.BaseBindingFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel
import com.google.gson.Gson
import timber.log.Timber

class PopulerFragment : BaseBindingFragment<FragmentPopulerBinding, MainViewModel>() {

    private val populerAdapter: PopulerAdapter by lazy {
        PopulerAdapter().apply {
            iClickSongPlay = { pos, products ->
                Bundle().apply {
                    putInt(Constant.KEY_DATA, products.id)
                    putInt(Constant.KEY_POS, pos)
                    navigateBundle(R.id.fragment_food_detail, this)
                }
            }
        }
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_populer
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        binding.rcFood.adapter = populerAdapter
        initData()
    }



    private fun initData() {
        mainViewModel.initDataPopuler(requireContext())
        mainViewModel.listPopulerLiveData.observe(viewLifecycleOwner) {
            populerAdapter.submitList(it)
        }
    }

}