package com.ash.music.app.model

interface Playlist {
    val playlistId: PlaylistId
    val playlistName: String
    val tracks: TrackList
}

data class GlobalPlaylist(
    override val playlistId: PlaylistId = newPlaylistId(),
    override val playlistName: String,
    override val tracks: TrackList
): Playlist

data class UserPlaylist(
    override val playlistId: PlaylistId = newPlaylistId(),
    override val playlistName: String,
    override val tracks: TrackList,
    val userId: UserId
): Playlist