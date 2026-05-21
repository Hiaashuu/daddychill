plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.hiaashuu.appinfo"
    compileSdk = 36

    defaultConfig {
        minSdk = 21
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.fromTarget("17"))
        }
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

// FIX: afterEvaluate must be at top level, NOT nested inside register<MavenPublication>.
// Nesting it inside caused the "release" component to be unresolved at configuration time,
// which broke the JitPack publish task and made the library impossible to consume.
afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.Hiaashuu.daddychill"
                artifactId = "appinfo"
                version = "1.0.1"
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
}
