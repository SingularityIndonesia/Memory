/*
 * Copyright (c) 2024 Singularity Indonesia
 * You are not allowed to remove the copyright. Unless you have a "free software" licence.
 */
package plugin.convention

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get
import plugin.convention.companion.DefaultConfigs.EXCLUDED_RESOURCES
import plugin.convention.companion.kotlinCompile
import plugin.convention.companion.versionCatalog
import plugin.convention.companion.withKotlinMultiplatformExtension
import plugin.convention.companion.withLibraryExtension
import plugin.convention.companion.withPluginManager

class LibraryConventionV1 : Plugin<Project> {
    override fun apply(project: Project) =
        with(project) {
            val libs = versionCatalog

            withPluginManager {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.multiplatform")
            }

            kotlinCompile {
                kotlinOptions {
                    freeCompilerArgs += listOf("-Xskip-prerelease-check")
                }
            }

            withKotlinMultiplatformExtension {
                jvm("desktop")

                androidTarget {
                    compilations.all {
                        kotlinOptions {
                            jvmTarget = "17"
                        }
                    }
                }
                sourceSets.all {
                    languageSettings.enableLanguageFeature("ExplicitBackingFields")
                }
                
                sourceSets.commonMain {
                    kotlin.srcDir("common")
                    resources.srcDirs("common/res")
                }
                sourceSets.commonTest {
                    kotlin.srcDirs("commonTest")
                }
                sourceSets.androidMain {
                    kotlin.srcDir("android")
                }
                sourceSets.androidUnitTest {
                    kotlin.srcDir("androidUnitTest")
                }
                sourceSets.iosMain {
                    kotlin.srcDir("ios")
                }
                sourceSets.iosTest {
                    kotlin.srcDirs("iosTest")
                }

                sourceSets.commonTest.dependencies {
                    implementation(libs.findLibrary("kotlin-test").get())
                    implementation(libs.findLibrary("junit").get())
                }
                sourceSets.androidNativeTest.dependencies {
                    implementation(libs.findLibrary("androidx-test-junit").get())
                    implementation(libs.findLibrary("androidx-espresso-core").get())
                }
            }

            withLibraryExtension {
                compileSdk =
                    libs
                        .findVersion("android-compileSdk")
                        .get()
                        .toString()
                        .toInt()

                sourceSets["main"].manifest.srcFile("android/AndroidManifest.xml")
                sourceSets["main"].res.srcDirs("android/res")
                sourceSets["main"].resources.srcDirs("common/res")

                defaultConfig {
                    minSdk =
                        libs
                            .findVersion("android-minSdk")
                            .get()
                            .toString()
                            .toInt()
                    targetSdk =
                        libs
                            .findVersion("android-targetSdk")
                            .get()
                            .toString()
                            .toInt()
                }
                packaging {
                    resources {
                        excludes += EXCLUDED_RESOURCES
                    }
                }
                buildTypes {
                    getByName("release") {
                        isMinifyEnabled = false
                    }
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
            }
        }
}
