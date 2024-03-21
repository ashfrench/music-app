package com.ash.music.app.user.library.persistence

import com.ash.music.app.model.TrackId
import com.ash.music.app.model.UserId
import org.springframework.stereotype.Component
import org.springframework.r2dbc.core.DatabaseClient

@Component
class UserLibraryPersistence(
    private val databaseClient: DatabaseClient
) {
    fun likeTrack(userId: UserId, trackId: TrackId) {
        databaseClient.sql("INSERT INTO TABLE ....")
            .bind("userId", userId)
            .bind("trackId", trackId)
            .then().doOnError {
                throw it
            }
    }

    fun removeLikeTrack(userId: UserId, trackId: TrackId) {
        databaseClient.sql("INSERT INTO TABLE ....")
            .bind("userId", userId)
            .bind("trackId", trackId)
            .then().doOnError {
                throw it
            }
    }

    fun dislikeTrack(userId: UserId, trackId: TrackId) {
        databaseClient.sql("INSERT INTO TABLE ....")
            .bind("userId", userId)
            .bind("trackId", trackId)
            .then().doOnError {
                throw it
            }
    }

    fun removeDislikeTrack(userId: UserId, trackId: TrackId) {
        databaseClient.sql("INSERT INTO TABLE ....")
            .bind("userId", userId)
            .bind("trackId", trackId)
            .then().doOnError {
                throw it
            }
    }
}