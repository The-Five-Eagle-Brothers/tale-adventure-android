package com.open6.taleadventure.data.remote.model.wrapper

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseWrapper<T>(
    @SerialName("statusCode") val status: String,
    @SerialName("message") val message: String,
    @SerialName("data") val data: T,
)
