package com.dunglv.foodapp.ui.homemain.start

import android.os.Bundle
import android.view.View
import com.dunglv.foodapp.R
import com.dunglv.foodapp.databinding.FragmentLoginBinding
import com.dunglv.foodapp.ui.base.BaseBindingFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel

class StartFragment : BaseBindingFragment<FragmentLoginBinding, MainViewModel>() {


    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_login
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {

    }

    private fun onClick() {

    }

}