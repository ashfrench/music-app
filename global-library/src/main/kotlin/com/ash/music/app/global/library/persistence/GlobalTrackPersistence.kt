package com.ash.music.app.global.library.persistence

import com.ash.music.app.model.Track
import com.ash.music.app.model.TrackId
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Component
class GlobalTrackPersistence(
    private val client: DatabaseClient
) {
    fun getTracks(pageStart: Int, pageAmount: Int): Flux<Track> {

        return client.sql(TRACKS_SQL)
            .bind("pageStart", pageStart)
            .bind("pageCount", pageAmount)
            .map { row ->
                Track(
                    UUID.fromString(row["track_id"]!!.toString()),
                    row["track_name"]!!.toString(),
                    UUID.fromString(row["artist_id"]!!.toString())
                )
            }
            .all()
    }

    fun getTrack(trackId: TrackId): Mono<Track> {
        return client.sql(TRACK_SQL)
            .bind("trackId", trackId)
            .map { row ->
                Track(
                    UUID.fromString(row["track_id"]!!.toString()),
                    row["track_name"]!!.toString(),
                    UUID.fromString(row["artist_id"]!!.toString())
                )
            }
            .first()
    }
}

private val TRACKS_SQL = """
    SELECT track_id, track_name, artist_id 
    FROM track
    ORDER BY track_id
    LIMIT :pageCount
    OFFSET :pageStart
""".trimIndent()

private val TRACK_SQL = """
    SELECT track_id, track_name, artist_id 
    FROM track
    WHERE track_id = :trackId
""".trimIndent()