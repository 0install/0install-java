import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.31"
}

group = "net.zeroinstall"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("junit:junit:4.12")
//    testImplementation("org.junit.jupiter:junit-jupiter:5.5.0")
}

//tasks.test {
//    useJUnitPlatform()
//    testLogging {
//        events("passed", "skipped", "failed")
//    }
//}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
