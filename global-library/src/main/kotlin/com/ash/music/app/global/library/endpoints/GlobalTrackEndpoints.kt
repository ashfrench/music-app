package com.ash.music.app.global.library.endpoints

import com.ash.music.app.global.library.persistence.GlobalTrackPersistence
import com.ash.music.app.model.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("library/track")
class GlobalTrackEndpoints(
    private val persistence: GlobalTrackPersistence
) {

    @GetMapping
    fun getTracks(): List<ITrack> {
        TODO()
    }

    @GetMapping("/{trackId}")
    fun getTrack(@PathVariable trackId: TrackId): ITrack {
        TODO()
    }

}