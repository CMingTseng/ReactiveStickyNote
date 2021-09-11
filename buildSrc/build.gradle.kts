plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    mavenLocal()
    gradlePluginPortal()
    google()
}

kotlin {
    // Add Deps to compilation, so it will become available in main project
    sourceSets.getByName("main").kotlin.srcDir("src/main/kotlin")
}