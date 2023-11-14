package com.dunglv.foodapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dunglv.foodapp.ui.homemain.home.allfood.AllMenuFragment
import com.dunglv.foodapp.ui.homemain.home.allfood.FoodFragment
import com.dunglv.foodapp.ui.homemain.home.allfood.PizzaFragment
import com.dunglv.foodapp.ui.homemain.home.allfood.PopulerFragment
import com.dunglv.foodapp.ui.homemain.home.allfood.TopFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val populerFragment: PopulerFragment by lazy { PopulerFragment() }
    private val pizzaFragment: PizzaFragment by lazy { PizzaFragment() }
    private val topFragment: TopFragment by lazy { TopFragment() }
    private val allMenuFragment: AllMenuFragment by lazy { AllMenuFragment() }
    private val foodFragment: FoodFragment by lazy { FoodFragment() }


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> pizzaFragment
            2 -> topFragment
            3 -> allMenuFragment
            4 -> foodFragment
            else -> populerFragment
        }
    }

    override fun getItemCount(): Int {
        return 5
    }
}