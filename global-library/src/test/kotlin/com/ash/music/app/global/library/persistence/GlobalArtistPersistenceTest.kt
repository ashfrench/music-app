package com.ash.music.app.global.library.persistence

import com.ash.music.app.model.SoloArtist
import com.ash.music.app.model.Track
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.test.StepVerifier
import java.time.Duration
import java.util.*

@SpringBootTest
class GlobalArtistPersistenceTest(@Autowired val persistence: GlobalArtistPersistence) {

    @Test
    fun `get artists`() {
        val artistFlux = persistence.getArtists()

        StepVerifier.create(artistFlux)
            .expectNext(SoloArtist(UUID.fromString("deadbeef-dead-beef-dead-beefdeadbeef"), "Ash Is Awesome"))
            .expectComplete()
            .verifyThenAssertThat().hasNotDroppedErrors()

    }

    @Test
    fun `get artist`() {
        val artistMono = persistence.getArtist(UUID.fromString("deadbeef-dead-beef-dead-beefdeadbeef"))

        StepVerifier.create(artistMono)
            .expectNext(SoloArtist(UUID.fromString("deadbeef-dead-beef-dead-beefdeadbeef"), "Ash Is Awesome"))
            .expectComplete()
            .verifyThenAssertThat().hasNotDroppedErrors()

    }

    @Test
    fun `get artist not found`() {
        val artistMono = persistence.getArtist(UUID.fromString("deadbeef-dead-beef-dead-beefdeadbeed"))

        StepVerifier.create(artistMono)
            .expectTimeout(Duration.ofSeconds(1))
    }

    @Test
    fun `get artist tracks`() {
        val artistID = UUID.fromString("deadbeef-dead-beef-dead-beefdeadbeef")
        val artistFlux = persistence.getArtistTracks(artistID)

        StepVerifier.create(artistFlux)
            .expectNext(Track(UUID.fromString("11111111-1111-1111-1111-011111111111"), "My Song", artistID))
            .expectNext(Track(UUID.fromString("22222222-2222-2222-2222-022222222222"), "I did a music", artistID))
            .expectNext(Track(UUID.fromString("33333333-3333-3333-3333-033333333333"), "Notes Happened", artistID))
            .expectNext(Track(UUID.fromString("44444444-4444-4444-4444-044444444444"), "Boom Another Song", artistID))
            .expectNext(Track(UUID.fromString("55555555-5555-5555-5555-055555555555"), "Loud Noises", artistID))

            .expectComplete()
            .verifyThenAssertThat().hasNotDroppedErrors()
    }
    
}