plugins {
    alias(myplugins.plugins.springboot)
    alias(myplugins.plugins.springbootdm)
    alias(myplugins.plugins.kotlin)
    alias(myplugins.plugins.kotlinspring)
}

group = "com.ash.music.app"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":data-model"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")

//    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.8.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    testImplementation("io.projectreactor:reactor-test:3.6.5")


    implementation("io.r2dbc:r2dbc-h2")
    implementation("org.liquibase:liquibase-core:4.27.0")
    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    implementation(libs.swagger)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}