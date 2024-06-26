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
    fun createPlaylist(@PathVariable userId: UserId, @RequestBody playlist: UserPlaylist): PlaylistId {
        logger.info("User: [$userId] Created Playlist [$playlist]")
        return userPlaylistPersistence.createPlaylist(userId, playlist)
    }

    @PutMapping("/{playlistId}/update")
    fun updatePlaylist(@PathVariable userId: UserId, @PathVariable playlistId: PlaylistId, @RequestBody playlist: UserPlaylist) {
        logger.info("User: [$userId] Updated Playlist [$playlistId]")
        userPlaylistPersistence.updatePlaylist(userId, playlistId, playlist)
    }

    @GetMapping("/{playlistId}/track")
    fun getPlaylistTracks(@PathVariable userId: UserId, @PathVariable playlistId: PlaylistId): List<UserTrack> {
        logger.info("User: [$userId] Requested Playlist [$playlistId]")
        return userPlaylistPersistence.getPlaylistTracks(userId, playlistId)
    }

    @PutMapping("/{playlistId}/track/{trackId}")
    fun addPlaylistTrack(@PathVariable userId: UserId, @PathVariable playlistId: PlaylistId, @PathVariable trackId: TrackId) {
        logger.info("User: [$userId] Updated Playlist [$playlistId] adding Track [$trackId]")
        userPlaylistPersistence.addPlaylistTrack(userId, playlistId, trackId)
    }

    @DeleteMapping("/{playlistId}/track/{trackId}")
    fun removePlaylistTrack(@PathVariable userId: UserId, @PathVariable playlistId: PlaylistId, @PathVariable trackId: TrackId) {
        logger.info("User: [$userId] Updated Playlist [$playlistId] removing Track [$trackId]")
        userPlaylistPersistence.addPlaylistTrack(userId, playlistId, trackId)
    }

    @PutMapping("/{playlistId}/track")
    fun updatePlaylistTracks(@PathVariable userId: UserId, @PathVariable playlistId: PlaylistId, @RequestBody tracks: List<TrackId>) {
        logger.info("User: [$userId] Updated Playlist [$playlistId] adding Tracks [$tracks]")
        userPlaylistPersistence.updatePlaylistTracks(userId, playlistId, tracks)
    }
}