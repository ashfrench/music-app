package com.ash.music.app.global.library.persistence

import com.ash.music.app.model.*
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

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

    fun getArtist(artistId: ArtistId): Mono<IArtist> {
        return client.sql("SELECT artist_id, artist_name FROM artist WHERE artist_id = :artID")
            .bind("artID", artistId)
            .map { row ->
                SoloArtist(
                    UUID.fromString(row["artist_id"]!!.toString()),
                    row["artist_name"]!!.toString()
                ) as IArtist
            }
            .first()
    }

    fun getArtistTracks(artistId: ArtistId): Mono<List<ITrack>> {
        return client.sql("SELECT t.track_id, t.track_name, t.artist_id, at.album_id FROM track t, album_tracks at WHERE t.artist_id = :artID AND at.track_id = t.track_id")
            .bind("artID", artistId)
            .map<ITrack> { row ->
                Track(
                    UUID.fromString(row["track_id"]!!.toString().trim()),
                    row["track_name"]!!.toString(),
                    UUID.fromString(row["artist_id"]!!.toString().trim())
                )
            }
            .all()
            .collectList()
    }
}