package com.ash.music.app.model

import java.util.UUID

data class Playlist(
    val playlistId: PlaylistId
)

typealias PlaylistId = UUID