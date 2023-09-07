package com.open6.taleadventure.presentation.end.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.open6.taleadventure.data.remote.api.ApiFactory.ServicePool.wordService
import com.open6.taleadventure.data.remote.model.word.ResponseGameWordsDto
import com.open6.taleadventure.util.extensions.getErrorMessage
import kotlinx.coroutines.launch
import timber.log.Timber

class EndViewModel : ViewModel() {

    var isBookmarkedList = mutableListOf<Boolean>()

    private val _gameWords = MutableLiveData<List<ResponseGameWordsDto>?>()
    val gameWords: LiveData<List<ResponseGameWordsDto>?> = _gameWords

    private val updatedGameWords: List<ResponseGameWordsDto>? get() = _gameWords.value
    private fun updateGameWords() {
        for (position in 0 until isBookmarkedList.size) {
            updatedGameWords?.get(position)?.bookMark = isBookmarkedList[position]
        }
    }

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
                _gameWords.value = successResponse.data.filter { it.bookMark }
            }, onFailure = { errorResponse ->
                _errorResponse.value = errorResponse.getErrorMessage()
            })
        }
    }

    private val _updateBookmarkSuccessResponse = MutableLiveData<Void?>()
    val updateBookmarkSuccessResponse: LiveData<Void?> = _updateBookmarkSuccessResponse

    private val _updateBookmarkErrorResponse = MutableLiveData<String>()
    val updateBookmarkErrorResponse: LiveData<String> = _updateBookmarkErrorResponse

    fun updateBookmark() {
        updateGameWords()
        Timber.e(updatedGameWords.toString())
        viewModelScope.launch {
            kotlin.runCatching {
                wordService.patchWordIsBookmarked(updatedGameWords!!)
            }.fold(onSuccess = { successResponse ->
                _updateBookmarkSuccessResponse.value = successResponse
            }, onFailure = { errorResponse ->
                _updateBookmarkErrorResponse.value = errorResponse.getErrorMessage()
            })
        }
    }
}