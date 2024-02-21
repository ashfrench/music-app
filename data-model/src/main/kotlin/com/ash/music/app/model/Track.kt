package com.ash.music.app.model

interface Track {
    val trackId: TrackId
    val trackName: String

    val albumId: AlbumId
    val artistId: ArtistId
}

