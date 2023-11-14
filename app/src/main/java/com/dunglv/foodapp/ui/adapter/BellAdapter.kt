package com.dunglv.foodapp.ui.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.dunglv.foodapp.R
import com.dunglv.foodapp.data.model.DataProducts
import com.dunglv.foodapp.databinding.ItemSpecialForYouBinding
import com.dunglv.foodapp.ui.base.BaseBindingAdapter

class BellAdapter : BaseBindingAdapter<DataProducts, ItemSpecialForYouBinding>(
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

    override fun onBindViewHolderBase(holder: BaseHolder<ItemSpecialForYouBinding>, position: Int) {
        with(getItem(holder.adapterPosition)) {

            with(holder) {
                val context = itemView.context
                with(binding) {
                    Glide.with(context).load(image_url).into(imAvatar)
                    tvSale.text = calories.toString()
                    tvGiaOld.text = price.toString()
                    tvGiaNew.text = price.toString()
                }
            }
            holder.itemView.setOnClickListener {
                iClickSongPlay(position, this)
            }

        }


    }

    override val layoutIdItem: Int
        get() = R.layout.item_special_for_you
}