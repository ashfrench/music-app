package com.ash.music.app.user.library.endpoints

import com.ash.music.app.model.*
import com.ash.music.app.user.library.persistence.UserPlaylistPersistence
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user/{userId}/playlist")
class UserPlaylistEndpoints(
    private val userPlaylistPersistence: UserPlaylistPersistence
) {

    private val logger = LoggerFactory.getLogger(UserPlaylistEndpoints::class.java)

    @PostMapping("/create")
    fun createPlaylist(@PathVariable userId: UserId, @RequestBody playlist: UserPlaylist) {
        logger.info("User: [$userId] Created Playlist [$playlist]")
        userPlaylistPersistence.createPlaylist(userId, playlist)
    }

    @PutMapping("/{playlistId}/update")
    fun updatePlaylist(@PathVariable userId: UserId, @PathVariable playlistId: PlaylistId, @RequestBody playlist: UserPlaylist) {
        TODO()
    }

    @GetMapping("/{playlistId}/track")
    fun getPlaylistTracks(@PathVariable userId: UserId, @PathVariable playlistId: PlaylistId): List<UserTrack> {
        TODO()
    }

    @PutMapping("/{playlistId}/track/{trackId}")
    fun addPlaylistTrack(@PathVariable userId: UserId, @PathVariable playlistId: PlaylistId, @PathVariable trackId: TrackId) {
        TODO()
    }

    @DeleteMapping("/{playlistId}/track/{trackId}")
    fun removePlaylistTrack(@PathVariable userId: UserId, @PathVariable playlistId: PlaylistId, @PathVariable trackId: TrackId) {
        TODO()
    }

    @PutMapping("/{playlistId}/track")
    fun updatePlaylistTracks(@PathVariable userId: UserId, @PathVariable playlistId: PlaylistId, @RequestBody tracks: List<UserTrack>) {
        TODO()
    }
}