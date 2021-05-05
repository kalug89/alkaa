plugins{
    id("gradle.android-library")
    id("gradle.android-compose")
    id("kotlin-parcelize")
}

dependencies {
    implementation(project(":features:category-api"))
    implementation(project(":libraries:core"))
    implementation(project(":domain"))
    implementation(project(":libraries:designsystem"))

    testImplementation(project(":libraries:test"))
    androidTestImplementation(project(":libraries:test"))

    implementation(Deps.android.playCore)

    implementation(Deps.koin.android)
    implementation(Deps.koin.compose)

    testImplementation(Deps.test.coreKtx)
    androidTestImplementation(Deps.compose.activity)
    androidTestImplementation(Deps.test.barista)
}
