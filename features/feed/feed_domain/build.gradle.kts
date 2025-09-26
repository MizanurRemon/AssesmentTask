plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")

}

apply {
    from("$rootDir/base-module.gradle")
}

android {
    namespace = "com.technonext.feed_domain"

}

dependencies {
    implementation(project(Modules.COMMON))
    implementation(project(Modules.NETWORK))

}