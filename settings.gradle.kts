plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "music-app"
include("data-model")
include("user-library")
include("global-library")
