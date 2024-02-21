package com.ash.music.app.model

interface Artist {
    val artistId: ArtistId
    val artistName: String
}

data class SoloArtist(
    override val artistId: ArtistId = newArtistId(),
    override val artistName: String
): Artist

data class GroupArtist(
    override val artistId: ArtistId = newArtistId(),
    override val artistName: String,
    val members: List<Artist>
): Artist