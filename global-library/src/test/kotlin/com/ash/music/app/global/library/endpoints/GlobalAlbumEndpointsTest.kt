package com.ash.music.app.global.library.endpoints

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
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

        Assertions.assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        Assertions.assertThat(responseEntity.hasBody()).isTrue()
        assertNotNull(responseEntity.body)
        assertEquals("[{\"albumID\":\"deadcafe-dead-cafe-dead-cafedeadcafe\",\"albumName\":\"Amazing Album\",\"artistId\":\"deadbeef-dead-beef-dead-beefdeadbeef\",\"trackList\":[],\"albumDetails\":{}}]", responseEntity.body)
    }

}