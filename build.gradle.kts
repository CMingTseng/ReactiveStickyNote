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

allprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
            useIR = true //Google Android Compose
            freeCompilerArgs += listOf(
                "-P",
                "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
            )
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}