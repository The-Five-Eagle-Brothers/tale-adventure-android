package com.open6.taleadventure.presentation.onboard.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class OnboardSecondViewModel : ViewModel() {

    private val selectedViews: MutableList<View> = mutableListOf()
    private val selectedViewsCount: MutableLiveData<Int> = MutableLiveData(0)
    val isSelectedViewExist: LiveData<Boolean> = selectedViewsCount.map { selectedViewsCount ->
        selectedViewsCount > 0
    }

    fun setSelectedView(newView: View) {
        /** 선택된 Views가 내가 선택한 View 포함 -> 제거 */
        if (selectedViews.contains(newView)) {
            selectedViews.remove(newView)
            selectedViewsCount.value = selectedViewsCount.value?.minus(1)
            newView.isSelected = false
            return
        }

        /** 선택된 Views가 내가 선택한 View 미포함 -> 추가 */
        selectedViews.add(newView)
        selectedViewsCount.value = selectedViewsCount.value?.plus(1)
        newView.isSelected = true
    }

    fun resetSelectedViews() {
        selectedViews.clear()
        selectedViewsCount.value = 0
    }
}