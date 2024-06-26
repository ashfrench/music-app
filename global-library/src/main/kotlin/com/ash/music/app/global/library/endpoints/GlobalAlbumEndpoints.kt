package com.ash.music.app.global.library.endpoints

import com.ash.music.app.global.library.exceptions.ResourceNotFoundException
import com.ash.music.app.global.library.persistence.GlobalAlbumPersistence
import com.ash.music.app.model.Album
import com.ash.music.app.model.AlbumId
import com.ash.music.app.model.AlbumTrack
import com.ash.music.app.model.IAlbum
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration

@RestController
@RequestMapping("library/album")
class GlobalAlbumEndpoints(
    private val persistence: GlobalAlbumPersistence
) {
    @GetMapping
    fun getAlbums(): Flux<Album> {
        return persistence.getAlbums()
    }

    @GetMapping("/{albumId}")
    fun getAlbum(@PathVariable albumId: AlbumId): IAlbum {
        return persistence.getAlbum(albumId).block(Duration.ofSeconds(1)) ?: throw ResourceNotFoundException()
    }

    @GetMapping("/{albumId}/track")
    fun getAlbumTracks(@PathVariable albumId: AlbumId): List<AlbumTrack> {
        return persistence.getAlbumTracks(albumId)
            .blockOptional(Duration.ofSeconds(1)).map { it.ifEmpty { null } }
            .orElseThrow { ResourceNotFoundException() }!!
    }

}