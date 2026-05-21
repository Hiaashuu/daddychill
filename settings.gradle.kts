pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // FIX: JitPack was missing. Without this, no project — including this one
        // and any app trying to consume the library — can resolve it from JitPack.
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "daddychill"

include(":app")
include(":library")
