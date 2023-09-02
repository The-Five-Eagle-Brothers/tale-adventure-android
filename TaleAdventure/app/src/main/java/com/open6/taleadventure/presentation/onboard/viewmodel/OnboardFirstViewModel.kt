package com.open6.taleadventure.presentation.onboard.viewmodel

import android.view.View
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.open6.taleadventure.data.remote.api.ApiFactory.ServicePool.setUserInfoService
import com.open6.taleadventure.data.remote.model.userinfo.RequestSetAgeDto
import com.open6.taleadventure.data.remote.model.userinfo.ResponseSetAgeDto
import com.open6.taleadventure.util.extensions.getErrorMessage
import kotlinx.coroutines.launch
import timber.log.Timber

class OnboardFirstViewModel : ViewModel() {
    private lateinit var ageMap: MutableMap<String, Int>
    fun setAgeMap(ageMap: MutableMap<String, Int>) {
        this.ageMap = ageMap
        Timber.e(ageMap.toString())
        Timber.e(this.ageMap.toString())
    }

    private val selectedView: MutableLiveData<View?> = MutableLiveData(null)
    private val selectedAge: MutableLiveData<Int?> = MutableLiveData(null)

    //    private val selectedAge: LiveData<Int?> = selectedView.map { selectedView ->
//        Timber.e((selectedView as TextView).text.toString())
//        if (selectedView is TextView) ageMap[selectedView.text.toString()]
//        else null
//    }
    val isSelectedViewExist: LiveData<Boolean> = selectedView.map { selectedView ->
        Timber.e((selectedView is TextView).toString())
        selectedView != null
    }

    fun setSelectedView(newView: View) {
        if (newView !is TextView) return
        /** 선택된 View 없음 */
        if (selectedView.value == null) {
            selectedView.value = newView
            selectedAge.value = ageMap[newView.text]
            newView.isSelected = true
            return
        }
        /** 선택된 View == 내가 선택한 View */
        if (selectedView.value == newView) {
            selectedView.value = null
            selectedAge.value = null
            newView.isSelected = false
            return
        }
        /** 선택된 View != 내가 선택한 View */
        selectedView.value?.isSelected = false
        newView.isSelected = true
        selectedView.value = newView
        selectedAge.value = ageMap[newView.text]
    }

    fun resetSelectedView() {
        selectedView.value = null
    }

    private val _setAgeSuccessResponse: MutableLiveData<ResponseSetAgeDto?> =
        MutableLiveData<ResponseSetAgeDto?>()
    val setAgeSuccessResponse: LiveData<ResponseSetAgeDto?> = _setAgeSuccessResponse

    private val _setAgeErrorResponse: MutableLiveData<String> = MutableLiveData<String>()
    val setAgeErrorResponse: LiveData<String> = _setAgeErrorResponse

    fun setAge() {
        viewModelScope.launch {
            kotlin.runCatching {
                setUserInfoService.setAge(
                    request = RequestSetAgeDto(
                        age = selectedAge.value ?: throw NullPointerException()
                    )
                )
            }.fold(onSuccess = { successResponse ->
                _setAgeSuccessResponse.value = successResponse.data
            }, onFailure = { error ->
                _setAgeErrorResponse.value = error.getErrorMessage()
            })
        }
    }
}