package com.gads.practiceproject.shared.store.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.view.View
import com.gads.practiceproject.R

fun View.setAnimatedVisibility(visibility: Int) {
    val endAnimVisibility = this.getTag(R.id.finalVisibility) as Int?
    val oldVisibility = endAnimVisibility ?: this.visibility

    if (oldVisibility == visibility) {
        return
    }

    val isVisible = oldVisibility == View.VISIBLE
    val willBeVisible = visibility == View.VISIBLE

    this.visibility = View.VISIBLE
    val startAlpha = if (endAnimVisibility != null) {
        this.alpha
    } else {
        if (isVisible) 1f else 0f
    }
    val endAlpha = if (willBeVisible) 1f else 0f

    val alpha = ObjectAnimator.ofFloat(this, View.ALPHA, startAlpha, endAlpha)
    alpha.setAutoCancel(true)

    alpha.addListener(object : AnimatorListenerAdapter() {
        private var isCanceled: Boolean = false

        override fun onAnimationStart(anim: Animator) {
            this@setAnimatedVisibility.setTag(R.id.finalVisibility, visibility)
        }

        override fun onAnimationCancel(anim: Animator) {
            isCanceled = true
        }

        override fun onAnimationEnd(anim: Animator) {
            this@setAnimatedVisibility.setTag(R.id.finalVisibility, null)
            if (!isCanceled) {
                this@setAnimatedVisibility.alpha = 1f
                this@setAnimatedVisibility.visibility = visibility
            }
        }
    })
    alpha.start()
}