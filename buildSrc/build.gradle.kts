plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.0.0-alpha14")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.31")

    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.13.1")

}
