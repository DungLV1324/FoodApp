package com.dunglv.foodapp.ui.homemain.detailfood

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.dunglv.foodapp.MainActivity
import com.dunglv.foodapp.R
import com.dunglv.foodapp.common.Constant
import com.dunglv.foodapp.data.model.DataProducts
import com.dunglv.foodapp.databinding.FragmentFoodDetailBinding
import com.dunglv.foodapp.ui.base.BaseBindingFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel
import timber.log.Timber

class DetailFoodFragment : BaseBindingFragment<FragmentFoodDetailBinding, MainViewModel>() {

    var products: DataProducts? = null
    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_food_detail
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initData()
        onClick()
    }

    private fun initData() {
        arguments?.getInt(Constant.KEY_DATA)?.let {
            mainViewModel.initDataDetail(requireContext(), it)
            mainViewModel.listDetailLiveData.observe(viewLifecycleOwner) { list ->
                list?.let { data ->
                    with(binding) {
                        with(data) {
                            tvName.text = name
                            Glide.with(requireContext()).load(image_url).into(cvAvatar)
                            tvTitle.text = description
                            tvGiaNew.text = price.toString()
                            tvCalo.text = calories.toString()
                        }
                    }

                }
            }
        }
}

    private fun onClick() {
        binding.imBack.setOnClickListener {
            (requireActivity() as MainActivity).navController.popBackStack()
        }
        arguments?.getInt(Constant.KEY_POS)?.let { pos ->
        }
    }

}