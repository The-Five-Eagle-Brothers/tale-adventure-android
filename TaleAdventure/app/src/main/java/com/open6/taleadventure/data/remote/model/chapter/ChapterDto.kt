package com.open6.taleadventure.data.remote.model.chapter

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseChapterDto(
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("imageUrl") val imageUrl: String,
    @SerialName("taleBook") val taleBook: TaleBook,
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