import plugin.convention.companion.System
import plugin.convention.companion.model

plugins {
    id("LibraryConventionV1")
    id("CompileIOS")
    // id("CompileWasm")
    id("FeatureCoroutine")
    id("FeatureSerialization")
    id("FeatureHttpClient")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            System("core")
            model("authentication")
        }
    }
}

android {

    namespace = "main.authentication.data"
}

task("testClasses")
