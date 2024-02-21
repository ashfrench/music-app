package com.ash.music.app.model.playback

import java.util.UUID

data class PlaybackSource(
    val sourceType: PlaybackSourceType,
    val sourceId: UUID
)

enum class PlaybackSourceType {
    ALBUM,
    PLAYLIST,
    USER_PLAYLIST,
    USER_LIBRARY
}
