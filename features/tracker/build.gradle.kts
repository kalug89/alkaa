plugins {
    id("gradle.android-library")
    id("gradle.android-compose")
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":libraries:designsystem"))

    implementation(Deps.koin.android)
    implementation(Deps.coroutines.core)
    implementation(Deps.koin.compose)
    implementation(Deps.compose.activity)

    testImplementation(project(":libraries:test"))
}
