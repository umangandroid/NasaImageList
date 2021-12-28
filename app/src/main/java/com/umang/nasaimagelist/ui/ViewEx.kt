package com.umang.nasaimagelist.ui

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.umang.nasaimagelist.R


fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .load(url) // image url
        .placeholder(R.drawable.ic_photo_gallery)
        .error(R.drawable.baseline_error_24)
        .transition(DrawableTransitionOptions.withCrossFade())
        .centerCrop()
        .into(this)
}
