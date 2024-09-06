plugins {
    id("LibraryConventionV1")
    id("CompileIOS")
    /*id("CompileWasm")*/
    id("FeatureCoroutine")
    id("FeatureSerialization")
}

android {
    namespace = "main.memories.model"
}

task("testClasses")
