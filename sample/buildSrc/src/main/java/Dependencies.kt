object Versions {
    const val ANDROID_COMPILE_SDK_VERSION = 33
    const val ANDROID_MIN_SDK_VERSION = 24
    const val ANDROID_TARGET_SDK_VERSION = 33

    const val ANDROID_VERSION_CODE = 1
    const val ANDROID_VERSION_NAME = "1.0.0"

    const val ANDROIDX_ACTIVITY_COMPOSE = "1.7.1"

    const val COMPOSE = "1.4.3"
    const val COMPOSE_COMPILER = "1.4.7"
    const val COMPOSE_NAVIGATION = "2.6.0"

    const val DETEKT = "1.23.0"

    const val GRADLE = "8.0.2"

    const val JUNIT = "4.13.2"
    const val JVM_TARGET = "1.8"

    const val KOTLIN = "1.8.21"
    const val KOTLIN_COROUTINES = "1.7.3"
    const val KOVER = "0.7.3"

    const val TIMBER = "5.0.1"
}

object Dependencies {
    object Gradle {
        const val GRADLE = "com.android.tools.build:gradle:${Versions.GRADLE}"
    }

    object AndroidX {
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ANDROIDX_ACTIVITY_COMPOSE}"
    }

    object Compose {
        const val UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
        const val UI_GRAPHICS = "androidx.compose.ui:ui-graphics:${Versions.COMPOSE}"
        const val UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
        const val MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
        const val NAVIGATION = "androidx.navigation:navigation-compose:${Versions.COMPOSE_NAVIGATION}"
    }

    object Log {
        const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    }

    object Test {
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.KOTLIN_COROUTINES}"

        const val JUNIT = "junit:junit:${Versions.JUNIT}"
    }
}
