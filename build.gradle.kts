plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

version = "0.0.1-beta-SNAPSHOT"

allprojects {
    group = "com.hirrao"
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

subprojects {
    apply {
        plugin("java")
        plugin("application")
        plugin("com.github.johnrengelman.shadow")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}
