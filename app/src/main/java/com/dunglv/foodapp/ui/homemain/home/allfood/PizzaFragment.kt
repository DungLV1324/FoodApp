package com.dunglv.foodapp.ui.homemain.home.allfood

import android.os.Bundle
import android.view.View
import com.dunglv.foodapp.R
import com.dunglv.foodapp.databinding.FragmentPizzaBinding
import com.dunglv.foodapp.ui.adapter.PizzaAdapter
import com.dunglv.foodapp.ui.base.BaseBindingFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel

class PizzaFragment : BaseBindingFragment<FragmentPizzaBinding, MainViewModel>() {
    private val pizzaAdapter: PizzaAdapter by lazy {
        PizzaAdapter().apply {

        }
    }


    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_pizza
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        binding.rcSong.adapter = pizzaAdapter
        initData()
    }

    private fun initData() {
        mainViewModel.initDataPizza(requireContext())
        mainViewModel.listPizzaLiveData.observe(viewLifecycleOwner) {
            pizzaAdapter.submitList(it)
        }
    }
}