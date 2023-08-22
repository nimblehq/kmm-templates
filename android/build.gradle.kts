import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.KOVER)
    kotlin(Plugins.ANDROID)
}

val keystoreProperties = loadProperties("signing.properties")

android {
    namespace = "co.nimblehq.kmm.template.android"
    compileSdk = Versions.ANDROID_COMPILE_SDK_VERSION
    defaultConfig {
        applicationId = "co.nimblehq.kmm.template.android"
        minSdk = Versions.ANDROID_MIN_SDK_VERSION
        targetSdk = Versions.ANDROID_TARGET_SDK_VERSION
        versionCode = Versions.ANDROID_VERSION_CODE
        versionName = Versions.ANDROID_VERSION_NAME
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    signingConfigs {
        create(BuildTypes.RELEASE) {
            // Remember to edit signing.properties to have the correct info for release build.
            storeFile = file("../config/release.keystore")
            storePassword = keystoreProperties.getProperty("KEYSTORE_PASSWORD")
            keyPassword = keystoreProperties.getProperty("KEY_PASSWORD")
            keyAlias = keystoreProperties.getProperty("KEY_ALIAS")
        }

        getByName(BuildTypes.DEBUG) {
            storeFile = file("../config/debug.keystore")
            //FIXME: Replace with your own password
            storePassword = "oQ4mL1jY2uX7wD8q"
            keyAlias = "debug-key-alias"
            keyPassword = "oQ4mL1jY2uX7wD8q"
        }
    }
    buildTypes {
        getByName(BuildTypes.RELEASE) {
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs[BuildTypes.RELEASE]
        }

        getByName(BuildTypes.DEBUG) {
            // For quickly testing build with proguard, enable this
            isMinifyEnabled = false
            signingConfig = signingConfigs[BuildTypes.DEBUG]
        }
    }
    flavorDimensions += Flavors.DIMENSION_VERSION
    productFlavors {
        create(Flavors.STAGING) {
            applicationIdSuffix = ".staging"
            resValue("string", "app_name", "KMM Templates - Staging")
        }

        create(Flavors.PRODUCTION) {
            resValue("string", "app_name", "KMM Templates")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Versions.JVM_TARGET
    }
}

dependencies {
    implementation(project(Modules.SHARED))

    with(Dependencies.AndroidX) {
        implementation(ACTIVITY_COMPOSE)
    }

    with(Dependencies.Compose) {
        implementation(UI)
        implementation(UI_GRAPHICS)
        implementation(MATERIAL)
        implementation(NAVIGATION)
        implementation(UI_TOOLING)
    }

    with(Dependencies.Log) {
        implementation(TIMBER)
    }

    with(Dependencies.Test) {
        implementation(JUNIT)
        implementation(COROUTINES)
    }
}

/*
 * Kover configs
 */
dependencies {
    kover(project(":shared"))
}

koverReport {
    defaults {
        mergeWith("stagingDebug")

        val excludedFiles = listOf(
            "io.mockative.*",
            "*.BuildConfig",
            "*.BuildKonfig",                        // BuildKonfig generated
            "*.ComposableSingletons*",              // Jetpack Compose generated
            "*.*\$*Preview\$*",                     // Jetpack Compose Preview functions
            "*.di.*",                               // Koin
            "*.ui.preview.*",                       // Jetpack Compose Preview providers
            "*.*Test",                              // Test files
            "*.*Test*",                             // Test cases
            "*.*Mock",                              // mockative @Mock generated
            "*.test.*",                             // Test util package
            "*.*\$\$serializer",                    // Kotlinx serializer
        )

        filters {
            excludes {
                classes(excludedFiles)
            }
        }
    }
}
