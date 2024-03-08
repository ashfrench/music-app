package com.ash.music.app.global.library.endpoints

import com.ash.music.app.model.IAlbum
import com.ash.music.app.model.IArtist
import com.ash.music.app.model.Playlist
import com.ash.music.app.model.ITrack
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("library")
class GlobalLibraryEndpoints {

    @GetMapping("/artist")
    fun getArtists(): List<IArtist> {
        TODO()
    }

    @GetMapping("/artist/{artistId}")
    fun getArtist(@PathVariable artistId: UUID): IArtist {
        TODO()
    }

    @GetMapping("/track")
    fun getTracks(): List<ITrack> {
        TODO()
    }

    @GetMapping("/track/{trackId}")
    fun getTrack(@PathVariable trackId: UUID): ITrack {
        TODO()
    }

    @GetMapping("/album")
    fun getAlbums(): List<IAlbum> {
        TODO()
    }

    @GetMapping("/album/{albumId}")
    fun getAlbum(@PathVariable albumId: UUID): IAlbum {
        TODO()
    }

    @GetMapping("/playlist")
    fun getPlaylists(): List<Playlist> {
        TODO()
    }

    @GetMapping("/playlist/{playlistId}")
    fun getPlaylist(@PathVariable playlistId: UUID): Playlist {
        TODO()
    }
}