package com.open6.taleadventure.data.remote.service

import com.open6.taleadventure.data.remote.model.login.RequestLoginDto
import com.open6.taleadventure.data.remote.model.login.ResponseLoginDto
import com.open6.taleadventure.data.remote.model.wrapper.ResponseWrapper
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface LoginService {
    @POST("PATH_LOGIN")
    suspend fun login(
        @Path("PATH_SOCIAL") social: String,
        @Body request: RequestLoginDto,
    ): ResponseWrapper<ResponseLoginDto>
}