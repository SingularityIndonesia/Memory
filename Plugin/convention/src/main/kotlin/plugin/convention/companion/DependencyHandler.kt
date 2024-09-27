package plugin.convention.companion

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

val ksp: DependencyHandler.(Any) -> Unit =
    { dependencyNotation ->
        add("ksp", dependencyNotation)
    }

val debugImplementation: DependencyHandler.(Any) -> Unit =
    { dependencyNotation ->
        add("debugImplementation", dependencyNotation)
    }

val devDebugImplementation: DependencyHandler.(Any) -> Unit =
    { dependencyNotation ->
        add("devDebugImplementation", dependencyNotation)
    }

val stagingDebugImplementation: DependencyHandler.(Any) -> Unit =
    { dependencyNotation ->
        add("stagingDebugImplementation", dependencyNotation)
    }

val prodDebugImplementation: DependencyHandler.(Any) -> Unit =
    { dependencyNotation ->
        add("prodDebugImplementation", dependencyNotation)
    }

val releaseImplementation: DependencyHandler.(Any) -> Unit =
    { dependencyNotation ->
        add("releaseImplementation", dependencyNotation)
    }

val devReleaseImplementation: DependencyHandler.(Any) -> Unit =
    { dependencyNotation ->
        add("devReleaseImplementation", dependencyNotation)
    }

val stagingReleaseImplementation: DependencyHandler.(Any) -> Unit =
    { dependencyNotation ->
        add("stagingReleaseImplementation", dependencyNotation)
    }

val prodReleaseImplementation: DependencyHandler.(Any) -> Unit =
    { dependencyNotation ->
        add("prodReleaseImplementation", dependencyNotation)
    }

val androidTestImplementation: DependencyHandler.(Any) -> Unit =
    { dependencyNotation ->
        add("androidTestImplementation", dependencyNotation)
    }

val debugAllImplementation: DependencyHandler.(Any) -> Unit =
    { pkg ->
        listOf(
            debugImplementation,
            devDebugImplementation,
            stagingDebugImplementation,
            prodDebugImplementation,
        ).forEach {
            it(pkg)
        }
    }

val releaseAllImplementation: DependencyHandler.(Any) -> Unit =
    { pkg ->
        listOf(
            releaseImplementation,
            devReleaseImplementation,
            stagingReleaseImplementation,
            prodReleaseImplementation,
        ).forEach {
            it(pkg)
        }
    }

// short hands
fun KotlinDependencyHandler.System(pkgName: String) {
    implementation("system:$pkgName")
}

fun KotlinDependencyHandler.Shared(pkgName: String) {
    implementation("shared:$pkgName")
}

/**
 * Import data module from project neighbor.
 */
fun KotlinDependencyHandler.data(pkgName: String) {
    if (project.name == "data") throw Error("Data cannot depends on another data")
    implementation(project(":$pkgName:data"))
}

/**
 * Import model module from project neighbor.
 */
fun KotlinDependencyHandler.model(pkgName: String) {
    if (project.name == "model") throw Error("Model cannot depends on another model")
    implementation(project(":$pkgName:model"))
}

/**
 * Import presentation module from project neighbor.
 */
fun KotlinDependencyHandler.presentation(pkgName: String) {
    if (project.name == "presentation") throw Error("Presentation cannot depends on another presentation")
    if (project.name == "model") throw Error("Model cannot depends on presentation")
    if (project.name == "data") throw Error("Data cannot depends on presentation")
    implementation(project(":$pkgName:presentation"))
}
