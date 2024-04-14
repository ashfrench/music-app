package com.ash.music.app.model

interface ITrack {
    val trackId: TrackId
    val trackName: String
    val artistId: ArtistId
}

interface IAlbumTrack: ITrack {
    val albumId: AlbumId
}

data class Track(
    override val trackId: TrackId = newTrackId(),
    override val trackName: String,
    override val artistId: ArtistId
): ITrack

data class AlbumTrack(
    override val trackId: TrackId = newTrackId(),
    override val trackName: String,
    val trackNumber: Int,
    override val albumId: AlbumId,
    override val artistId: ArtistId
): IAlbumTrack

data class UserTrack(
    override val trackId: TrackId = newTrackId(),
    override val trackName: String,
    override val albumId: AlbumId,
    override val artistId: ArtistId,
    val like: Boolean,
    val dislike: Boolean
): IAlbumTrack