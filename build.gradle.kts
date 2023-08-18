plugins {
    //trick: for the same plugin versions in all sub-modules
    id(Plugins.ANDROID_APPLICATION).version(Versions.ANDROID_APPLICATION).apply(false)
    id(Plugins.ANDROID_LIBRARY).version(Versions.ANDROID_LIBRARY).apply(false)
    kotlin(Plugins.ANDROID).version(Versions.KOTLIN).apply(false)
    kotlin(Plugins.MULTIPLATFORM).version(Versions.KOTLIN).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
