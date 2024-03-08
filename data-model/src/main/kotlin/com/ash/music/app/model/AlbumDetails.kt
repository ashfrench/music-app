package com.ash.music.app.model

sealed interface IAlbumDetails

data object NoDetails: IAlbumDetails
data class AlbumDetails(
    val details: String
): IAlbumDetails
