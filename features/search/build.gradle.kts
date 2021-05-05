plugins{
    id("gradle.android-library")
    id("gradle.android-compose")
}

dependencies {
    implementation(project(":libraries:core"))
    implementation(project(":domain"))
    implementation(project(":libraries:designsystem"))

    implementation(Deps.koin.android)
    implementation(Deps.koin.compose)

    testImplementation(project(":libraries:test"))
    androidTestImplementation(project(":libraries:test"))
}
