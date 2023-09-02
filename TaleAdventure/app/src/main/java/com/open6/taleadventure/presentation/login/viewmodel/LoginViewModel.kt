package com.open6.taleadventure.presentation.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.open6.taleadventure.data.remote.api.ApiFactory.ServicePool.loginService
import com.open6.taleadventure.data.remote.model.login.RequestLoginDto
import com.open6.taleadventure.data.remote.model.login.ResponseLoginDto
import com.open6.taleadventure.util.extensions.getErrorMessage
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginWithKakaoSuccessResponse: MutableLiveData<ResponseLoginDto?> =
        MutableLiveData<ResponseLoginDto?>()
    val loginWithKakaoSuccessResponse: LiveData<ResponseLoginDto?> = _loginWithKakaoSuccessResponse

    private val _loginWithKakaoErrorResponse: MutableLiveData<String> = MutableLiveData<String>()
    val loginWithKakaoErrorResponse: LiveData<String> = _loginWithKakaoErrorResponse

    fun loginWithKakao(accessToken: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                loginService.loginWithKakao(RequestLoginDto(accessToken))
            }.fold(onSuccess = { successResponse ->
                _loginWithKakaoSuccessResponse.value = successResponse?.data
            }, onFailure = { error ->
                _loginWithKakaoErrorResponse.value = error.getErrorMessage()
            })
        }
    }

}