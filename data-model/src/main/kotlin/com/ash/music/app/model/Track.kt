package com.ash.music.app.model

import java.util.UUID

data class Track(
    val trackId: TrackId,
    val albumId: AlbumId,
    val artistId: ArtistId
)

typealias TrackId = UUID