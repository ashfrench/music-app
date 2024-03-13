package com.ash.music.app.user.library.endpoints

import com.ash.music.app.model.ArtistId
import com.ash.music.app.model.UserId
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user/{userId}/artist/{artistId}")
class UserArtistEndpoints {

    private val logger = LoggerFactory.getLogger(UserArtistEndpoints::class.java)

    @PutMapping("/like")
    fun likeArtist(@PathVariable userId: UserId, @PathVariable artistId: ArtistId) {
        TODO()
    }

    @DeleteMapping("/like")
    fun removeLikeArtist(@PathVariable userId: UserId,@PathVariable  artistId: ArtistId) {
        TODO()
    }

    @PutMapping("/dislike")
    fun dislikeArtist(@PathVariable userId: UserId,@PathVariable  artistId: ArtistId) {
        TODO()
    }

    @DeleteMapping("/dislike")
    fun removeDislikeArtist(@PathVariable userId: UserId,@PathVariable  artistId: ArtistId) {
        TODO()
    }
}