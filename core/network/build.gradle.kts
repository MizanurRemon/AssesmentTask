plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    kotlin("plugin.serialization") version "1.8.10"
    id ("kotlin-parcelize")
}

apply {
    from("$rootDir/base-module.gradle")
}

android {
    namespace = "com.technonext.network"
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
//    //implementation(libs.retrofit2.kotlin.serialization.converter)
//    implementation(libs.kotlinx.serialization.json)
   // implementation(libs.datastore.preferences)
//    implementation(libs.gson)
    implementation (libs.converter.gson)
}