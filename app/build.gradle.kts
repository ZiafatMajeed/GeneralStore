plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.ziafat_majeed.generalstore"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ziafat_majeed.generalstore"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures{
        viewBinding = true
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation (libs.picasso)
    /**
     * Retrofit 2.0 for Async HTTPs Requests
     */
    implementation (libs.gson)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.converter.scalars)
    implementation (libs.logging.interceptor)
    implementation (libs.jackson.databind)

    //room sql database for persistence
    implementation (libs.room.runtime)
    annotationProcessor (libs.room.compiler)


}