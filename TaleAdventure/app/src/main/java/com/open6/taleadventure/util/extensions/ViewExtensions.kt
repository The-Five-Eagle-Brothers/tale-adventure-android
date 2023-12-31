package com.open6.taleadventure.util.extensions

import android.view.View
import com.open6.taleadventure.view.GradeSnackbar

fun View.makeGradeSnackbar(
    isCorrect: Boolean,
    anchorView: View? = null,
    onDismiss: (() -> Unit)? = null,
) {
    GradeSnackbar(this, isCorrect, anchorView = anchorView, onDismiss = onDismiss).show()
}