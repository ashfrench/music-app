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

}