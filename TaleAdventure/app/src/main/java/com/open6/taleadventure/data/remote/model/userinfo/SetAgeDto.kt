package com.open6.taleadventure.data.remote.model.userinfo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestSetAgeDto(
    @SerialName("age") val age: Int,
)

@Serializable
data class ResponseSetAgeDto(
    @SerialName("nickName")
    val nickName: String?,
    @SerialName("email")
    val email: String?,
    @SerialName("gender")
    val gender: String?,
    @SerialName("age")
    val age: Int?,
    @SerialName("status")
    val status: String?,
)