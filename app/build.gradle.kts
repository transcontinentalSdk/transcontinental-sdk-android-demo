plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.tctranscontinental.android.digitalflyer.demo"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.tctranscontinental.android.digitalflyer.demo"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")

    implementation("com.github.transcontinentalSdk:sdk-android-internal:main-SNAPSHOT")

    implementation("androidx.compose.ui:ui:1.4.0")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation("androidx.compose.material:material:1.4.0")
}