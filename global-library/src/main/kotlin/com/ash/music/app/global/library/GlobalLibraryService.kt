package com.ash.music.app.global.library

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GlobalLibraryService

fun main(args: Array<String>) {
    runApplication<GlobalLibraryService>(*args)
}
