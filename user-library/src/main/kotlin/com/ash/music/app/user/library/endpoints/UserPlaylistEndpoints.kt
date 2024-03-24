package com.ash.music.app.user.library.endpoints

import com.ash.music.app.model.UserId
import com.ash.music.app.model.UserPlaylist
import com.ash.music.app.user.library.persistence.UserPlaylistPersistence
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user/{userId}/playlist")
class UserPlaylistEndpoints(
    private val userPlaylistPersistence: UserPlaylistPersistence
) {

    private val logger = LoggerFactory.getLogger(UserPlaylistEndpoints::class.java)

    @PostMapping("/create")
    fun createPlaylist(@PathVariable userId: UserId, @RequestBody playlist: UserPlaylist) {
        logger.info("User: [$userId] Created Playlist [$playlist]")
        userPlaylistPersistence.createPlaylist(userId, playlist)
    }

}