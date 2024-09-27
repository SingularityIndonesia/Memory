import org.jetbrains.compose.ComposeExtension
import plugin.convention.companion.Shared

plugins {
    id("LibraryConventionV1")
    id("CompileIOS")
    // id("CompileWasm")
    id("FeaturePane")
    id("FeatureHttpClient")
    id("FeatureCoroutine")
    id("FeatureAndroidPluto")
    id("FeatureContextReceiver")
    id("FeatureSerialization")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            Shared("preference")
        }
    }
}

android {
    namespace = "system.core"

//    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
//    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/composeResources/")
}

extensions.getByType<ComposeExtension>().resources {
    publicResClass = true
    packageOfResClass = "system.designsystem.resources"
    generateResClass = always
}

task("testClasses")
