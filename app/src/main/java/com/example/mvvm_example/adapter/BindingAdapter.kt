package com.example.mvvm_example.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.mvvm_example.R

object BindingAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {
        if (url == "N/A") {
            return
        }
        Glide.with(imageView.context).load(url).error(R.drawable.ic_launcher_background)
            .into(imageView)
    }
}