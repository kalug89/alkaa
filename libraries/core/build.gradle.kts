plugins{
    id("gradle.android-library")
}

dependencies {
    implementation(Deps.android.ktx)
    implementation(Deps.android.material)
    implementation(Deps.coroutines.core)
    implementation(Deps.koin.android)
}
