package com.ash.music.app.model

import java.util.UUID

data class Playlist(
    val playlistId: PlaylistId,
    val playlistName: String,
    val tracks: TrackList
)

typealias PlaylistId = UUID