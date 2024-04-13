package com.ash.music.app.global.library.persistence

import com.ash.music.app.model.*
import com.ash.music.app.model.user.User
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.*

@Component
class GlobalTrackPersistence(
    private val client: DatabaseClient
)