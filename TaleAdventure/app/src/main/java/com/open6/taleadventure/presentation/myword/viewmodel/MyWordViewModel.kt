package com.open6.taleadventure.presentation.myword.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.open6.taleadventure.data.remote.api.ApiFactory.ServicePool.myWordService
import com.open6.taleadventure.data.remote.model.myword.ResponseMyWordDto
import com.open6.taleadventure.util.extensions.getErrorMessage
import kotlinx.coroutines.launch

class MyWordViewModel : ViewModel() {
    private val _getMyWordDataSuccessResponse = MutableLiveData<List<ResponseMyWordDto>?>()
    val getMyWordDataSuccessResponse: LiveData<List<ResponseMyWordDto>?> =
        _getMyWordDataSuccessResponse

    private val _getMyWordDataErrorResponse = MutableLiveData<String>()
    val getMyWordDataErrorResponse: LiveData<String> = _getMyWordDataErrorResponse

    fun getMyWordData() {
        viewModelScope.launch {
            kotlin.runCatching {
                myWordService.getMyWordData()
            }.fold(onSuccess = { successResponse ->
                _getMyWordDataSuccessResponse.value = successResponse.data
            }, onFailure = { errorResponse ->
                _getMyWordDataErrorResponse.value = errorResponse.getErrorMessage()
            })
        }
    }
}