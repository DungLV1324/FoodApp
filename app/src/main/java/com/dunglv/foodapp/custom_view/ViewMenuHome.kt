package com.dunglv.foodapp.custom_view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.dunglv.foodapp.R
import com.dunglv.foodapp.databinding.ViewMenuHomeBinding

class ViewMenuHome : FrameLayout {

    private var binding: ViewMenuHomeBinding =
        ViewMenuHomeBinding.inflate(LayoutInflater.from(context), this, true)
    private var textBottom: String = ""
        set(value) {
            field = value
            binding.tvName.text = value
        }

//    private fun setView(image: Int, background: Int) {
//        binding.vBackground.setBackgroundResource(background)
//    }


    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val typeArray: TypedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.ViewMenuHome, 0, 0)
        textBottom = typeArray.getString(R.styleable.ViewMenuHome_textBottom).toString()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)


}