package com.ash.music.app.user.library.endpoints

import com.ash.music.app.model.AlbumId
import com.ash.music.app.model.UserId
import com.ash.music.app.user.library.persistence.UserAlbumPersistence
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user/{userId}/album/{albumId}")
class UserAlbumEndpoints(
    private val userAlbumPersistence: UserAlbumPersistence
) {

    private val logger = LoggerFactory.getLogger(UserAlbumEndpoints::class.java)

    @PutMapping("/like")
    fun likeAlbum(@PathVariable userId: UserId, @PathVariable albumId: AlbumId) {
        logger.info("User: [$userId] Liked Album [$albumId]")
        userAlbumPersistence.likeAlbum(userId, albumId)
    }

    @DeleteMapping("/like")
    fun removeLikeAlbum(@PathVariable userId: UserId,@PathVariable albumId: AlbumId) {
        logger.info("User: [$userId] Removed Liked Album [$albumId]")
        userAlbumPersistence.removeLikeAlbum(userId, albumId)
    }

    @PutMapping("/dislike")
    fun dislikeAlbum(@PathVariable userId: UserId,@PathVariable albumId: AlbumId) {
        logger.info("User: [$userId] Disliked Album [$albumId]")
        userAlbumPersistence.dislikeAlbum(userId, albumId)
    }

    @DeleteMapping("/dislike")
    fun removeDislikeAlbum(@PathVariable userId: UserId,@PathVariable albumId: AlbumId) {
        logger.info("User: [$userId] Removed Disliked Album [$albumId]")
        userAlbumPersistence.removeDislikeAlbum(userId, albumId)
    }
}