package com.ash.music.app.user.library.persistence

import com.ash.music.app.model.TrackId
import com.ash.music.app.model.UserId
import org.springframework.stereotype.Component

@Component
class UserLibraryPersistence {
    fun likeTrack(userId: UserId, trackId: TrackId) {
        TODO("Not yet implemented")
    }

    fun removeLikeTrack(userId: UserId, trackId: TrackId) {
        TODO("Not yet implemented")
    }

    fun dislikeTrack(userId: UserId, trackId: TrackId) {
        TODO("Not yet implemented")
    }

    fun removeDislikeTrack(userId: UserId, trackId: TrackId) {
        TODO("Not yet implemented")
    }
}