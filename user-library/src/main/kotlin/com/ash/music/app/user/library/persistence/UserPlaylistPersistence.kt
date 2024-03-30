package com.ash.music.app.user.library.persistence

import com.ash.music.app.model.*

class UserPlaylistPersistence {
    fun createPlaylist(userId: UserId, playlist: UserPlaylist): PlaylistId {
        TODO("Not yet implemented")
    }

    fun getPlaylists(userId: UserId): List<UserPlaylist> {
        TODO("Not yet implemented")
    }

    fun getPlaylist(userId: UserId, playlistId: PlaylistId): UserPlaylist {
        TODO("Not yet implemented")
    }

    fun updatePlaylist(userId: UserId, playlistId: PlaylistId, playlist: UserPlaylist) {
        TODO("Not yet implemented")
    }

    fun getPlaylistTracks(userId: UserId, playlistId: PlaylistId): List<UserTrack> {
        TODO("Not yet implemented")
    }

    fun addPlaylistTrack(userId: UserId, playlistId: PlaylistId, trackId: TrackId) {
        TODO("Not yet implemented")
    }

    fun updatePlaylistTracks(userId: UserId, playlistId: PlaylistId, tracks: List<TrackId>) {
        TODO("Not yet implemented")
    }

}
