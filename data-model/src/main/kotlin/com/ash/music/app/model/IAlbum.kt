package com.ash.music.app.model

interface IAlbum {
    val albumID: AlbumId
    val albumName: String
    val artistId: ArtistId
    val trackList: TrackList
    val albumDetails: IAlbumDetails
}

data class Album(
    override val albumID: AlbumId,
    override val albumName: String,
    override val artistId: ArtistId,
    override val trackList: TrackList
): IAlbum {
    override val albumDetails = NoDetails
}

data class UserAlbum(
    override val albumID: AlbumId,
    override val albumName: String,
    override val artistId: ArtistId,
    override val trackList: TrackList,
    val like: Boolean,
    val dislike: Boolean
): IAlbum {
    override val albumDetails = NoDetails
}