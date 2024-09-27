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
    id("FeatureContextReceiver")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            System("core")

            model("authentication")
            data("authentication")

            model("profile")
            data("profile")
        }
    }
}

android {

    namespace = "main.authentication.presentation"
}

task("testClasses")
