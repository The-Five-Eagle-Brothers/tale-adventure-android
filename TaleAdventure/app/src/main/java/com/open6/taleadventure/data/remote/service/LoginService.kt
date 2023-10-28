package com.open6.taleadventure.data.remote.service

import com.open6.taleadventure.data.remote.model.login.RequestLoginDto
import com.open6.taleadventure.data.remote.model.login.ResponseLoginDto
import com.open6.taleadventure.data.remote.model.wrapper.ResponseWrapper
import com.open6.taleadventure.util.PublicString.CHECK_USER_INFO_VALID_PATH
import com.open6.taleadventure.util.PublicString.LOGIN_PATH
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginService {
    @POST(LOGIN_PATH)
    suspend fun loginWithKakao(
        @Body request: RequestLoginDto,
    ): ResponseWrapper<ResponseLoginDto>?

    @GET(CHECK_USER_INFO_VALID_PATH)
    suspend fun checkUserInfoValid(): ResponseCheckUserInfoValidDto
}

@Serializable
data class ResponseCheckUserInfoValidDto(
    @SerialName("statusCode") val statusCode: String,
    @SerialName("message") val message: String,
    @SerialName("data") val data: Int?,
)