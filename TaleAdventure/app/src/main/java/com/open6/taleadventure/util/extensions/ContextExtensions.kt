package com.open6.taleadventure.util.extensions

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun Context.makeToastMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.makeSnackbarMessage(rootView: View, message: String) {
    Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show()
}

fun Context.dpToPx(dp: Int): Int {
    val scale = resources.displayMetrics.density
    return (dp * scale).toInt()
}