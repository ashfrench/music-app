package com.ash.music.app.global.library.endpoints

import com.ash.music.app.global.library.exceptions.ResourceNotFoundException
import com.ash.music.app.global.library.persistence.GlobalTrackPersistence
import com.ash.music.app.model.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("library/track")
class GlobalTrackEndpoints(
    private val persistence: GlobalTrackPersistence
) {

    @GetMapping
    fun getTracks(@RequestParam(required = false) pageStart: Int = 0, @RequestParam(required = false) pageAmount: Int = 100): Flux<Track> {
        return persistence.getTracks(pageStart, pageAmount)
    }

    @GetMapping("/{trackId}")
    suspend fun getTrack(@PathVariable trackId: TrackId): Track {
        return persistence.getTrack(trackId) ?: throw ResourceNotFoundException()
    }

}