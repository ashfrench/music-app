package com.ash.music.app.global.library.persistence

import com.ash.music.app.model.Album
import com.ash.music.app.model.AlbumId
import com.ash.music.app.model.AlbumTrack
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
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

    fun getAlbum(albumId: AlbumId): Mono<Album> {
        return client.sql("SELECT album_id, album_name, artist_id FROM album WHERE album_id = :albumID")
            .bind("albumID", albumId)
            .map { row ->
                Album(
                    UUID.fromString(row["album_id"]!!.toString()),
                    row["album_name"]!!.toString(),
                    UUID.fromString(row["artist_id"]!!.toString()),
                    emptyList()
                )
            }.first()
    }

    fun getAlbumTracks(albumId: AlbumId): Mono<List<AlbumTrack>> {
        return client.sql("SELECT t.track_id, t.track_name, t.artist_id, at.album_id, at.track_number FROM track t, album_tracks at WHERE at.album_id = :albumID AND at.track_id = t.track_id")
            .bind("albumID", albumId)

            .map { row ->
                AlbumTrack(
                    UUID.fromString(row["track_id"]!!.toString().trim()),
                    row["track_name"]!!.toString(),
                    row["track_number"]!! as Int,
                    UUID.fromString(row["artist_id"]!!.toString().trim()),
                    UUID.fromString(row["album_id"]!!.toString().trim()),
                )
            }
            .all()
            .collectList()
    }
}