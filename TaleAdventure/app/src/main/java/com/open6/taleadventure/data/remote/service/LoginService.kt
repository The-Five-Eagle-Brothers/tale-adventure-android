package com.open6.taleadventure.data.remote.service

import com.open6.taleadventure.util.PublicString.LOGIN_PATH
import com.open6.taleadventure.data.remote.model.login.RequestLoginDto
import com.open6.taleadventure.data.remote.model.login.ResponseLoginDto
import com.open6.taleadventure.data.remote.model.wrapper.ResponseWrapper
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST(LOGIN_PATH)
    suspend fun loginWithKakao(
        @Body request: RequestLoginDto,
    ): ResponseWrapper<ResponseLoginDto>?
}