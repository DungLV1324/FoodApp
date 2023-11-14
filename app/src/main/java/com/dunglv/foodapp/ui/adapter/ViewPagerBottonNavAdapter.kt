package com.dunglv.foodapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dunglv.foodapp.ui.homemain.bell.BellFragment
import com.dunglv.foodapp.ui.homemain.home.HomeFragment
import com.dunglv.foodapp.ui.homemain.search.SearchFragment
import com.dunglv.foodapp.ui.homemain.start.StartFragment
import com.dunglv.foodapp.ui.homemain.user.UserFragment

class ViewPagerBottonNavAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val homeFragment: HomeFragment by lazy { HomeFragment() }
    private val searchFragment: SearchFragment by lazy { SearchFragment() }
    private val bellFragment: BellFragment by lazy { BellFragment() }
    private val startFragment: StartFragment by lazy { StartFragment() }
    private val userFragment: UserFragment by lazy { UserFragment() }


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> searchFragment
            2 -> bellFragment
            3 -> startFragment
            4 -> userFragment
            else -> homeFragment
        }
    }

    override fun getItemCount(): Int {
        return 5
    }
}