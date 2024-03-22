package com.ash.music.app.user.library.persistence

import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component

@Component
class UserAlbumPersistence(
    private val databaseClient: DatabaseClient
) {

}
