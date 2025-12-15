plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.habit_tracker"
    // نعتبر 36 هو أحدث إصدار SDK متوفر
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.habit_tracker"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        // Test runner Espresso
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        // Kotlin 1.8+ يدعم Java 17 و Java 21، لكن 11 مقبول
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        // تفعيل دعم Compose UI
        compose = true
    }
}

dependencies {

    // 🚀 Core Android & Compose Setup
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Compose UI & Material 3
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // 🧪 Testing
    testImplementation(libs.junit) // Unit testing

    // Android Instrumentation Testing - تشمل Espresso و AndroidX Test Runner/Rules
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debugging Tools
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // 💾 Room Database
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version") // للكوروتينز

    // 🗺️ Navigation Compose
    val nav_version = "2.7.5"
    implementation("androidx.navigation:navigation-compose:$nav_version")
}