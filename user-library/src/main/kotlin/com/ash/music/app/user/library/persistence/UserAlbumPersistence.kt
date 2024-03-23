package com.ash.music.app.user.library.persistence

import com.ash.music.app.model.AlbumId
import com.ash.music.app.model.UserAlbum
import com.ash.music.app.model.UserId
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component

@Component
class UserAlbumPersistence(
    private val databaseClient: DatabaseClient
) {
    fun likeAlbum(userId: UserId, albumId: AlbumId) {
        TODO("Not yet implemented")
    }

    fun removeLikeAlbum(userId: UserId, albumId: AlbumId) {
        TODO("Not yet implemented")
    }

    fun dislikeAlbum(userId: UserId, albumId: AlbumId) {
        TODO("Not yet implemented")
    }

    fun removeDislikeAlbum(userId: UserId, albumId: AlbumId) {
        TODO("Not yet implemented")
    }

    fun getAlbums(userId: UserId): List<UserAlbum> {
        TODO("Not yet implemented")
    }

    fun getAlbum(userId: UserId, albumId: AlbumId): UserAlbum {
        TODO("Not yet implemented")
    }

}
