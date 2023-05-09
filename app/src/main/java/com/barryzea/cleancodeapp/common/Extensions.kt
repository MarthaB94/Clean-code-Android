package com.barryzea.cleancodeapp.common

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.barryzea.cleancodeapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

fun ImageView.loadUrl(url:String) {

    val placeholder = CircularProgressDrawable(this.context)
    placeholder.strokeWidth = 5f
    placeholder.centerRadius =30f
    placeholder.start()

    Glide.with(this.context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .placeholder(placeholder)
        .error(R.drawable.ic_image_broken)
        .into(this)
}
