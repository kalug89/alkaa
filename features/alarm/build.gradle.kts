plugins {
    id("gradle.android-library")
}

dependencies {
    implementation(project(":libraries:core"))
    implementation (project(":libraries:navigation"))
    implementation(project(":domain"))

    implementation(Deps.coroutines.core)
    implementation(Deps.koin.android)

    testImplementation(Deps.test.junit)
    testImplementation(Deps.test.mockk)
}
