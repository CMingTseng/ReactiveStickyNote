dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
        google()
        jcenter() // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "ReactiveStickyNote"
include(":app")