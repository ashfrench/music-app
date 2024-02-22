package com.ash.music.app.user.library.endpoints

import com.ash.music.app.model.ArtistId
import com.ash.music.app.model.UserId
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user/{userId}/artist/{artistId}")
class UserArtistEndpoints {

    private val logger = LoggerFactory.getLogger(UserArtistEndpoints::class.java)

    @PutMapping("/like")
    fun likeArtist(userId: UserId, artistId: ArtistId) {
        TODO()
    }

    @DeleteMapping("/like")
    fun removeLikeArtist(userId: UserId, artistId: ArtistId) {
        TODO()
    }

    @PutMapping("/dislike")
    fun dislikeArtist(userId: UserId, artistId: ArtistId) {
        TODO()
    }

    @DeleteMapping("/dislike")
    fun removeDislikeArtist(userId: UserId, artistId: ArtistId) {
        TODO()
    }
}