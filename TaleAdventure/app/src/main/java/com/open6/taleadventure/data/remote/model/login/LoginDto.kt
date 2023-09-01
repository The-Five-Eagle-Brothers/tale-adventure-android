package com.open6.taleadventure.data.remote.model.login

import com.open6.taleadventure.data.remote.model.wrapper.ResponseWrapper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestLoginDto(
    @SerialName("accessToken") val accessToken: String,
)

@Serializable
data class ResponseLoginDto(
    @SerialName("data") val data: ResponseWrapper<AppToken>,
) {
    @Serializable
    data class AppToken(
        @SerialName("appToken") val appToken: String,
    )
}