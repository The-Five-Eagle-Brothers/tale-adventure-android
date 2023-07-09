package com.android.ssutudy.util.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.core.view.children
import com.android.ssutudy.R
import com.google.android.flexbox.FlexboxLayout

fun FlexboxLayout.submitList(
    clickable: Boolean,
    itemList: List<String>, plusCategoryCount: (() -> Unit)? = null,
    minusCategoryCount: (() -> Unit)? = null,
    @LayoutRes backgroundResource: Int = R.layout.view_category,
) {
    removeAllViews()
    itemList.forEach { text ->
        if (clickable) {
            addClickableTextview(
                textResource = text, plusCategoryCount = plusCategoryCount,
                minusCategoryCount = minusCategoryCount
            )
        } else {
            addTextview(textResource = text, backgroundResource = backgroundResource)
        }
    }
}

fun FlexboxLayout.addClickableTextview(
    textResource: String,
    plusCategoryCount: (() -> Unit)?,
    minusCategoryCount: (() -> Unit)?,
) {
    val textView =
        (LayoutInflater.from(context)
            .inflate(R.layout.view_category_of_interest, null) as TextView).apply {
            text = textResource
            setOnClickListener { textView ->
                if (textView.isSelected) {
                    minusCategoryCount?.invoke()
                    textView.isSelected = false
                } else {
                    plusCategoryCount?.invoke()
                    textView.isSelected = true
                }
            }
        }

    val layoutParams = ViewGroup.MarginLayoutParams(
        ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT
    ).apply {
        rightMargin = context.dpToPx(12)
        bottomMargin = context.dpToPx(10)
    }

    addView(textView, layoutParams)
}

fun FlexboxLayout.addTextview(
    textResource: String,
    @LayoutRes backgroundResource: Int,
) {
    val textView =
        (LayoutInflater.from(context)
            .inflate(backgroundResource, null) as TextView).apply {
            text = textResource
        }

    val layoutParams = ViewGroup.MarginLayoutParams(
        ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT
    ).apply {
        rightMargin = context.dpToPx(8)
        bottomMargin = context.dpToPx(8)
    }

    addView(textView, layoutParams)
}

fun FlexboxLayout.getSelectedItems(): List<String> {
    val selectedViews: List<TextView> = children.filter {
        it.isSelected && it is TextView
    }.toList() as List<TextView>
    val selectedTexts: List<String> = selectedViews.map {
        it.text.toString()
    }
    return selectedTexts
}