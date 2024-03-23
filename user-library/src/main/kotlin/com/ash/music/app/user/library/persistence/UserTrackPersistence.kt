package com.ash.music.app.user.library.persistence

import com.ash.music.app.model.TrackId
import com.ash.music.app.model.UserId
import com.ash.music.app.model.UserTrack
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component

@Component
class UserTrackPersistence(
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

    fun getTracks(userId: UserId): List<UserTrack> {
        TODO("Not yet implemented")
    }

    fun getTrack(userId: UserId, trackId: TrackId): UserTrack {
        TODO("Not yet implemented")
    }
}