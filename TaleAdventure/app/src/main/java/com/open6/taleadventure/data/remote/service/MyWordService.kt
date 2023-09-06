package com.open6.taleadventure.data.remote.service

import com.open6.taleadventure.data.remote.model.myword.ResponseMyWordDto
import com.open6.taleadventure.data.remote.model.wrapper.ResponseWrapper
import com.open6.taleadventure.util.PublicString.GET_MY_WORD_DATA_PATH
import retrofit2.http.GET

interface MyWordService {
    @GET(GET_MY_WORD_DATA_PATH)
    suspend fun getMyWordData(): ResponseWrapper<List<ResponseMyWordDto>>
}