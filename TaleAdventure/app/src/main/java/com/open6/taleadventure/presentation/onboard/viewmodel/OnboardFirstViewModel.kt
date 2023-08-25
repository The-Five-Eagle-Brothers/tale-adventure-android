package com.open6.taleadventure.presentation.onboard.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class OnboardFirstViewModel : ViewModel() {
    private var ageMap: MutableMap<View, Int>? = null
    fun setAgeMap(ageMap: MutableMap<View, Int>) {
        this.ageMap = ageMap
    }

    private val selectedView: MutableLiveData<View?> = MutableLiveData(null)
    private val selectedMaxAge: LiveData<Int?> = selectedView.map { selectedView ->
        ageMap?.get(selectedView)
    }
    val isSelectedViewExist: LiveData<Boolean> = selectedView.map { selectedView ->
        selectedView != null
    }

    fun setSelectedView(newView: View) {
        /** 선택된 View 없음 */
        if (selectedView.value == null) {
            selectedView.value = newView
            newView.isSelected = true
            return
        }
        /** 선택된 View == 내가 선택한 View */
        if (selectedView.value == newView) {
            selectedView.value = null
            newView.isSelected = false
            return
        }
        /** 선택된 View != 내가 선택한 View */
        selectedView.value?.isSelected = false
        newView.isSelected = true
        selectedView.value = newView
    }

    fun resetSelectedView() {
        selectedView.value = null
    }
}