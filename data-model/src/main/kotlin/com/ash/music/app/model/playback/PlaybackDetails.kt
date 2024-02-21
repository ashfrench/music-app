package com.ash.music.app.model.playback

import com.ash.music.app.model.TrackId
import com.ash.music.app.model.UserId

interface PlaybackDetails {

    val userId: UserId
    val trackId: TrackId
    val source: PlaybackSource
}