package com.ash.music.app.model

import java.util.UUID

typealias ArtistId = UUID
typealias TrackId = UUID
typealias PlaylistId = UUID
typealias AlbumId = UUID
typealias TrackList = List<Track>

fun newArtistId(): UUID = UUID.randomUUID()
fun newAlbumId(): UUID = UUID.randomUUID()
fun newPlaylistId(): UUID = UUID.randomUUID()
fun newTrackId(): UUID = UUID.randomUUID()