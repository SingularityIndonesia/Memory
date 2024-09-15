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
            Shared("compose")
            Shared("simpleactivity")
        }
    }
}

android {
    namespace = "system.core"
}

extensions.getByType<ComposeExtension>().resources {
    publicResClass = true
    packageOfResClass = "system.designsystem.resources"
    generateResClass = always
}

task("testClasses")
