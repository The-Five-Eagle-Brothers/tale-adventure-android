package com.open6.taleadventure.presentation.tale.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.open6.taleadventure.data.remote.api.ApiFactory.ServicePool.chapterService
import com.open6.taleadventure.data.remote.model.chapter.ResponseChapterDto
import com.open6.taleadventure.util.extensions.getErrorMessage
import kotlinx.coroutines.launch

class TaleViewModel : ViewModel() {

    private val _getChaptersSuccessResponse = MutableLiveData<List<ResponseChapterDto>?>()
    val getChaptersSuccessResponse: LiveData<List<ResponseChapterDto>?> =
        _getChaptersSuccessResponse

    private val _getChaptersErrorResponse = MutableLiveData<String>()
    val getChaptersErrorResponse: LiveData<String> = _getChaptersErrorResponse

    fun getChapters() {
        viewModelScope.launch {
            kotlin.runCatching { chapterService.getChapters() }
                .fold(onSuccess = { successResponse ->
                    _getChaptersSuccessResponse.value = successResponse.data
                }, onFailure = { errorResponse ->
                    _getChaptersErrorResponse.value = errorResponse.getErrorMessage()
                })
        }
    }
}