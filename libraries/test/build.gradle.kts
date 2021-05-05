plugins{
    id("gradle.android-library")
}

dependencies {
    implementation(project(":libraries:core"))

    api(Deps.test.junit)

    api(Deps.coroutines.test)

   implementation(Deps.compose.uiTest) {
        exclude(group = "androidx.core", module = "core-ktx")
        exclude(group = "androidx.fragment", module = "fragment")
        exclude(group = "androidx.customview", module = "customview")
        exclude(group = "androidx.activity", module = "activity")
        exclude(group = "androidx.lifecycle", module = "lifecycle-runtime")
    }

    implementation(Deps.test.core)
    implementation(Deps.test.uiAutomator)
}
