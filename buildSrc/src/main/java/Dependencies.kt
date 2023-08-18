object Versions {
    const val ANDROID_COMPILE_SDK_VERSION = 33
    const val ANDROID_MIN_SDK_VERSION = 24
    const val ANDROID_TARGET_SDK_VERSION = 33

    const val ANDROID_VERSION_CODE = 1
    const val ANDROID_VERSION_NAME = "1.0.0"

    const val ANDROIDX_ACTIVITY_COMPOSE = "1.7.1"

    const val BUILD_KONFIG = "0.13.3"

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
    const val KTOR = "2.3.3"

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

    object Ktor {
        const val CORE = "io.ktor:ktor-client-core:${Versions.KTOR}"
        const val SERIALIZATION = "io.ktor:ktor-client-serialization:${Versions.KTOR}"
        const val LOGGING = "io.ktor:ktor-client-logging:${Versions.KTOR}"
        const val CIO = "io.ktor:ktor-client-cio:${Versions.KTOR}"
        const val CONTENT_NEGOTIATION = "io.ktor:ktor-client-content-negotiation:${Versions.KTOR}"
        const val JSON = "io.ktor:ktor-serialization-kotlinx-json:${Versions.KTOR}"
        const val AUTH = "io.ktor:ktor-client-auth:${Versions.KTOR}"
        const val ANDROID = "io.ktor:ktor-client-android:${Versions.KTOR}"
        const val IOS = "io.ktor:ktor-client-ios:${Versions.KTOR}"
    }

    object Log {
        const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    }

    // BuildKonfig
    const val KOTLIN_GRADLE_PLUGIN =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val BUILD_KONFIG =
        "com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:${Versions.BUILD_KONFIG}"

    object Test {
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.KOTLIN_COROUTINES}"

        const val JUNIT = "junit:junit:${Versions.JUNIT}"
    }
}
