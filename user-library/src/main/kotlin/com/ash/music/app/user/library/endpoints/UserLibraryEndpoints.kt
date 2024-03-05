package com.ash.music.app.user.library.endpoints

import com.ash.music.app.model.*
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("user/{userId}")
class UserLibraryEndpoints {

    private val logger = LoggerFactory.getLogger(UserLibraryEndpoints::class.java)

    @GetMapping
    fun getArtists(@PathVariable userId: UUID): Artist {
        TODO()
    }

    @GetMapping("/artist/{artistId}")
    fun getArtist(@PathVariable userId: UUID, @PathVariable artistId: UUID): Artist {
        TODO()
    }

    @GetMapping("/track")
    fun getTracks(@PathVariable userId: UUID): List<ITrack> {
        TODO()
    }

    @GetMapping("/track/{trackId}")
    fun getTrack(@PathVariable userId: UUID, @PathVariable trackId: UUID): UserTrack {
        TODO()
    }

    @GetMapping("/album")
    fun getAlbums(@PathVariable userId: UUID): List<UserAlbum> {
        TODO()
    }

    @GetMapping("/album/{albumId}")
    fun getAlbum(@PathVariable userId: UUID, @PathVariable albumId: UUID): UserAlbum {
        TODO()
    }

    @GetMapping("/playlist")
    fun getPlaylists(@PathVariable userId: UUID): List<Playlist> {
        TODO()
    }

    @GetMapping("/playlist/{playlistId}")
    fun getPlaylist(@PathVariable userId: UUID, @PathVariable playlistId: UUID): Playlist {
        TODO()
    }
}