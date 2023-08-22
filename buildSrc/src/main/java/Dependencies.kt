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
    const val JVM_TARGET = "17"

    const val KOIN = "3.3.2"
    const val KOIN_ANDROID = "3.3.2"
    const val KOIN_ANDROIDX_COMPOSE = "3.4.1"
    const val KOTLIN = "1.8.21"
    const val KOTLIN_COROUTINES = "1.7.3"
    const val KOVER = "0.7.3"

    const val TIMBER = "5.0.1"

    const val KOTEST = "5.5.4"
    const val KOTLINX_RESOURCES = "0.2.4"
    const val KTOR = "2.1.1"
    const val KSP = "1.8.21-1.0.11"

    const val MULTIPLATFORM = "1.8.21"
    const val MOCKATIVE = "1.3.0"
    const val MOCKK = "1.13.3"

    const val NAPIER = "2.6.1"

    const val ROBOLECTRIC = "4.9.1"

    const val TURBINE = "0.12.1"
}

object Dependencies {
    object Gradle {
        const val GRADLE = "com.android.tools.build:gradle:${Versions.GRADLE}"
        const val BUILD_KONFIG = "com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:${Versions.BUILD_KONFIG}"
    }

    object AndroidX {
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ANDROIDX_ACTIVITY_COMPOSE}"
    }

    object Compose {
        const val UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
        const val UI_GRAPHICS = "androidx.compose.ui:ui-graphics:${Versions.COMPOSE}"
        const val UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
        const val UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
        const val FOUNDATION = "androidx.compose.foundation:foundation:${Versions.COMPOSE}"
        const val MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
        const val NAVIGATION = "androidx.navigation:navigation-compose:${Versions.COMPOSE_NAVIGATION}"
    }

    object Koin {
        const val CORE = "io.insert-koin:koin-core:${Versions.KOIN}"
        const val ANDROID = "io.insert-koin:koin-android:${Versions.KOIN_ANDROID}"
        const val COMPOSE = "io.insert-koin:koin-androidx-compose:${Versions.KOIN_ANDROIDX_COMPOSE}"
    }

    object Log {
        const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    }

    object Test {
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.KOTLIN_COROUTINES}"

        const val JUNIT = "junit:junit:${Versions.JUNIT}"

        const val COMPOSE_UI_TEST_JUNIT = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
        const val COMPOSE_UI_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest:${Versions.COMPOSE}"

        const val KOTEST_ASSERTIONS = "io.kotest:kotest-assertions-core:${Versions.KOTEST}"
        const val KOTLINX_RESOURCES = "com.goncalossilva:resources:${Versions.KOTLINX_RESOURCES}"
        const val MOCKATIVE = "io.mockative:mockative:${Versions.MOCKATIVE}"
        const val MOCKATIVE_PROCESSOR = "io.mockative:mockative-processor:${Versions.MOCKATIVE}"
        const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
        const val MOCKK_ANDROID = "io.mockk:mockk-android:${Versions.MOCKK}"

        const val ROBOLECTRIC = "org.robolectric:robolectric:${Versions.ROBOLECTRIC}"

        const val TURBINE = "app.cash.turbine:turbine:${Versions.TURBINE}"
    }

    object Kotlin {
        const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
        const val KOTLIN_SERIALIZATION = "org.jetbrains.kotlin:kotlin-serialization:${Versions.KOTLIN}"
    }

    object Logging {
        const val NAPIER = "io.github.aakira:napier:${Versions.NAPIER}"
        const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    }

    object Ktor {
        const val CORE = "io.ktor:ktor-client-core:${Versions.KTOR}"
        const val AUTH = "io.ktor:ktor-client-auth:${Versions.KTOR}"
        const val CIO = "io.ktor:ktor-client-cio:${Versions.KTOR}"
        const val CONTENT_NEGOTIATION = "io.ktor:ktor-client-content-negotiation:${Versions.KTOR}"
        const val JSON = "io.ktor:ktor-serialization-kotlinx-json:${Versions.KTOR}"
        const val LOGGING = "io.ktor:ktor-client-logging:${Versions.KTOR}"
        const val SERIALIZATION = "io.ktor:ktor-client-serialization:${Versions.KTOR}"
        const val ANDROID = "io.ktor:ktor-client-android:${Versions.KTOR}"
        const val IOS = "io.ktor:ktor-client-ios:${Versions.KTOR}"
    }
}
