package com.ash.music.app.model

interface Album {
    val albumID: AlbumId
    val artistId: ArtistId
    val trackList: TrackList
}

