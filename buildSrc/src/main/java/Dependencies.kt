object Versions {
    const val ANDROID_COMPILE_SDK_VERSION = 33
    const val ANDROID_MIN_SDK_VERSION = 24
    const val ANDROID_TARGET_SDK_VERSION = 33

    const val ANDROID_VERSION_CODE = 1
    const val ANDROID_VERSION_NAME = "1.0.0"

    const val ANDROID_APPLICATION = "8.0.2"
    const val ANDROID_LIBRARY = "8.0.2"

    const val ANDROIDX_ACTIVITY_COMPOSE = "1.7.1"

    const val COMPOSE_UI = "1.4.3"
    const val COMPOSE_COMPILER = "1.4.7"

    const val JVM_TARGET = "1.8"

    const val KOTLIN = "1.8.21"
    const val KOIN = "3.3.2"
    const val KOIN_ANDROID = "3.3.2"
    const val KOIN_ANDROIDX_COMPOSE = "3.4.1"
}

object Dependencies {
    object AndroidX {
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ANDROIDX_ACTIVITY_COMPOSE}"
    }
    object Compose {
        const val UI = "androidx.compose.ui:ui:${Versions.COMPOSE_UI}"
        const val UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE_UI}"
        const val UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE_UI}"
        const val FOUNDATION = "androidx.compose.foundation:foundation:${Versions.COMPOSE_UI}"
        const val MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE_UI}"
    }
    object Koin {
        const val CORE = "io.insert-koin:koin-core:${Versions.KOIN}"
        const val ANDROID = "io.insert-koin:koin-android:${Versions.KOIN_ANDROID}"
        const val COMPOSE = "io.insert-koin:koin-androidx-compose:${Versions.KOIN_ANDROIDX_COMPOSE}"
    }
}
