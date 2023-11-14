package com.dunglv.foodapp.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.dunglv.foodapp.R
import com.dunglv.foodapp.data.model.Intro
import com.dunglv.foodapp.databinding.ItemSplashBinding
import com.dunglv.foodapp.ui.base.BaseBindingAdapter

class IntroAdapter : BaseBindingAdapter<Intro, ItemSplashBinding>(
    object : DiffUtil.ItemCallback<Intro>() {
        override fun areItemsTheSame(oldItem: Intro, newItem: Intro) =
            oldItem.textBelow == newItem.textBelow

        override fun areContentsTheSame(oldItem: Intro, newItem: Intro): Boolean {
            return oldItem == newItem
        }
    }
) {
    override fun onBindViewHolderBase(holder: BaseHolder<ItemSplashBinding>, position: Int) {
        with(getItem(holder.adapterPosition)) {
            with(holder) {
                with(binding) {
                    tvAbove.text = textAbove
                    tvBelow.text = textBelow
                }
            }

        }
    }

    override val layoutIdItem: Int
        get() = R.layout.item_splash
}