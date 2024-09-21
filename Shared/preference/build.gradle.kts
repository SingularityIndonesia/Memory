plugins {
    id("LibraryConventionV1")
    id("CompileIOS")
    /*id("CompileWasm")*/
    id("FeatureCoroutine")
}

android {
    namespace = "shared.preference"
}

task("testClasses")
