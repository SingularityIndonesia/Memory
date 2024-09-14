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
        includeBuild("../Shared") {
            dependencySubstitution {
                // include all Library
                File(settingsDir, "../Shared")
                    .listFiles()
                    ?.asSequence()
                    ?.filter { it.isDirectory }
                    ?.filter { it.listFiles()?.map { it.name }?.contains("build.gradle.kts") == true }
                    ?.onEach { dir ->
                        substitute(module("shared:${dir.name}")).using(project(":${dir.name}"))
                    }?.toList()
            }
        }
    }
}

// include all libraries
File(settingsDir, "./")
    .listFiles()
    ?.asSequence()
    ?.filter { it.isDirectory }
    ?.filter { it.listFiles()?.map { it.name }?.contains("build.gradle.kts") == true }
    ?.onEach { dir ->
        include(":${dir.name}")
    }?.toList()
