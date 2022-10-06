package com.example.flagkotlinapicoroutine.dataBinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.flagkotlinapicoroutine.BuildConfig
import com.example.flagkotlinapicoroutine.Utils.exts.loadImage


@BindingAdapter("poster")
fun loadImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        view.loadImage(BuildConfig.BASE_IMAGE + url)
    }
}

