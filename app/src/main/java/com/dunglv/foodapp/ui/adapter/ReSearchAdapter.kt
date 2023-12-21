package com.dunglv.foodapp.ui.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.dunglv.foodapp.R
import com.dunglv.foodapp.data.model.DataProducts
import com.dunglv.foodapp.databinding.ItemFoodBinding
import com.dunglv.foodapp.databinding.ItemFullFoodBinding
import com.dunglv.foodapp.databinding.ItemSearchBinding
import com.dunglv.foodapp.ui.base.BaseBindingAdapter

class ReSearchAdapter : BaseBindingAdapter<DataProducts, ItemFullFoodBinding>(
    object : DiffUtil.ItemCallback<DataProducts>() {
        override fun areItemsTheSame(oldItem: DataProducts, newItem: DataProducts) =
            oldItem.id == newItem.id

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: DataProducts, newItem: DataProducts): Boolean {
            return oldItem == newItem
        }
    }
) {

    var iClickSongPlay: (result: Int, products: DataProducts) -> Unit = { _, _ -> }

    override fun onBindViewHolderBase(holder: BaseHolder<ItemFullFoodBinding>, position: Int) {
        with(getItem(holder.adapterPosition)) {
            with(holder) {
                with(binding) {
                    val context = itemView.context
                    Glide.with(context).load(image_url).into(cvAvatar)
                    tvCalo.text = calories.toString()
                    tvName.text = name
                    tvTitle.text = category
                    tvGiaNew.text = price.toString()
                }
            }
            holder.itemView.setOnClickListener {
                iClickSongPlay(position, this)
            }

        }


    }

    override val layoutIdItem: Int
        get() = R.layout.item_full_food
}