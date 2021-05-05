plugins {
    id("gradle.android-library")
    id("kotlin-parcelize")
}

dependencies {
    implementation(Deps.coroutines.core)
    implementation(Deps.koin.android)
}
