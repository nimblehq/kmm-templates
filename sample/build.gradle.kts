plugins {
    //trick: for the same plugin versions in all sub-modules
    id(Plugins.ANDROID_APPLICATION) version Versions.GRADLE apply (false)
    id(Plugins.ANDROID_LIBRARY) version Versions.GRADLE apply (false)
    id(Plugins.DETEKT) version Versions.DETEKT
    id(Plugins.KOVER) version Versions.KOVER
    kotlin(Plugins.ANDROID) version Versions.KOTLIN apply (false)
    kotlin(Plugins.MULTIPLATFORM) version Versions.KOTLIN apply (false)
}

detekt {
    toolVersion = Versions.DETEKT
    config.setFrom("detekt.yml")

    source.setFrom(
        "android/src",
        "shared/src"
    )
    parallel = false

    buildUponDefaultConfig = false
    disableDefaultRuleSets = false

    debug = false
    ignoreFailures = false
    ignoredBuildTypes = listOf("release")
    ignoredFlavors = listOf("production")
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
