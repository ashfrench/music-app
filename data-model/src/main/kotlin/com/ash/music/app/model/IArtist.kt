package com.ash.music.app.model

sealed interface IArtist {
    val artistId: ArtistId
    val artistName: String
    val bio: ArtistBio
}

data class SoloArtist(
    override val artistId: ArtistId = newArtistId(),
    override val artistName: String
): IArtist {
    override val bio = EmptyBio
}

data class GroupArtist(
    override val artistId: ArtistId = newArtistId(),
    override val artistName: String,
    val members: List<IArtist>
): IArtist {
    override val bio = EmptyBio
}