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
        TODO()
    }

    @DeleteMapping("/like")
    fun removeLikeAlbum(@PathVariable userId: UserId,@PathVariable albumId: AlbumId) {
        TODO()
    }

    @PutMapping("/dislike")
    fun dislikeAlbum(@PathVariable userId: UserId,@PathVariable albumId: AlbumId) {
        TODO()
    }

    @DeleteMapping("/dislike")
    fun removeDislikeAlbum(@PathVariable userId: UserId,@PathVariable albumId: AlbumId) {
        TODO()
    }
}