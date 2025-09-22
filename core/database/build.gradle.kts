plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
}

apply {
    from("$rootDir/base-module.gradle")
}

android {
    namespace = "com.technonext.database"

}

dependencies {
    ksp(libs.room.compiler)
    implementation(libs.room.coroutine)
    implementation(libs.room.runtime)
}