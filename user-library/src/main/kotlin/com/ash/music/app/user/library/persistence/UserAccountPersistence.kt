package com.ash.music.app.user.library.persistence

import com.ash.music.app.model.UserId
import com.ash.music.app.model.user.User
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component
import java.time.Duration
import java.util.UUID

@Component
class UserAccountPersistence(
    private val databaseClient: DatabaseClient
) {
    fun getUser(userId: UserId): User? {
        return databaseClient.sql("SELECT customer_id, name FROM customer WHERE customer_id = :customerId")
            .bind("customerId", userId)
            .fetch()
            .first()
            .map {
                User(
                    UUID.fromString(it["customer_id"]!!.toString()),
                    it["name"]!!.toString()
                )
            }.block(Duration.ofSeconds(1))
    }

}
