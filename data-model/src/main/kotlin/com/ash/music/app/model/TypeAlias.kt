package com.ash.music.app.model

import java.util.UUID

typealias ArtistId = UUID
typealias TrackId = UUID
typealias PlaylistId = UUID
typealias UserId = UUID
typealias AlbumId = UUID
typealias TrackList = List<ITrack>

fun newArtistId(): UUID = UUID.randomUUID()
fun newAlbumId(): UUID = UUID.randomUUID()
fun newPlaylistId(): UUID = UUID.randomUUID()
fun newTrackId(): UUID = UUID.randomUUID()