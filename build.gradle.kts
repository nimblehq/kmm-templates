plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.0.2").apply(false)
    id("com.android.library").version("8.0.2").apply(false)
    id("io.gitlab.arturbosch.detekt").version("1.23.0")
    kotlin("android").version("1.8.21").apply(false)
    kotlin("multiplatform").version("1.8.21").apply(false)
}

detekt {
    toolVersion = "1.23.0"
    config.setFrom("detekt.yml")

    source.setFrom(
        "android/src/main/java",
        "shared/src/androidMain/kotlin",
        "shared/src/androidUnitTest/kotlin",
        "shared/src/commonMain/kotlin",
        "shared/src/commonTest/kotlin",
    )
    parallel = false

    buildUponDefaultConfig = false
    disableDefaultRuleSets = false

    debug = false
    ignoreFailures = false

}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.0")
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    jvmTarget = JavaVersion.VERSION_11.toString()
    reports {
        xml {
            outputLocation.set(file("build/reports/detekt/detekt.xml"))
        }
        html {
            outputLocation.set(file("build/reports/detekt/detekt.html"))
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
