package com.open6.taleadventure.presentation.wordgame.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.open6.taleadventure.data.remote.api.ApiFactory.ServicePool.wordService
import com.open6.taleadventure.data.remote.model.word.ResponseGameWordsDto
import com.open6.taleadventure.util.extensions.getErrorMessage
import kotlinx.coroutines.launch

class WordGameViewModel : ViewModel() {

    private val _gameWords = MutableLiveData<List<ResponseGameWordsDto>?>()
    val gameWords: LiveData<List<ResponseGameWordsDto>?> = _gameWords

    val maxGameOrder = _gameWords.value?.size ?: 0
    var currentGameOrder = 1
    var answer = ""

    private val _errorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String> = _errorResponse

    fun getChapterWords(chapterName: String) {
        viewModelScope.launch {
            kotlin.runCatching { wordService.getChapterWords(chapterName) }
                .fold(onSuccess = { successResponse ->
                    _gameWords.value = successResponse.data
                }, onFailure = { errorResponse ->
                    _errorResponse.value = errorResponse.getErrorMessage()
                })
        }
    }

    fun getMyWords(taleName: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                wordService.getMyWords(taleName)
            }.fold(onSuccess = { successResponse ->
                _gameWords.value = successResponse.data
            }, onFailure = { errorResponse ->
                _errorResponse.value = errorResponse.getErrorMessage()
            })
        }
    }
}