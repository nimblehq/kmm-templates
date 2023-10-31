import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    kotlin(Plugins.MULTIPLATFORM)
    kotlin(Plugins.IOS_COCOAPODS)
    kotlin(Plugins.KOTLIN_SERIALIZATION)
    id(Plugins.KOTLINX_SERIALIZATION)
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOVER)
    id(Plugins.KSP)
    id(Plugins.BUILD_KONFIG)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_17.toString()
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
                implementation(Dependencies.Koin.CORE)

                with(Dependencies.Ktor) {
                    implementation(CORE)
                    implementation(SERIALIZATION)
                    implementation(LOGGING)
                    implementation(CIO)
                    implementation(CONTENT_NEGOTIATION)
                    implementation(JSON)
                    implementation(AUTH)
                }

                implementation(Dependencies.Log.NAPIER)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                with(Dependencies.Test) {
                    implementation(COROUTINES)
                    implementation(KOTEST)
                    implementation(KOTLINX_RESOURCES)
                    implementation(MOCKATIVE)
                    implementation(TURBINE)
                }
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(Dependencies.Ktor.ANDROID)
            }
        }
        val androidUnitTest by getting

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(Dependencies.Ktor.IOS)
            }
        }
        val iosTest by getting
    }
}

// https://github.com/mockative/mockative#installation-for-multiplatform-projects
dependencies {
    configurations
        .filter { it.name.startsWith("ksp") && it.name.contains("Test") }
        .forEach {
            add(it.name, Dependencies.Test.MOCKATIVE_PROCESSOR)
        }
}

// https://github.com/mockative/mockative#implicit-stubbing-of-functions-returning-unit
ksp {
    arg("mockative.stubsUnitByDefault", "true")
}

android {
    namespace = "co.nimblehq.kmm.template"
    compileSdk = Versions.ANDROID_COMPILE_SDK
    defaultConfig {
        minSdk = Versions.ANDROID_MIN_SDK
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

val buildKonfigProperties = loadProperties("$rootDir/buildKonfig.properties")
buildkonfig {
    packageName = "co.nimblehq.kmm.template"

    // Default for Flavors.STAGING
    defaultConfigs {
        buildConfigField(
            STRING,
            "BASE_URL",
            buildKonfigProperties.getProperty("STAGING_BASE_URL")
        )
    }

    defaultConfigs(Flavors.PRODUCTION) {
        buildConfigField(
            STRING,
            "BASE_URL",
            buildKonfigProperties.getProperty("PRODUCTION_BASE_URL")
        )
    }
}
