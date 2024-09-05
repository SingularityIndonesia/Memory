import plugin.convention.companion.Shared
import plugin.convention.companion.System
import plugin.convention.companion.model
import plugin.convention.companion.data

plugins {
    id("LibraryConventionV1")
    id("CompileIOS")
    /*id("CompileWasm")*/
    id("FeatureCoroutine")
    id("FeaturePane")
    id("FeatureSerialization")
    id("FeatureHttpClient")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            System("core")
            Shared("common")

            data("dashboard")
            model("dashboard")
        }
    }
}

android {

    namespace = "main.dashboard.presentation"
}

task("testClasses")
