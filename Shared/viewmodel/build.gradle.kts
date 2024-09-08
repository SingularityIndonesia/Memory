plugins {
    id("LibraryConventionV1")
    id("CompileIOS")
    // id("CompileWasm")
    id("FeatureCoroutine")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.lifecycle.viewmodel.compose)
        }
    }
}

android {
    namespace = "shared.viewmodel"
}

task("testClasses")
