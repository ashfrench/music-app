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
class GlobalAlbumEndpointsTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `get albums`() {
        val responseEntity = restTemplate.getForEntity<String>("/library/album")

        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(responseEntity.hasBody()).isTrue()
        assertNotNull(responseEntity.body)
        assertEquals("""[{"albumID":"deadcafe-dead-cafe-dead-cafedeadcafe","albumName":"Amazing Album","artistId":"deadbeef-dead-beef-dead-beefdeadbeef","trackList":[],"albumDetails":{}}]""", responseEntity.body)
    }

    @Test
    fun `get album`() {
        val responseEntity = restTemplate.getForEntity<String>("/library/album/deadcafe-dead-cafe-dead-cafedeadcafe")

        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(responseEntity.hasBody()).isTrue()
        assertNotNull(responseEntity.body)
        assertEquals("""{"albumID":"deadcafe-dead-cafe-dead-cafedeadcafe","albumName":"Amazing Album","artistId":"deadbeef-dead-beef-dead-beefdeadbeef","trackList":[],"albumDetails":{}}""", responseEntity.body)
    }

    @Test
    fun `get album tracks`() {
        val responseEntity = restTemplate.getForEntity<String>("/library/album/deadcafe-dead-cafe-dead-cafedeadcafe/track")

        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(responseEntity.hasBody()).isTrue()
        assertNotNull(responseEntity.body)
        assertEquals("""[{"trackId":"11111111-1111-1111-1111-011111111111","trackName":"My Song","trackNumber":1,"albumId":"deadbeef-dead-beef-dead-beefdeadbeef","artistId":"deadcafe-dead-cafe-dead-cafedeadcafe"},{"trackId":"22222222-2222-2222-2222-022222222222","trackName":"I did a music","trackNumber":2,"albumId":"deadbeef-dead-beef-dead-beefdeadbeef","artistId":"deadcafe-dead-cafe-dead-cafedeadcafe"},{"trackId":"33333333-3333-3333-3333-033333333333","trackName":"Notes Happened","trackNumber":3,"albumId":"deadbeef-dead-beef-dead-beefdeadbeef","artistId":"deadcafe-dead-cafe-dead-cafedeadcafe"},{"trackId":"44444444-4444-4444-4444-044444444444","trackName":"Boom Another Song","trackNumber":4,"albumId":"deadbeef-dead-beef-dead-beefdeadbeef","artistId":"deadcafe-dead-cafe-dead-cafedeadcafe"},{"trackId":"55555555-5555-5555-5555-055555555555","trackName":"Loud Noises","trackNumber":5,"albumId":"deadbeef-dead-beef-dead-beefdeadbeef","artistId":"deadcafe-dead-cafe-dead-cafedeadcafe"}]""", responseEntity.body)
    }

    @Test
    fun `get album not found`() {
        val responseEntity = restTemplate.getForEntity<String>("/library/album/deadcafe-dead-cafe-dead-cafedeadaaaa")
        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
    }

    @Test
    fun `get album tracks not found`() {
        val responseEntity = restTemplate.getForEntity<String>("/library/album/deadcafe-dead-cafe-dead-cafedeadaaaa/track")
        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
    }
}