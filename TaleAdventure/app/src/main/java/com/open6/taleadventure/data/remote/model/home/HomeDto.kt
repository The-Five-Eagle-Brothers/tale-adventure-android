package com.open6.taleadventure.data.remote.model.home

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseHomeDto(
    @SerialName("day") val day: Int,
    @SerialName("nickname") val nickname: String,
    @SerialName("taleBooks") val taleBooks: List<TaleBook>,
) {
    @Serializable
    data class TaleBook(
        @SerialName("id") val id: Int,
        @SerialName("name") val name: String,
        @SerialName("category") val category: String,
        @SerialName("libraryImageUrl") val libraryImageUrl: String,
        @SerialName("chapterImageUrl") val chapterImageUrl: String,
        @SerialName("wordBookImageUrl") val wordBookImageUrl: String,
    )
}