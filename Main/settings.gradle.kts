/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        includeBuild("../Plugin")
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        includeBuild("../System") {
            dependencySubstitution {
                // include all Library
                File(settingsDir, "../System")
                    .listFiles()
                    ?.asSequence()
                    ?.filter { it.isDirectory }
                    ?.filter { it.listFiles()?.map { it.name }?.contains("build.gradle.kts") == true }
                    ?.onEach { dir ->
                        substitute(module("system:${dir.name}")).using(project(":${dir.name}"))
                    }?.toList()
            }
        }
    }
}

fun includeModuleRecursively(name: String) {
    File(settingsDir, "./$name")
        .listFiles()
        ?.asSequence()
        ?.filter { it.isDirectory }
        ?.filter { it.listFiles()?.map { it.name }?.contains("build.gradle.kts") == true }
        ?.onEach { dir ->
            include(":$name:${dir.name}")
        }?.toList()
}

include(":composeApp")

File(settingsDir, "./authentication")
    .listFiles()
    ?.asSequence()
    ?.filter { it.isDirectory }
    ?.filter { it.listFiles()?.map { it.name }?.contains("build.gradle.kts") == true }
    ?.onEach { dir ->
        include(":authentication:${dir.name}")
    }?.toList()

File(settingsDir, "./profile")
    .listFiles()
    ?.asSequence()
    ?.filter { it.isDirectory }
    ?.filter { it.listFiles()?.map { it.name }?.contains("build.gradle.kts") == true }
    ?.onEach { dir ->
        include(":profile:${dir.name}")
    }?.toList()

File(settingsDir, "./discover")
    .listFiles()
    ?.asSequence()
    ?.filter { it.isDirectory }
    ?.filter { it.listFiles()?.map { it.name }?.contains("build.gradle.kts") == true }
    ?.onEach { dir ->
        include(":discover:${dir.name}")
    }?.toList()

File(settingsDir, "./memories")
    .listFiles()
    ?.asSequence()
    ?.filter { it.isDirectory }
    ?.filter { it.listFiles()?.map { it.name }?.contains("build.gradle.kts") == true }
    ?.onEach { dir ->
        include(":memories:${dir.name}")
    }?.toList()


File(settingsDir, "./philosopher")
    .listFiles()
    ?.asSequence()
    ?.filter { it.isDirectory }
    ?.filter { it.listFiles()?.map { it.name }?.contains("build.gradle.kts") == true }
    ?.onEach { dir ->
        include(":philosopher:${dir.name}")
    }
    ?.toList()
