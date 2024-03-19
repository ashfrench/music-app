package com.ash.music.app.user.library.endpoints

import com.ash.music.app.model.TrackId
import com.ash.music.app.model.UserId
import com.ash.music.app.user.library.persistence.UserLibraryPersistence
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user/{userId}/track/{trackId}")
class UserTrackEndpoints(private val userLibraryPersistence: UserLibraryPersistence) {

    private val logger = LoggerFactory.getLogger(UserTrackEndpoints::class.java)

    @PutMapping("/like")
    fun likeTrack(@PathVariable userId: UserId, @PathVariable trackId: TrackId) {
        logger.info("User: [$userId] Liked Track [$trackId]")
        userLibraryPersistence.likeTrack(userId, trackId)
    }

    @DeleteMapping("/like")
    fun removeLikeTrack(@PathVariable userId: UserId, @PathVariable trackId: TrackId) {
        logger.info("User: [$userId] Removed Liked Track [$trackId]")
        userLibraryPersistence.removeLikeTrack(userId, trackId)
    }

    @PutMapping("/dislike")
    fun dislikeTrack(@PathVariable userId: UserId, @PathVariable trackId: TrackId) {
        logger.info("User: [$userId] Disliked Track [$trackId]")
        userLibraryPersistence.dislikeTrack(userId, trackId)
    }

    @DeleteMapping("/dislike")
    fun removeDislikeTrack(@PathVariable userId: UserId, @PathVariable trackId: TrackId) {
        logger.info("User: [$userId] Removed Disliked Track [$trackId]")
        userLibraryPersistence.removeDislikeTrack(userId, trackId)
    }
}