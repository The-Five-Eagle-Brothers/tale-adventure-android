package com.open6.taleadventure.data.remote.service

import com.open6.taleadventure.data.remote.model.chapter.ResponseChapterDto
import com.open6.taleadventure.data.remote.model.wrapper.ResponseWrapper
import com.open6.taleadventure.util.PublicString.GET_CHAPTERS_PATH
import retrofit2.http.GET

interface ChapterService {
    @GET(GET_CHAPTERS_PATH)
    suspend fun getChapters(): ResponseWrapper<List<ResponseChapterDto>>
}