package com.example.andrii.mvvm.modules.main.binding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso


@BindingAdapter("app:imageUrl")
fun loadImage(view: ImageView, url: String) {
    Picasso.with(view.context).load(url).into(view)
}