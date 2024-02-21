package com.ash.music.app.model

interface Playlist {
    val playlistId: PlaylistId
    val playlistName: String
    val tracks: TrackList
}

