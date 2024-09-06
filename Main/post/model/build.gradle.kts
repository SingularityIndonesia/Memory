plugins {
    id("LibraryConventionV1")
    id("CompileIOS")
    /*id("CompileWasm")*/
    id("FeatureCoroutine")
    id("FeatureSerialization")
}

android {
    namespace = "main.post.model"
}

task("testClasses")
