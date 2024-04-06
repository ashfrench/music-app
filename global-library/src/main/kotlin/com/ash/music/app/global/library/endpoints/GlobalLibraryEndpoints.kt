package com.ash.music.app.global.library.endpoints

import com.ash.music.app.global.library.persistence.GlobalLibraryPersistence
import com.ash.music.app.model.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("library")
class GlobalLibraryEndpoints(
    private val persistence: GlobalLibraryPersistence
) {

    @GetMapping("/artist")
    fun getArtists(): List<IArtist> {
        TODO()
    }

    @GetMapping("/artist/{artistId}")
    fun getArtist(@PathVariable artistId: ArtistId): IArtist {
        TODO()
    }

    @GetMapping("/track")
    fun getTracks(): List<ITrack> {
        TODO()
    }

    @GetMapping("/track/{trackId}")
    fun getTrack(@PathVariable trackId: TrackId): ITrack {
        TODO()
    }

    @GetMapping("/album")
    fun getAlbums(): List<IAlbum> {
        TODO()
    }

    @GetMapping("/album/{albumId}")
    fun getAlbum(@PathVariable albumId: AlbumId): IAlbum {
        TODO()
    }

    @GetMapping("/playlist")
    fun getPlaylists(): List<Playlist> {
        TODO()
    }

    @GetMapping("/playlist/{playlistId}")
    fun getPlaylist(@PathVariable playlistId: PlaylistId): Playlist {
        TODO()
    }

    @GetMapping("/playlist/{playlistId}/track")
    fun getPlaylistTracks(@PathVariable playlistId: PlaylistId): TrackList {
        TODO()
    }
}