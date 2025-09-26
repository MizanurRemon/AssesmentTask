plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")

}

apply {
    from("$rootDir/base-module.gradle")
}


android {
    namespace = "com.technonext.auth_domain"

}

dependencies {
    implementation(project(Modules.COMMON))
}