package com.ash.music.app.global.library.persistence

import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component

@Component
class GlobalLibraryPersistence(
    private val databaseClient: DatabaseClient
) {
}