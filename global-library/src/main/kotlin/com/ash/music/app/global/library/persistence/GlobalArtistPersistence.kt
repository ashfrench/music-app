package com.ash.music.app.global.library.persistence

import com.ash.music.app.model.*
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.awaitOneOrNull
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.util.UUID

@Component
class GlobalArtistPersistence(
    private val client: DatabaseClient
) {
    fun getArtists(): Flux<IArtist> {
        return  client.sql("SELECT artist_id, artist_name FROM artist")
            .map { row ->
                SoloArtist(
                    UUID.fromString(row["artist_id"]!!.toString()),
                    row["artist_name"]!!.toString()
                ) as IArtist
            }.all()
    }

    suspend fun getArtist(artistId: ArtistId): IArtist? {
        return client.sql("SELECT artist_id, artist_name FROM artist WHERE artist_id = :artID")
            .bind("artID", artistId)
            .map { row ->
                SoloArtist(
                    UUID.fromString(row["artist_id"]!!.toString()),
                    row["artist_name"]!!.toString()
                )
            }.awaitOneOrNull()
    }

    fun getArtistTracks(artistId: ArtistId): Flux<ITrack> {
        return client.sql("SELECT t.track_id, t.track_name, t.artist_id, at.album_id FROM track t, album_tracks at WHERE t.artist_id = :artID AND at.track_id = t.track_id")
            .bind("artID", artistId)
            .map<ITrack> { row ->
                Track(
                    UUID.fromString(row["track_id"]!!.toString()),
                    row["track_name"]!!.toString(),
                    UUID.fromString(row["artist_id"]!!.toString())
                )
            }
            .all()
    }
}