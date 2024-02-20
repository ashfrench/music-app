package com.ash.music.app.user.library.endpoints

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
@RequestMapping("library/{userId}")
class UserLibraryEndpoints {

    @GetMapping
    fun getArtists(@PathVariable userId: UUID): Artist{
        TODO()
    }

    @GetMapping("/artist/{id}")
    fun getArtist(@PathVariable userId: UUID, @PathVariable id: UUID): Artist {
        TODO()
    }

    @GetMapping("/track")
    fun getTracks(@PathVariable userId: UUID): List<Track> {
        TODO()
    }

    @GetMapping("/track/{id}")
    fun getTrack(@PathVariable userId: UUID, @PathVariable id: UUID): Track {
        TODO()
    }

    @GetMapping("/album")
    fun getAlbums(@PathVariable userId: UUID): List<Album> {
        TODO()
    }

    @GetMapping("/album/{id}")
    fun getAlbum(@PathVariable userId: UUID, @PathVariable id: UUID): Album {
        TODO()
    }

    @GetMapping("/playlist")
    fun getPlaylists(@PathVariable userId: UUID): List<Playlist> {
        TODO()
    }

    @GetMapping("/playlist/{id}")
    fun getPlaylist(@PathVariable userId: UUID, @PathVariable id: UUID): Playlist {
        TODO()
    }
}