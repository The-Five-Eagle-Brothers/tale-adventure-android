package com.open6.taleadventure.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.open6.taleadventure.data.remote.api.ApiFactory.ServicePool.homeService
import com.open6.taleadventure.data.remote.model.home.ResponseHomeDto
import com.open6.taleadventure.util.extensions.getErrorMessage
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _getHomeDataSuccessResponse = MutableLiveData<ResponseHomeDto?>()
    val getHomeDataSuccessResponse: LiveData<ResponseHomeDto?> = _getHomeDataSuccessResponse

    private val _getHomeDataErrorResponse = MutableLiveData<String>()
    val getHomeDataErrorResponse: LiveData<String> = _getHomeDataErrorResponse

    fun getHomeData() {
        viewModelScope.launch {
            kotlin.runCatching {
                homeService.getHomeData()
            }.fold(onSuccess = { successResponse ->
                _getHomeDataSuccessResponse.value = successResponse.data
            }, onFailure = { errorResponse ->
                _getHomeDataErrorResponse.value = errorResponse.getErrorMessage()
            })
        }
    }
}