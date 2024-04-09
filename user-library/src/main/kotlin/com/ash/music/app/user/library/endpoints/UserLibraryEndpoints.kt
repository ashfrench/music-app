package com.ash.music.app.user.library.endpoints

import com.ash.music.app.model.*
import com.ash.music.app.model.user.User
import com.ash.music.app.user.library.persistence.*
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("user/{userId}")
class UserLibraryEndpoints(
    private val userAlbumPersistence: UserAlbumPersistence,
    private val userTrackPersistence: UserTrackPersistence,
    private val userArtistPersistence: UserArtistPersistence,
    private val userPlaylistPersistence: UserPlaylistPersistence,
    private val userAccountPersistence: UserAccountPersistence
) {

    private val logger = LoggerFactory.getLogger(UserLibraryEndpoints::class.java)

    @GetMapping
    fun getUserAccount(@PathVariable userId: UserId): Mono<User> {
        return userAccountPersistence.getUser(userId)
    }

    @GetMapping("/artist/{artistId}")
    fun getArtist(@PathVariable userId: UserId, @PathVariable artistId: ArtistId): IArtist {
        return userArtistPersistence.getArtist(userId, artistId)
    }

    @GetMapping("/track")
    fun getTracks(@PathVariable userId: UserId): List<UserTrack> {
        return userTrackPersistence.getTracks(userId)
    }

    @GetMapping("/track/{trackId}")
    fun getTrack(@PathVariable userId: UserId, @PathVariable trackId: TrackId): UserTrack {
        return userTrackPersistence.getTrack(userId, trackId)
    }

    @GetMapping("/album")
    fun getAlbums(@PathVariable userId: UserId): List<UserAlbum> {
        return userAlbumPersistence.getAlbums(userId)
    }

    @GetMapping("/album/{albumId}")
    fun getAlbum(@PathVariable userId: UserId, @PathVariable albumId: AlbumId): UserAlbum {
        return userAlbumPersistence.getAlbum(userId, albumId)
    }

    @GetMapping("/playlist")
    fun getPlaylists(@PathVariable userId: UserId): List<UserPlaylist> {
        return userPlaylistPersistence.getPlaylists(userId)
    }

    @GetMapping("/playlist/{playlistId}")
    fun getPlaylist(@PathVariable userId: UserId, @PathVariable playlistId: PlaylistId): UserPlaylist {
        return userPlaylistPersistence.getPlaylist(userId, playlistId)
    }
}