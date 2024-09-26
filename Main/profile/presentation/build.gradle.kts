import plugin.convention.companion.System
import plugin.convention.companion.data
import plugin.convention.companion.model

plugins {
    id("LibraryConventionV1")
    id("CompileIOS")
    // id("CompileWasm")
    id("FeatureCoroutine")
    id("FeaturePane")
    id("FeatureSerialization")
    id("FeatureHttpClient")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            System("core")

            data("profile")
            model("profile")
        }
    }
}

android {

    namespace = "main.profile.presentation"
}

task("testClasses")
