plugins {
    id("gradle.android-library")
    id("kotlin-kapt")
}

android {
    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.schemaLocation"] = "$projectDir/schemas"
                arguments["room.incremental"] = "true"
            }
        }
    }
    sourceSets {
        getByName("androidTest").assets.srcDirs("$projectDir/schemas")
    }
}

dependencies {
    implementation(project(":libraries:core"))
    implementation(project(":data:repository"))

    implementation(Deps.koin.android)
    implementation(Deps.android.room.runtime)
    implementation(Deps.android.room.ktx)
    kapt(Deps.android.room.compiler)

    androidTestImplementation(Deps.test.runner)
    androidTestImplementation(Deps.test.room)

    testImplementation(Deps.test.junit)
    testImplementation(Deps.test.mockk)
    testImplementation(Deps.coroutines.test)
}
