object Dependencies {

    object AndroidX {
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ANDROIDX_ACTIVITY_COMPOSE}"
    }

    object Compose {
        const val FOUNDATION = "androidx.compose.foundation:foundation:${Versions.COMPOSE}"

        const val MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"

        const val NAVIGATION = "androidx.navigation:navigation-compose:${Versions.COMPOSE_NAVIGATION}"

        const val UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
        const val UI_GRAPHICS = "androidx.compose.ui:ui-graphics:${Versions.COMPOSE}"
        const val UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
        const val UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
    }

    object Koin {
        const val CORE = "io.insert-koin:koin-core:${Versions.KOIN}"
        const val ANDROID = "io.insert-koin:koin-android:${Versions.KOIN_ANDROID}"
        const val COMPOSE = "io.insert-koin:koin-androidx-compose:${Versions.KOIN_ANDROIDX_COMPOSE}"
    }

    object Ktor {
        const val ANDROID = "io.ktor:ktor-client-android:${Versions.KTOR}"
        const val AUTH = "io.ktor:ktor-client-auth:${Versions.KTOR}"

        const val CIO = "io.ktor:ktor-client-cio:${Versions.KTOR}"
        const val CORE = "io.ktor:ktor-client-core:${Versions.KTOR}"
        const val CONTENT_NEGOTIATION = "io.ktor:ktor-client-content-negotiation:${Versions.KTOR}"

        const val IOS = "io.ktor:ktor-client-ios:${Versions.KTOR}"

        const val JSON = "io.ktor:ktor-serialization-kotlinx-json:${Versions.KTOR}"

        const val LOGGING = "io.ktor:ktor-client-logging:${Versions.KTOR}"

        const val SERIALIZATION = "io.ktor:ktor-client-serialization:${Versions.KTOR}"
    }

    object Log {
        const val NAPIER = "io.github.aakira:napier:${Versions.NAPIER}"
        const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    }

    object Test {
        const val COMPOSE_UI_TEST_JUNIT = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
        const val COMPOSE_UI_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest:${Versions.COMPOSE}"
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.KOTLIN_COROUTINES}"

        const val JUNIT = "junit:junit:${Versions.JUNIT}"

        const val KOTEST = "io.kotest:kotest-assertions-core:${Versions.KOTEST}"
        const val KOTLINX_RESOURCES = "com.goncalossilva:resources:${Versions.KOTLINX_RESOURCES}"

        const val MOCKATIVE = "io.mockative:mockative:${Versions.MOCKATIVE}"
        const val MOCKATIVE_PROCESSOR = "io.mockative:mockative-processor:${Versions.MOCKATIVE}"
        const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
        const val MOCKK_ANDROID = "io.mockk:mockk-android:${Versions.MOCKK}"

        const val ROBOLECTRIC = "org.robolectric:robolectric:${Versions.ROBOLECTRIC}"

        const val TURBINE = "app.cash.turbine:turbine:${Versions.TURBINE}"
    }
}
