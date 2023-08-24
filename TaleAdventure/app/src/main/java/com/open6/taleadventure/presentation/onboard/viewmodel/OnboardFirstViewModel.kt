package com.open6.taleadventure.presentation.onboard.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import timber.log.Timber

class OnboardFirstViewModel : ViewModel() {
    private var ageMap: MutableMap<View, Int>? = null
    fun setAgeMap(ageMap: MutableMap<View, Int>) {
        this.ageMap = ageMap
    }

    private val selectedTextView: MutableLiveData<View?> = MutableLiveData(null)
    private val selectedMaxAge: LiveData<Int?> = selectedTextView.map { textView ->
        ageMap?.get(textView)
    }
    val isSelectedTextViewExist: LiveData<Boolean> = selectedTextView.map { textView ->
        textView != null
    }

    fun setSelectedView(newView: View) {
        if (selectedTextView.value == null) {
            selectedTextView.value = newView
            newView.isSelected = true
            return
        }

        if (selectedTextView.value == newView) {
            selectedTextView.value = null
            newView.isSelected = false
            Timber.e(selectedTextView.value.toString())
            return
        }

        selectedTextView.value?.isSelected = false
        newView.isSelected = true
        selectedTextView.value = newView

        Timber.e(selectedTextView.value.toString())
    }
}