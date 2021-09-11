buildscript {
    val kotlinVersion = "1.5.21"

    repositories {
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
        google()
    }

    dependencies {
        classpath ("com.google.gms:google-services:4.3.8")
        classpath ("com.android.tools.build:gradle:7.1.0-alpha05")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}