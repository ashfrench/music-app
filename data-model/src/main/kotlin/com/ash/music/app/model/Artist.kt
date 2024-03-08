package com.ash.music.app.model

sealed interface Artist {
    val artistId: ArtistId
    val artistName: String
    val bio: ArtistBio?
}

abstract class EmptyArtist: Artist {
    override val bio = null
}

data class SoloArtist(
    override val artistId: ArtistId = newArtistId(),
    override val artistName: String
): EmptyArtist()

data class GroupArtist(
    override val artistId: ArtistId = newArtistId(),
    override val artistName: String,
    val members: List<Artist>
): EmptyArtist()