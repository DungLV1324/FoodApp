package com.dunglv.foodapp.ui.homemain.user

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.dunglv.foodapp.R
import com.dunglv.foodapp.databinding.FragmentMyProfileBinding
import com.dunglv.foodapp.ui.base.BaseBindingFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel

class UserFragment : BaseBindingFragment<FragmentMyProfileBinding, MainViewModel>() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_my_profile
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        sharedPreferences = requireActivity().getSharedPreferences("myapp", Context.MODE_PRIVATE)
        onClick()
    }

    private fun onClick() {
        binding.tvLogoutApp.setOnClickListener {
            remove()
            saveCheckToken(false)
            navigateFragment(R.id.fragment_login)

        }
    }

    private fun remove() {
        val edit = sharedPreferences.edit()
        edit.remove("token")
        edit.apply()
    }

    private fun saveCheckToken(isCheck: Boolean) {
        val editor = sharedPreferences.edit()
        editor?.putBoolean("isCheck", isCheck)
        editor?.apply()
    }
}