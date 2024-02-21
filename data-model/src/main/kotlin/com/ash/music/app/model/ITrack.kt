package com.ash.music.app.model

interface ITrack {
    val trackId: TrackId
    val trackName: String

    val albumId: AlbumId
    val artistId: ArtistId
}

data class Track(
    override val trackId: TrackId = newTrackId(),
    override val trackName: String,
    override val albumId: AlbumId,
    override val artistId: ArtistId
): ITrack

data class UserTrack(
    override val trackId: TrackId = newTrackId(),
    override val trackName: String,
    override val albumId: AlbumId,
    override val artistId: ArtistId,
    val liked: Boolean
): ITrack