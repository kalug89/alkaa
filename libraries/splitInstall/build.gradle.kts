plugins{
    id("gradle.android-library")
}

dependencies {
    implementation(project(":libraries:core"))

    implementation(Deps.android.constraintLayout)
    implementation(Deps.android.playCore)
}
