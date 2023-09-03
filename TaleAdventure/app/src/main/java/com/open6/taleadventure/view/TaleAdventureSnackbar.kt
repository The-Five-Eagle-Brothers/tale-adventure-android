package com.open6.taleadventure.view

import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.ViewGradeSnackbarBinding

class TaleAdventureSnackbar(
    rootView: View,
    private val isCorrect: Boolean,
    private val anchorView: View? = null,
) {
    private val context = rootView.context
    private val snackbar = Snackbar.make(rootView, "", 1750)
    private val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

    private val inflater = LayoutInflater.from(context)
    private val binding = ViewGradeSnackbarBinding.inflate(inflater, null, false)

    init {
        setView()
        setData()
    }

    private fun setView() {
        with(snackbarLayout) {
            removeAllViews()
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
            addView(binding.root, 0)
        }
    }

    private fun setData() {
        if (isCorrect) {
            setCorrectSnackbarData()
        } else {
            setIncorrectSnackbarData()
        }
    }

    private fun setCorrectSnackbarData() {
        with(binding) {
            layoutGradeSnackbarText.background =
                AppCompatResources.getDrawable(context, R.drawable.bg_green_1_radius_24)
            ivGradeSnackbarIsCorrect.setImageResource(R.drawable.img_correct)
            ivGradeSnackbarFirstImage.setImageResource(R.drawable.img_two_stars)
            ivGradeSnackbarFirstImage.visibility = View.VISIBLE
            tvGradeSnackbarTitle.text = context.getString(R.string.grade_correct)
            ivGradeSnackbarLastImage.setImageResource(R.drawable.img_smiling_cat)
        }
    }

    private fun setIncorrectSnackbarData() {
        with(binding) {
            layoutGradeSnackbarText.background =
                AppCompatResources.getDrawable(context, R.drawable.bg_red_1_radius_24)
            ivGradeSnackbarIsCorrect.setImageResource(R.drawable.img_incorrect)
            ivGradeSnackbarFirstImage.visibility = View.GONE
            tvGradeSnackbarTitle.text = context.getString(R.string.grade_incorrect)
            ivGradeSnackbarLastImage.setImageResource(R.drawable.img_smiling_cat)
        }
    }

    fun show() {
        if (anchorView == null) {
            snackbar.show()
            return
        }
        snackbar.anchorView = anchorView
        snackbar.show()
    }
}