package com.ash.music.app.global.library.persistence

import com.ash.music.app.model.*
import com.ash.music.app.model.user.User
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.awaitOneOrNull
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.*

@Component
class GlobalAlbumPersistence(
    private val client: DatabaseClient
) {
    fun getAlbums(): Flux<Album> {
        return  client.sql("SELECT album_id, album_name, artist_id FROM album")
            .map { row ->
                Album(
                    UUID.fromString(row["album_id"]!!.toString()),
                    row["album_name"]!!.toString(),
                    UUID.fromString(row["artist_id"]!!.toString()),
                    emptyList()
                )
            }.all()
    }

    suspend fun getAlbum(albumId: AlbumId): Album? {
        return client.sql("SELECT album_id, album_name, artist_id FROM album WHERE album_id = :albumID")
            .bind("albumID", albumId)
            .map { row ->
                Album(
                    UUID.fromString(row["album_id"]!!.toString()),
                    row["album_name"]!!.toString(),
                    UUID.fromString(row["artist_id"]!!.toString()),
                    emptyList()
                )
            }.awaitOneOrNull()
    }

    fun getAlbumTracks(albumId: AlbumId): Flux<ITrack> {
        return client.sql("SELECT t.track_id, t.track_name, t.artist_id, at.album_id FROM track t, album_tracks at WHERE t.album_id = :albumID AND at.track_id = t.track_id")
            .bind("albumID", albumId)
            .map<ITrack> { row ->
                Track(
                    UUID.fromString(row["track_id"]!!.toString()),
                    row["track_name"]!!.toString(),
                    UUID.fromString(row["artist_id"]!!.toString()),
                    UUID.fromString(row["album_id"]!!.toString()),
                )
            }
            .all()
    }
}