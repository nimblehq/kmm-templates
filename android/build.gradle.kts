plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.ANDROID)
}

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
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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
