package com.ash.music.app.user.library

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import kotlin.test.assertNotNull

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserLibraryServiceTest(@Autowired val restTemplate: TestRestTemplate) {

    private val logger = LoggerFactory.getLogger(UserLibraryServiceTest::class.java)

    @Test
    fun contextLoads() {
    }

    @Test
    fun testSwagger() {
        val swaggerPage = restTemplate.getForEntity<String>("/swagger-ui/index.html")
        assertThat(swaggerPage.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(swaggerPage.hasBody()).isTrue()
        assertNotNull(swaggerPage.body)
        logger.info(swaggerPage.body)
    }

    @Test
    fun testApiDocs() {
        val apiDocsPage = restTemplate.getForEntity<String>("/v3/api-docs")
        assertThat(apiDocsPage.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(apiDocsPage.hasBody()).isTrue()
        assertNotNull(apiDocsPage.body)
        logger.info(apiDocsPage.body)
    }


}