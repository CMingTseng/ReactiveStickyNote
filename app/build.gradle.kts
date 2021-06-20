plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdkVersion(Version.Android.compileSdk)
    buildToolsVersion(Version.Android.buildTool)

    defaultConfig {
        applicationId = "com.yanbin.reactivestickynote"
        minSdkVersion(Version.Android.minSdk)
        targetSdkVersion(Version.Android.targetSdk)
        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }
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
        useIR = true
    }

    buildFeatures.compose = true

    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose
        kotlinCompilerVersion = Version.kotlin
    }
}

dependencies {
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.material)
    // Compose
    implementation(Dependencies.Android.composeUI)
    implementation(Dependencies.Android.composeMaterial)
    implementation(Dependencies.Android.composeUITooling)
    implementation(Dependencies.Android.rxJava3)
    implementation(Dependencies.Android.navigation)
    // Koin
    implementation(Dependencies.Koin.android)
    // RxJava
    implementation(Dependencies.RxJava.rxJava)
    implementation(Dependencies.RxJava.rxAndroid)
    implementation(Dependencies.RxJava.rxKotlin)

    implementation(Dependencies.Android.lifecycleKts)
    implementation(Dependencies.Android.composeActivity)
}