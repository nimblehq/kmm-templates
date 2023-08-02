plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.0.2").apply(false)
    id("com.android.library").version("8.0.2").apply(false)
    id("io.gitlab.arturbosch.detekt").version("1.23.0")
    id("org.jetbrains.kotlinx.kover").version("0.7.3")
    kotlin("android").version("1.8.21").apply(false)
    kotlin("multiplatform").version("1.8.21").apply(false)
}

detekt {
    toolVersion = "1.23.0"
    config.setFrom("detekt.yml")

    source.setFrom(
        "android/src",
        "shared/src/androidMain/kotlin",
        "shared/src/androidUnitTest/kotlin",
        "shared/src/commonMain/kotlin",
        "shared/src/commonTest/kotlin",
        "shared/src/iosMain/kotlin",
    )
    parallel = false

    buildUponDefaultConfig = false
    disableDefaultRuleSets = false

    debug = false
    ignoreFailures = false
    ignoredBuildTypes = listOf("release")
    ignoredFlavors = listOf("production")
}

koverReport {
    val excludedFiles = listOf(
        "*.BuildConfig.*",
        "*.BuildConfig",
        // Jetpack Compose
        "*.ComposableSingletons*",
        "*.*\$*Preview\$*",
        "*.ui.preview.*",
    )

    filters {
        excludes {
            classes(excludedFiles)
        }
    }
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    jvmTarget = JavaVersion.VERSION_11.toString()
    reports {
        html.required.set(true)
        xml.required.set(true)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
