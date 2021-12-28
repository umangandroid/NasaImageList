package com.umang.nasaimagelist.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter

/**
 * Binding Adapter
 *
 * @param imageView : image to load in
 * @param url : Url of the image view
 */
@BindingAdapter("app:loadImage")
fun loadImage(imageView: ImageView, url: String) {
    imageView.loadImage(url)
}


