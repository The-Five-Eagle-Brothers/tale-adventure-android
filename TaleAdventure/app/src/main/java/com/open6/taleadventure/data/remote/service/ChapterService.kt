package com.open6.taleadventure.data.remote.service

import com.open6.taleadventure.data.remote.model.chapter.ResponseChapterDto
import com.open6.taleadventure.data.remote.model.wrapper.ResponseWrapper
import com.open6.taleadventure.util.PublicString.GET_CHAPTERS_PATH
import retrofit2.http.GET
import retrofit2.http.Query

interface ChapterService {
    @GET(GET_CHAPTERS_PATH)
    suspend fun getChapters(@Query("name") taleName: String): ResponseWrapper<List<ResponseChapterDto>>
}