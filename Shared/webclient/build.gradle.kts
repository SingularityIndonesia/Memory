import plugin.convention.companion.System

plugins {
    id("LibraryConventionV1")
    id("CompileIOS")
    // id("CompileWasm")
    id("FeatureCoroutine")
    id("FeatureHttpClient")
    id("FeatureAndroidPluto")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            // fixme: should not depend on core
            System("core")
        }
    }
}

android {
    namespace = "shared.webclient"
}

task("testClasses")
