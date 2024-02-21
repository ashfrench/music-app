package com.ash.music.app.model

import java.util.UUID

data class Album(
    val albumID: AlbumId,
    val artistId: ArtistId,
    val trackList: TrackList
)

typealias AlbumId = UUID
typealias TrackList = List<TrackId>