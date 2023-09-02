package com.open6.taleadventure.data.remote.model.login

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestLoginDto(
    @SerialName("accessToken") val accessToken: String,
)

@Serializable
data class ResponseLoginDto(
    @SerialName("appToken") val appToken: String,
)