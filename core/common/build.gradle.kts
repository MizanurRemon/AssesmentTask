plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

apply {
    from("$rootDir/base-module.gradle")
}

android {
    namespace = "com.technonext.common"
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
}