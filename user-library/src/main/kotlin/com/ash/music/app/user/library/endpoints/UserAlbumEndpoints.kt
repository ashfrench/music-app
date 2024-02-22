package com.ash.music.app.user.library.endpoints

import com.ash.music.app.model.AlbumId
import com.ash.music.app.model.UserId
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user/{userId}/album/{albumId}")
class UserAlbumEndpoints {

    private val logger = LoggerFactory.getLogger(UserAlbumEndpoints::class.java)

    @PutMapping("/like")
    fun likeAlbum(userId: UserId, albumId: AlbumId) {
        TODO()
    }

    @DeleteMapping("/like")
    fun removeLikeAlbum(userId: UserId, albumId: AlbumId) {
        TODO()
    }

    @PutMapping("/dislike")
    fun dislikeAlbum(userId: UserId, albumId: AlbumId) {
        TODO()
    }

    @DeleteMapping("/dislike")
    fun removeDislikeAlbum(userId: UserId, albumId: AlbumId) {
        TODO()
    }
}