package com.ash.music.app.global.library.endpoints

import com.ash.music.app.global.library.persistence.GlobalPlaylistPersistence
import com.ash.music.app.model.Playlist
import com.ash.music.app.model.PlaylistId
import com.ash.music.app.model.TrackList
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("library/playlist")
class GlobalPlaylistEndpoints(
    private val persistence: GlobalPlaylistPersistence
) {

    @GetMapping
    fun getPlaylists(): List<Playlist> {
        TODO()
    }

    @GetMapping("/{playlistId}")
    fun getPlaylist(@PathVariable playlistId: PlaylistId): Playlist {
        TODO()
    }

    @GetMapping("/{playlistId}/track")
    fun getPlaylistTracks(@PathVariable playlistId: PlaylistId): TrackList {
        TODO()
    }
}