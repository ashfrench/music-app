package com.ash.music.app.global.library.endpoints

import com.ash.music.app.model.Album
import com.ash.music.app.model.Artist
import com.ash.music.app.model.Playlist
import com.ash.music.app.model.Track
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("library")
class GlobalLibraryEndpoints {

    @GetMapping("/artist")
    fun getArtists(): List<Artist> {
        TODO()
    }

    @GetMapping("/artist/{id}")
    fun getArtist(@PathVariable id: UUID): Artist {
        TODO()
    }

    @GetMapping("/track")
    fun getTracks(): List<Track> {
        TODO()
    }

    @GetMapping("/track/{id}")
    fun getTrack(@PathVariable id: UUID): Track {
        TODO()
    }

    @GetMapping("/album")
    fun getAlbums(): List<Album> {
        TODO()
    }

    @GetMapping("/album/{id}")
    fun getAlbum(@PathVariable id: UUID): Album {
        TODO()
    }

    @GetMapping("/playlist")
    fun getPlaylists(): List<Playlist> {
        TODO()
    }

    @GetMapping("/playlist/{id}")
    fun getPlaylist(@PathVariable id: UUID): Playlist {
        TODO()
    }
}