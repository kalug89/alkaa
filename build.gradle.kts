buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(Deps.gradle.buildGradle)
        classpath(Deps.gradle.kotlinGradle)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean") {
    delete(rootProject.buildDir)
}
