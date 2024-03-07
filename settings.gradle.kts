plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("swagger", "org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
        }

        create("myplugins") {
            plugin("springboot", "org.springframework.boot").version("3.2.2")
            plugin("springbootdm", "io.spring.dependency-management").version("1.1.4")
            plugin("kotlin", "org.jetbrains.kotlin.jvm").version("1.9.22")
            plugin("kotlinspring", "org.jetbrains.kotlin.plugin.spring").version("1.9.22")
        }
    }
}

rootProject.name = "music-app"
include("data-model")
include("user-library")
include("global-library")
