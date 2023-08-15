plugins {
    kotlin(Plugins.MULTIPLATFORM)
    kotlin(Plugins.COCOAPODS)
    id(Plugins.ANDROID_LIBRARY)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
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
        ios.deploymentTarget = "14.1"
        podfile = project.file("../ios/Podfile")
        framework {
            baseName = "shared"
        }
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
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}
