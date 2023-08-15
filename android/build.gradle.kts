plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.ANDROID)
}

val keystoreProperties =  rootDir.loadGradleProperties("android/signing.properties")

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
    signingConfigs {
        create(BuildTypes.RELEASE) {
            storePassword = keystoreProperties.getProperty("KEYSTORE_PASSWORD")
            // Remember to edit signing.properties to have the correct info for release build.
            storeFile = file("config/release.keystore")
            keyPassword = keystoreProperties.getProperty("KEY_PASSWORD")
            keyAlias = keystoreProperties.getProperty("KEY_ALIAS")
        }

        getByName(BuildTypes.DEBUG) {
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
        kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName(BuildTypes.RELEASE) {
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            signingConfig = signingConfigs[BuildTypes.RELEASE]
        }

        getByName(BuildTypes.DEBUG) {
            isMinifyEnabled = false
            signingConfig = signingConfigs[BuildTypes.DEBUG]
        }
    }
    flavorDimensions += Flavors.DIMENSION_VERSION
    productFlavors {
        create(Flavors.STAGING) {
            applicationIdSuffix = ".staging"
        }

        create(Flavors.PRODUCTION) {}
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

    with(Dependencies.Compose) {
        implementation(UI)
        implementation(UI_TOOLING)
        implementation(UI_TOOLING_PREVIEW)
        implementation(FOUNDATION)
        implementation(MATERIAL)
    }

    with(Dependencies.Koin) {
        implementation(CORE)
        implementation(ANDROID)
        implementation(COMPOSE)
    }

    implementation(Dependencies.AndroidX.ACTIVITY_COMPOSE)
}
