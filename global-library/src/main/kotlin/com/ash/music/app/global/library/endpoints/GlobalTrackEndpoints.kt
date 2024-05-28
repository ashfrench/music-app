package com.ash.music.app.global.library.endpoints

import com.ash.music.app.global.library.exceptions.ResourceNotFoundException
import com.ash.music.app.global.library.persistence.GlobalTrackPersistence
import com.ash.music.app.model.Track
import com.ash.music.app.model.TrackId
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import java.time.Duration

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
    fun getTrack(@PathVariable trackId: TrackId): Track {
        return persistence.getTrack(trackId).block(Duration.ofSeconds(1)) ?: throw ResourceNotFoundException()
    }

}