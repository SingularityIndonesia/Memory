plugins {
    id("LibraryConventionV1")
    id("CompileIOS")
    // id("CompileWasm")
    id("FeatureCoroutine")
    id("FeaturePane")
    id("FeatureContextReceiver")
    id("FeatureSerialization")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":compose"))
        }
    }
}

android {
    namespace = "shared.navigation"
}

task("testClasses")
