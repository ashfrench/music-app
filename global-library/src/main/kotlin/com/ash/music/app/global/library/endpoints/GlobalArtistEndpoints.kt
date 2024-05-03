package com.ash.music.app.global.library.endpoints

import com.ash.music.app.global.library.exceptions.ResourceNotFoundException
import com.ash.music.app.global.library.persistence.GlobalArtistPersistence
import com.ash.music.app.model.ArtistId
import com.ash.music.app.model.IArtist
import com.ash.music.app.model.ITrack
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration

@RestController
@RequestMapping("library/artist")
class GlobalArtistEndpoints(
    private val persistence: GlobalArtistPersistence
) {

    @GetMapping
    fun getArtists(): Flux<IArtist> {
        return persistence.getArtists()
    }

    @GetMapping("/{artistId}")
    fun getArtist(@PathVariable artistId: ArtistId): IArtist {
        return persistence.getArtist(artistId).block(Duration.ofSeconds(1)) ?: throw ResourceNotFoundException()
    }

    @GetMapping("/{artistId}/track")
    fun getArtistTracks(@PathVariable artistId: ArtistId): Flux<ITrack> {
        return persistence.getArtistTracks(artistId)
    }

}