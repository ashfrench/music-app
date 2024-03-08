package com.ash.music.app.model

sealed interface ArtistBio

data object EmptyBio: ArtistBio

data class ArtistBioDetails(
    val details: String
): ArtistBio