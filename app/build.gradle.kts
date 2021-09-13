plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.gms.google-services")
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
        isCoreLibraryDesugaringEnabled = true
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
    implementation(Deps.Android.coreKtx)
    implementation(Deps.Android.appCompat)
    implementation(Deps.Android.material)
    // Compose
    implementation(Deps.Android.composeUI)
    implementation(Deps.Android.composeMaterial)
    implementation(Deps.Android.composeUITooling)
    implementation(Deps.Android.rxJava3)
    implementation(Deps.Android.navigation)
    // Koin
    implementation(Deps.Koin.android)
    // RxJava
    implementation(Deps.RxJava.rxJava)
    implementation(Deps.RxJava.rxAndroid)
    implementation(Deps.RxJava.rxKotlin)
    // Firebase
    implementation(platform(Deps.Firebase.bom))
    implementation (Deps.Firebase.firestore)

    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

    implementation(Deps.Android.lifecycleKts)
    implementation(Deps.Android.composeActivity)
}