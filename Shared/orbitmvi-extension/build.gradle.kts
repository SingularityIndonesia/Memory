plugins {
    id("LibraryConventionV1")
    id("CompileIOS")
    // id("CompileWasm")
    id("FeaturePane") // fixme: works but not necessary
    id("FeatureCoroutine")
    id("FeatureContextReceiver")
}

// fixme: not working why?
// kotlin {
//    sourceSets {
//        commonMain.dependencies {
//            implementation(libs.bundles.orbit.mvi)
//        }
//    }
// }

android {
    namespace = "shared.orbitmviextension"
}

task("testClasses")
