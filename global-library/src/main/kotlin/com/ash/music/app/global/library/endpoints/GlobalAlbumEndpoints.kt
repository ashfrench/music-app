package com.ash.music.app.global.library.endpoints

import com.ash.music.app.global.library.persistence.GlobalAlbumPersistence
import com.ash.music.app.model.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("library/album")
class GlobalAlbumEndpoints(
    private val persistence: GlobalAlbumPersistence
) {
    @GetMapping
    fun getAlbums(): List<IAlbum> {
        return persistence.getAlbums()
    }

    @GetMapping("/{albumId}")
    fun getAlbum(@PathVariable albumId: AlbumId): IAlbum {
        return persistence.getAlbum(albumId)
    }

    @GetMapping("/{albumId}/track")
    fun getAlbumTracks(@PathVariable albumId: AlbumId): TrackList {
        return persistence.getAlbumTracks(albumId)
    }

}