plugins{
    id("gradle.android-library")
    id("gradle.android-compose")
}

dependencies {
    implementation(Deps.koin.android)
    implementation(Deps.compose.viewModel)
}
