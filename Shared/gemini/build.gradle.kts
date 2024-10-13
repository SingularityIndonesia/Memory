plugins {
    id("LibraryConventionV1")
    id("CompileIOS")
    /*id("CompileWasm")*/
    id("FeatureCoroutine")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.generativeai)
        }
        androidMain.dependencies {
            implementation(libs.generativeai)
        }
        iosMain.dependencies {
            implementation(libs.generativeai)
        }
    }
}

android {
    namespace = "shared.gemini"
}

task("testClasses")
