package com.gads.practiceproject.shared.store.ui

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.squareup.picasso.Picasso

fun ImageView.setImageUrl(url: String?, @DrawableRes imagePlaceholder: Int? = null) {
    val picassoRequestCreator = Picasso.get().load(url)
    if (imagePlaceholder != null)
        picassoRequestCreator.placeholder(imagePlaceholder)
    picassoRequestCreator.into(this)
}