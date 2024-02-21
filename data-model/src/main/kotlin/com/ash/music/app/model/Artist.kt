package com.ash.music.app.model

import java.util.UUID

data class Artist(
    open val artistID: ArtistId,
    open val artistName: String
)

typealias ArtistId = UUID