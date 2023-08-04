import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    id("com.android.application")
    kotlin("android")
}

val keystoreProperties = loadProperties("android/signing.properties")

android {
    namespace = "co.nimblehq.kmm.template.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "co.nimblehq.kmm.template.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    signingConfigs {
        create("release") {
            storePassword = keystoreProperties.getProperty("KEYSTORE_PASSWORD")
            // Remember to edit signing.properties to have the correct info for release build.
            storeFile = file("config/release.keystore")
            keyPassword = keystoreProperties.getProperty("KEY_PASSWORD")
            keyAlias = keystoreProperties.getProperty("KEY_ALIAS")
        }

        getByName("debug") {
            storeFile = file("config/debug.keystore")
            storePassword = "jsglOe09kgjslDgpEg"
            keyAlias = "kmm-templates"
            keyPassword = "jsglOe09kgjslDgpEg"
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            signingConfig = signingConfigs["release"]
        }

        getByName("debug") {
            isMinifyEnabled = false
            signingConfig = signingConfigs["debug"]
        }
    }
    flavorDimensions += "version"
    productFlavors {
        create("staging") {
            applicationIdSuffix = ".staging"
        }

        create("production") {}
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.ui:ui-tooling:1.4.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation("androidx.compose.material:material:1.4.3")
    implementation("androidx.activity:activity-compose:1.7.1")
}
