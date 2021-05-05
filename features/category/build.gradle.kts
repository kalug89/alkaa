plugins{
    id("gradle.android-library")
    id("gradle.android-compose")
    id("kotlin-parcelize")
}

dependencies {
    implementation(project(":libraries:core"))
    implementation(project(":features:category-api"))
    implementation(project(":domain"))
    implementation(project(":libraries:designsystem"))

    testImplementation(project(":libraries:test"))
    androidTestImplementation(project(":libraries:test"))

    implementation(Deps.koin.android)
    implementation(Deps.koin.compose)
}
