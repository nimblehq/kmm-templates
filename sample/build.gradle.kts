import org.jetbrains.kotlin.js.translate.context.Namer.kotlin

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.KOTLIN_GRADLE_PLUGIN)
        classpath(Dependencies.BUILD_KONFIG)
    }
}

plugins {
    //trick: for the same plugin versions in all sub-modules
    id(Plugins.ANDROID_APPLICATION).version(Versions.GRADLE).apply(false)
    id(Plugins.ANDROID_LIBRARY).version(Versions.GRADLE).apply(false)
    kotlin(Plugins.ANDROID).version(Versions.KOTLIN).apply(false)
    kotlin(Plugins.MULTIPLATFORM).version(Versions.KOTLIN).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
