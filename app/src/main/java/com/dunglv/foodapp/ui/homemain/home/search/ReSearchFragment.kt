package com.dunglv.foodapp.ui.homemain.home.search

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import com.dunglv.foodapp.MainActivity
import com.dunglv.foodapp.R
import com.dunglv.foodapp.databinding.FragmentResearchBinding
import com.dunglv.foodapp.ui.adapter.ReSearchAdapter
import com.dunglv.foodapp.ui.base.BaseBindingFragment

class ReSearchFragment : BaseBindingFragment<FragmentResearchBinding, ReSearchViewModel>() {

    private val searchAdapter: ReSearchAdapter by lazy {
        ReSearchAdapter().apply {
            iClickSongPlay = { _, it ->
//                initSwitchScreen(it)
            }
        }
    }

    override fun getViewModel(): Class<ReSearchViewModel> {
        return ReSearchViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_research

    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initAdapter()
        initData()
        onClick()
    }

    private fun onClick() {
        binding.vSearch.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.vSearch.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    viewModel.posNull()
                } else {
                    mainViewModel.listPopulerLiveData.value?.let {
                        viewModel.filterList(newText, it.toMutableList())
                    }
                }
                return true
            }

        })
        binding.imBack.setOnClickListener {
            (activity as MainActivity).navController.popBackStack()
        }
    }


    private fun initData() {
        with(viewModel) {
            listReSearchLiveData.observe(viewLifecycleOwner) {
                it?.let { data ->
                    searchAdapter.submitList(data)
                }
            }
        }
    }

    private fun initAdapter() {
        binding.rcSearchSong.adapter = searchAdapter
    }

//    private fun initSwitchScreen(music: Music) {
//        runCatching {
//            Bundle().apply {
//                putString(Constant.KEY_URI_MUSIC_CURRENT, music.uri)
//                navigateBundle(R.id.fragment_play_music, this)
//            }
//        }.onFailure { it.printStackTrace() }
//
//    }
}