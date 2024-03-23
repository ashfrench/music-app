package com.ash.music.app.user.library.endpoints

import com.ash.music.app.model.ArtistId
import com.ash.music.app.model.UserId
import com.ash.music.app.user.library.persistence.UserArtistPersistence
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user/{userId}/artist/{artistId}")
class UserArtistEndpoints(
    private val userArtistPersistence: UserArtistPersistence
) {

    private val logger = LoggerFactory.getLogger(UserArtistEndpoints::class.java)

    @PutMapping("/like")
    fun likeArtist(@PathVariable userId: UserId, @PathVariable artistId: ArtistId) {
        logger.info("User: [$userId] Liked Artist [$artistId]")
        userArtistPersistence.likeArtist(userId, artistId)
    }

    @DeleteMapping("/like")
    fun removeLikeArtist(@PathVariable userId: UserId,@PathVariable  artistId: ArtistId) {
        logger.info("User: [$userId] Removed Liked Artist [$artistId]")
        userArtistPersistence.removeLikeArtist(userId, artistId)
    }

    @PutMapping("/dislike")
    fun dislikeArtist(@PathVariable userId: UserId,@PathVariable  artistId: ArtistId) {
        logger.info("User: [$userId] Disliked Artist [$artistId]")
        userArtistPersistence.dislikeArtist(userId, artistId)
    }

    @DeleteMapping("/dislike")
    fun removeDislikeArtist(@PathVariable userId: UserId,@PathVariable  artistId: ArtistId) {
        logger.info("User: [$userId] Removed Disliked Artist [$artistId]")
        userArtistPersistence.removeDislikeArtist(userId, artistId)
    }
}