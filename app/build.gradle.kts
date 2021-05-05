import extension.addCompose

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

apply {
    from("$rootDir/config/artifacts.gradle")
}

android {
    defaultConfig {
        applicationId = "com.escodro.alkaa"
        versionCode = Releases.versionCode
        versionName = Releases.versionName
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    lint {
        isWarningsAsErrors = true
        isAbortOnError = false // Google needs to update their libraries to API Level 10.
        htmlReport = true
        isCheckDependencies = true

        lintConfig = file("${rootDir}/config/filters/lint.xml")
        htmlOutput = file("${buildDir}/reports/lint.html")
    }

    kapt {
        javacOptions {
            option("-Xmaxerrs", 1000)
            option("-Werror")
        }
    }

    setDynamicFeatures(setOf(":features:tracker"))

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packagingOptions {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

    build

    addCompose()

}

dependencies {
    implementation(project(":libraries:core"))
    implementation(project(":libraries:splitInstall"))
    implementation(project(":libraries:designsystem"))
    implementation(project(":libraries:navigation"))
    implementation(project(":data:local"))
    implementation(project(":data:repository"))
    implementation(project(":domain"))
    implementation(project(":features:task"))
    implementation(project(":features:alarm"))
    implementation(project(":features:category-api"))
    implementation(project(":features:category"))
    implementation(project(":features:preference"))
    implementation(project(":features:search"))

    implementation(Deps.compose.navigation)
    implementation(Deps.compose.activity)
    implementation(Deps.android.playCore)
    implementation(Deps.koin.android)
}
