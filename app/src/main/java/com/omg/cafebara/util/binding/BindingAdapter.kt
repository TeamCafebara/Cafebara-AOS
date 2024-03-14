package com.omg.cafebara.util.binding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("selected")
fun View.setSelected(isSelected: Boolean) {
    this.isSelected = isSelected
}

@BindingAdapter("visibility")
fun View.setVisibility(isVisible: Boolean?) {
    if (isVisible == null) return
    this.visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("invisibility")
fun View.setInvisibility(isInvisible: Boolean?) {
    if (isInvisible == null) return
    this.visibility = if (isInvisible) View.VISIBLE else View.INVISIBLE
}
