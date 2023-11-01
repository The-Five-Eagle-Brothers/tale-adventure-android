package com.open6.taleadventure.data.remote.model.userinfo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestSetNicknameDto(
    @SerialName("nickname") val nickname: String,
)

@Serializable
data class ResponseSetNicknameDto(
    @SerialName("nickname") val nickname: String,
    @SerialName("email") val email: String,
    @SerialName("gender") val gender: String,
    @SerialName("age") val age: Int,
    @SerialName("status") val status: String
)