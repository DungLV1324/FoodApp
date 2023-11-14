package com.dunglv.foodapp.ui.homemain.user

import android.os.Bundle
import android.view.View
import com.dunglv.foodapp.R
import com.dunglv.foodapp.databinding.FragmentMyProfileBinding
import com.dunglv.foodapp.ui.base.BaseBindingFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel

class UserFragment : BaseBindingFragment<FragmentMyProfileBinding, MainViewModel>() {


    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_my_profile
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {

    }

    private fun onClick() {

    }

}