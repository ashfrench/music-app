package com.ash.music.app.model

import java.util.UUID

typealias ArtistId = UUID
typealias TrackId = UUID
typealias PlaylistId = UUID
typealias UserId = UUID
typealias AlbumId = UUID
typealias TrackList = List<ITrack>

fun newArtistId(): ArtistId = UUID.randomUUID()
fun newAlbumId(): AlbumId = UUID.randomUUID()
fun newPlaylistId(): PlaylistId = UUID.randomUUID()
fun newTrackId(): TrackId = UUID.randomUUID()