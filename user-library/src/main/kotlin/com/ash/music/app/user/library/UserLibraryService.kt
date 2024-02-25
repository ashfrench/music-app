package com.ash.music.app.user.library

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UserLibraryService

fun main(args: Array<String>) {
    runApplication<UserLibraryService>(*args)
}