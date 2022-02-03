import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm") version "1.6.10"
    application
}

group = "me.ema"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("libs/MyRGB.jar"))

    testImplementation("junit:junit:4.13.2")
    testImplementation(kotlin("test-junit"))
}

application {
    mainClass.set("MainKt")
}

tasks.withType<Test> {
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events("passed", "failed", "skipped")
    }
}
