package com.ash.music.app.global.library.endpoints

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GlobalArtistEndpointsTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `get artists`() {
        val responseEntity = restTemplate.getForEntity<String>("/library/artist")

        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(responseEntity.hasBody()).isTrue()
        assertNotNull(responseEntity.body)
        assertEquals("""[{"artistId":"deadbeef-dead-beef-dead-beefdeadbeef","artistName":"Ash Is Awesome","bio":{}}]""", responseEntity.body)

    }

    @Test
    fun `get artist`() {
        val responseEntity = restTemplate.getForEntity<String>("/library/artist/deadbeef-dead-beef-dead-beefdeadbeef")

        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(responseEntity.hasBody()).isTrue()
        assertNotNull(responseEntity.body)
        assertEquals("""{"artistId":"deadbeef-dead-beef-dead-beefdeadbeef","artistName":"Ash Is Awesome","bio":{}}""", responseEntity.body)

    }

    @Test
    fun `get artist not found`() {
        val responseEntity = restTemplate.getForEntity<String>("/library/artist/deadbeef-dead-beef-dead-beefdeadbeeb")
        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
    }

    @Test
    fun `get artist invalid uuid`() {
        val responseEntity = restTemplate.getForEntity<String>("/library/artist/1235")
        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.BAD_REQUEST)
    }

    @Test
    fun `get artist tracks`() {
        val responseEntity = restTemplate.getForEntity<String>("/library/artist/deadbeef-dead-beef-dead-beefdeadbeef/track")

        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(responseEntity.hasBody()).isTrue()
        assertNotNull(responseEntity.body)
        assertEquals("""[{"trackId":"11111111-1111-1111-1111-011111111111","trackName":"My Song","artistId":"deadbeef-dead-beef-dead-beefdeadbeef"},{"trackId":"22222222-2222-2222-2222-022222222222","trackName":"I did a music","artistId":"deadbeef-dead-beef-dead-beefdeadbeef"},{"trackId":"33333333-3333-3333-3333-033333333333","trackName":"Notes Happened","artistId":"deadbeef-dead-beef-dead-beefdeadbeef"},{"trackId":"44444444-4444-4444-4444-044444444444","trackName":"Boom Another Song","artistId":"deadbeef-dead-beef-dead-beefdeadbeef"},{"trackId":"55555555-5555-5555-5555-055555555555","trackName":"Loud Noises","artistId":"deadbeef-dead-beef-dead-beefdeadbeef"}]""", responseEntity.body)

    }

}