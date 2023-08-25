package com.open6.taleadventure.presentation.onboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class OnboardFourthViewModel : ViewModel() {
    val nickname: MutableLiveData<String> = MutableLiveData("")
    val isNickNameValid: LiveData<Boolean> = nickname.map { nickname -> nickname.length in 2..8 }
}