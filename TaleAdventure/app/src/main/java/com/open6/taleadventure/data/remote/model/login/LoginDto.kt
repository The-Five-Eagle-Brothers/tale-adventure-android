package com.open6.taleadventure.data.remote.model.login

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestLoginDto(
    @SerialName("token") val token: String,
)

@Serializable
data class ResponseLoginDto(
    @SerialName("data") val data: String,
)