package com.ash.music.app.model

interface IAlbum {
    val albumID: AlbumId
    val artistId: ArtistId
    val trackList: TrackList
}