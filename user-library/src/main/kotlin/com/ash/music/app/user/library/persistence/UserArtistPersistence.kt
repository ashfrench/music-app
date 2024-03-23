package com.ash.music.app.user.library.persistence

import com.ash.music.app.model.ArtistId
import com.ash.music.app.model.IArtist
import com.ash.music.app.model.UserId
import org.springframework.stereotype.Component

@Component
class UserArtistPersistence {
    fun likeArtist(userId: UserId, artistId: ArtistId) {
        TODO("Not yet implemented")
    }

    fun removeLikeArtist(userId: UserId, artistId: ArtistId) {
        TODO("Not yet implemented")
    }

    fun dislikeArtist(userId: UserId, artistId: ArtistId) {
        TODO("Not yet implemented")
    }

    fun removeDislikeArtist(userId: UserId, artistId: ArtistId) {
        TODO("Not yet implemented")
    }

    fun getArtists(userId: UserId): IArtist {
        TODO("Not yet implemented")
    }

    fun getArtist(userId: UserId, artistId: ArtistId): IArtist {
        TODO("Not yet implemented")
    }

}
