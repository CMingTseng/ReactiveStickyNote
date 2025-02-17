buildscript {
    repositories {
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
        google()
    }

    dependencies {
        classpath("com.google.gms:google-services:4.3.8")
        classpath("com.android.tools.build:gradle:${Version.agp}")
        classpath(kotlin("gradle-plugin", Version.kotlin))
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}