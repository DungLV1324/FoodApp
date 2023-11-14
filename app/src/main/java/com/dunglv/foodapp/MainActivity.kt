package com.dunglv.foodapp

import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.dunglv.foodapp.databinding.ActivityMainBinding
import com.dunglv.foodapp.ui.base.BaseBindingActivity
import com.dunglv.foodapp.ui.homemain.MainViewModel

class MainActivity : BaseBindingActivity<ActivityMainBinding, MainViewModel>() {


    private val navHostFragment: NavHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment }
    val navController: NavController by lazy { navHostFragment.navController }


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun setupView(savedInstanceState: Bundle?) {

    }

    override fun setupData() {

    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }
}
