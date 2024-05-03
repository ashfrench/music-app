package com.ash.music.app.global.library.endpoints

import com.ash.music.app.model.IArtist
import com.ash.music.app.model.SoloArtist
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import java.util.UUID

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GlobalArtistEndpointsTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `get artists`() {
        val responseEntity = restTemplate.getForEntity<String>("/library/artist")

        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(responseEntity.hasBody()).isTrue()
        assertNotNull(responseEntity.body)
        assertEquals("[{\"artistId\":\"deadbeef-dead-beef-dead-beefdeadbeef\",\"artistName\":\"Ash Is Awesome\",\"bio\":{}}]", responseEntity.body)

    }

    @Test
    fun `get artist`() {
        val responseEntity = restTemplate.getForEntity<String>("/library/artist/deadbeef-dead-beef-dead-beefdeadbeef")

        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(responseEntity.hasBody()).isTrue()
        assertNotNull(responseEntity.body)
        assertEquals("{\"artistId\":\"deadbeef-dead-beef-dead-beefdeadbeef\",\"artistName\":\"Ash Is Awesome\",\"bio\":{}}", responseEntity.body)

    }

    @Test
    fun `get artist not found`() {
        val responseEntity = restTemplate.getForEntity<String>("/library/artist/deadbeef-dead-beef-dead-beefdeadbeeb")
        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
    }

    @Test
    fun `get artist tracks`() {

        val x = UUID.fromString("11111111-1111-1111-1111-11111111111")

        val responseEntity = restTemplate.getForEntity<String>("/library/artist/deadbeef-dead-beef-dead-beefdeadbeef/track")

        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(responseEntity.hasBody()).isTrue()
        assertNotNull(responseEntity.body)
        assertEquals("[{\"trackId\":\"11111111-1111-1111-1111-011111111111\",\"trackName\":\"My Song\",\"artistId\":\"deadbeef-dead-beef-dead-beefdeadbeef\"},{\"trackId\":\"22222222-2222-2222-2222-022222222222\",\"trackName\":\"I did a music\",\"artistId\":\"deadbeef-dead-beef-dead-beefdeadbeef\"},{\"trackId\":\"33333333-3333-3333-3333-033333333333\",\"trackName\":\"Notes Happened\",\"artistId\":\"deadbeef-dead-beef-dead-beefdeadbeef\"},{\"trackId\":\"44444444-4444-4444-4444-044444444444\",\"trackName\":\"Boom Another Song\",\"artistId\":\"deadbeef-dead-beef-dead-beefdeadbeef\"},{\"trackId\":\"55555555-5555-5555-5555-055555555555\",\"trackName\":\"Loud Noises\",\"artistId\":\"deadbeef-dead-beef-dead-beefdeadbeef\"}]", responseEntity.body)

    }

}