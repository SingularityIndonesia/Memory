import plugin.convention.companion.System

plugins {
    id("LibraryConventionV1")
    id("CompileIOS")
    // id("CompileWasm")
    id("FeatureCoroutine")
    id("FeatureSerialization")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            System("core")

            // fixme: add to catalog
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.1")
        }
    }
}

android {
    namespace = "main.authentication.model"
}

task("testClasses")
