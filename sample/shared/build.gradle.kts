import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType

plugins {
    kotlin(Plugins.MULTIPLATFORM)
    kotlin(Plugins.IOS_COCOAPODS)
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOVER)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = Versions.JVM_TARGET
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.0"
        podfile = project.file("../ios/Podfile")
        framework {
            baseName = "shared"
        }

        xcodeConfigurationToNativeBuildType["Debug Staging"] = NativeBuildType.DEBUG
        xcodeConfigurationToNativeBuildType["Debug Production"] = NativeBuildType.DEBUG
        xcodeConfigurationToNativeBuildType["Release Staging"] = NativeBuildType.RELEASE
        xcodeConfigurationToNativeBuildType["Release Production"] = NativeBuildType.RELEASE
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Koin
                implementation(Dependencies.Koin.CORE)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dependencies.Koin.ANDROID)
                implementation(Dependencies.Koin.COMPOSE)
            }
        }
    }
}

android {
    namespace = "co.nimblehq.kmm.template"
    compileSdk = Versions.ANDROID_COMPILE_SDK_VERSION
    defaultConfig {
        minSdk = Versions.ANDROID_MIN_SDK_VERSION
    }
}
