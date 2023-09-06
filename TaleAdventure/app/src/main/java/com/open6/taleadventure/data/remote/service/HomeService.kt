package com.open6.taleadventure.data.remote.service

import com.open6.taleadventure.data.remote.model.home.ResponseHomeDto
import com.open6.taleadventure.data.remote.model.wrapper.ResponseWrapper
import com.open6.taleadventure.util.PublicString.GET_HOME_DATA_PATH
import retrofit2.http.GET

interface HomeService {
    @GET(GET_HOME_DATA_PATH)
    suspend fun getHomeData(): ResponseWrapper<ResponseHomeDto>
}