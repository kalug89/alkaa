plugins{
    id("gradle.android-library")
    id("gradle.android-compose")
}

dependencies {
    implementation(project(":libraries:core"))
    implementation(project(":libraries:designsystem"))

    testImplementation(project(":libraries:test"))
    androidTestImplementation(project(":libraries:test"))
}
