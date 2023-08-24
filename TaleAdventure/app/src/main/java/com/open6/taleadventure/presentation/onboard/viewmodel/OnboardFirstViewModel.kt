package com.open6.taleadventure.presentation.onboard.viewmodel

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import timber.log.Timber

class OnboardFirstViewModel : ViewModel() {
    private var ageMap: MutableMap<TextView, Int>? = null
    fun setAgeMap(ageMap: MutableMap<TextView, Int>) {
        this.ageMap = ageMap
    }

    private val selectedTextView: MutableLiveData<TextView?> = MutableLiveData(null)
    private val selectedMaxAge: LiveData<Int?> = selectedTextView.map { textView ->
        ageMap?.get(textView)
    }
    val isSelectedTextViewExist: LiveData<Boolean> = selectedTextView.map { textView ->
        textView != null
    }

    fun setSelectedView(newTextView: TextView) {
        if (selectedTextView.value == null) {
            selectedTextView.value = newTextView
            newTextView.isSelected = true
            return
        }

        if (selectedTextView.value == newTextView) {
            selectedTextView.value = null
            newTextView.isSelected = false
            Timber.e(selectedTextView.value.toString())
            return
        }

        selectedTextView.value?.isSelected = false
        newTextView.isSelected = true
        selectedTextView.value = newTextView

        Timber.e(selectedTextView.value.toString())
    }
}