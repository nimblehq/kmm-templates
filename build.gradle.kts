buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependencies.Gradle.BUILD_KONFIG)
        classpath(Dependencies.Kotlin.KOTLIN_GRADLE_PLUGIN)
        classpath(Dependencies.Kotlin.KOTLIN_SERIALIZATION)
    }
}

plugins {
    //trick: for the same plugin versions in all sub-modules
    id(Plugins.ANDROID_APPLICATION).version(Versions.ANDROID_APPLICATION).apply(false)
    id(Plugins.ANDROID_LIBRARY).version(Versions.ANDROID_LIBRARY).apply(false)
    kotlin(Plugins.ANDROID).version(Versions.ANDROID).apply(false)
    kotlin(Plugins.MULTIPLATFORM).version(Versions.MULTIPLATFORM).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
