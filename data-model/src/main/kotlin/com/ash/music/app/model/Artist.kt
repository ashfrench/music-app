package com.ash.music.app.model

import java.util.UUID

sealed class Artist(
    open val artistID: ArtistId,
    open val artistName: String
)

data class SoloArtist(
    override val artistID: ArtistId,
    override val artistName: String
) : Artist(artistID, artistName)

data class GroupArtist(
    override val artistID: ArtistId,
    override val artistName: String,
    val artists: List<Artist>
) : Artist(artistID, artistName)

typealias ArtistId = UUID