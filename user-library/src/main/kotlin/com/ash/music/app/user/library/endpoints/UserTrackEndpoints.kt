package com.ash.music.app.user.library.endpoints

import com.ash.music.app.model.TrackId
import com.ash.music.app.model.UserId
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user/{userId}/track/{trackId}")
class UserTrackEndpoints {

    private val logger = LoggerFactory.getLogger(UserTrackEndpoints::class.java)

    @PutMapping("/like")
    fun likeTrack(@PathVariable userId: UserId, @PathVariable trackId: TrackId) {
        logger.info("User: [$userId] Liked Track [$trackId]")
        TODO()
    }

    @DeleteMapping("/like")
    fun removeLikeTrack(@PathVariable userId: UserId, @PathVariable trackId: TrackId) {
        logger.info("User: [$userId] Removed Liked Track [$trackId]")
        TODO()
    }

    @PutMapping("/dislike")
    fun dislikeTrack(@PathVariable userId: UserId, @PathVariable trackId: TrackId) {
        logger.info("User: [$userId] Disliked Track [$trackId]")
        TODO()
    }

    @DeleteMapping("/dislike")
    fun removeDislikeTrack(@PathVariable userId: UserId, @PathVariable trackId: TrackId) {
        logger.info("User: [$userId] Removed Disliked Track [$trackId]")
        TODO()
    }
}