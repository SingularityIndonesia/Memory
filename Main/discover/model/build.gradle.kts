plugins {
    id("LibraryConventionV1")
    id("CompileIOS")
    /*id("CompileWasm")*/
    id("FeatureCoroutine")
    id("FeatureSerialization")
}

android {
    namespace = "main.discover.model"
}

task("testClasses")
