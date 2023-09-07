package com.open6.taleadventure.data.remote.service

import com.open6.taleadventure.data.remote.model.word.ResponseGameWordsDto
import com.open6.taleadventure.data.remote.model.wrapper.ResponseWrapper
import com.open6.taleadventure.util.PublicString.GET_CHAPTER_WORD_PATH
import com.open6.taleadventure.util.PublicString.GET_MY_WORD_PATH
import com.open6.taleadventure.util.PublicString.PATCH_WORD_IS_BOOKMARKED
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Query

interface WordService {
    @GET(GET_CHAPTER_WORD_PATH)
    suspend fun getChapterWords(@Query("title") title: String): ResponseWrapper<List<ResponseGameWordsDto>>

    @GET(GET_MY_WORD_PATH)
    suspend fun getMyWords(@Query("name") name: String): ResponseWrapper<List<ResponseGameWordsDto>>

    @PATCH(PATCH_WORD_IS_BOOKMARKED)
    suspend fun patchWordIsBookmarked(@Body gameWords: List<ResponseGameWordsDto>): Void?
}