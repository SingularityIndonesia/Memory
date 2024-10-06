import plugin.convention.companion.Shared
import plugin.convention.companion.System

plugins {
    id("LibraryConventionV1")
    id("CompileIOS")
    /*id("CompileWasm")*/
    id("FeatureCoroutine")
    id("FeatureSerialization")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            System("core")
        }
    }
}

android {
    namespace = "main.philosopher.model"
}

task("testClasses")
