import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    kotlin(Plugins.MULTIPLATFORM)
    kotlin(Plugins.COCOAPODS)
    id(Plugins.BUILD_KONFIG)
    id(Plugins.ANDROID_LIBRARY)
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
                //put your multiplatform dependencies here
//                implementation(Dependencies.Ktor.CORE)
//                implementation(Dependencies.Ktor.SERIALIZATION)
//                implementation(Dependencies.Ktor.LOGGING)
//                implementation(Dependencies.Ktor.CIO)
//                implementation(Dependencies.Ktor.CONTENT_NEGOTIATION)
//                implementation(Dependencies.Ktor.JSON)
//                implementation(Dependencies.Ktor.AUTH)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
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

val buildKonfigProperties = rootDir.loadGradleProperties("buildKonfig.properties")
buildkonfig {
    packageName = "co.nimblehq.kmm.template"

    defaultConfigs {
        buildConfigField(
            STRING,
            "BASE_URL",
            buildKonfigProperties.getProperty("BASE_URL")
        )
    }

    defaultConfigs(Flavors.PRODUCTION) {
        buildConfigField(
            STRING,
            "BASE_URL",
            buildKonfigProperties.getProperty("BASE_URL")
        )
    }
}
