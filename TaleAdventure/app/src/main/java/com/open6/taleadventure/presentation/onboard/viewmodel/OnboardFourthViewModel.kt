package com.open6.taleadventure.presentation.onboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.open6.taleadventure.data.remote.api.ApiFactory
import com.open6.taleadventure.data.remote.model.userinfo.RequestSetNicknameDto
import com.open6.taleadventure.util.extensions.getErrorMessage
import kotlinx.coroutines.launch

class OnboardFourthViewModel : ViewModel() {
    val nickname: MutableLiveData<String> = MutableLiveData("")
    val isNickNameValid: LiveData<Boolean> = nickname.map { nickname -> nickname.length in 2..8 }

    private val _setNicknameSuccessResponse: MutableLiveData<String> = MutableLiveData<String>()
    val setNicknameSuccessResponse: LiveData<String> = _setNicknameSuccessResponse

    private val _setNicknameErrorResponse: MutableLiveData<String> = MutableLiveData<String>()
    val setNicknameErrorResponse: LiveData<String> = _setNicknameErrorResponse

    fun setNickname() {
        viewModelScope.launch {
            kotlin.runCatching {
                ApiFactory.ServicePool.setUserInfoService.setNickname(
                    RequestSetNicknameDto(
                        nickname = nickname.value ?: "익명의 여행자"
                    )
                )
            }.fold(onSuccess = { successData ->
                _setNicknameSuccessResponse.value = successData.data.nickname
            }, onFailure = { error ->
                _setNicknameErrorResponse.value = error.getErrorMessage()
            })
        }
    }
}