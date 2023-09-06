package com.open6.taleadventure.data.remote.model.myword

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMyWordDto(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("category") val category: String,
    @SerialName("libraryImageUrl") val libraryImageUrl: String,
    @SerialName("chapterImageUrl") val chapterImageUrl: String,
    @SerialName("wordBookImageUrl") val wordBookImageUrl: String,
)