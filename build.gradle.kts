plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.hirrao"
version = "0.0.1-beta-SNAPSHOT"

repositories {
    mavenCentral()
}

java{
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21

}

application {
    mainClass.set("com.hirrao.socketclient.main.Main")
    mainModule.set("com.hirrao.socketclient")
}

dependencies {
    testImplementation ("org.junit.jupiter:junit-jupiter:5.9.1")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("org.apache.logging.log4j:log4j-api:2.22.0")
    implementation ("org.apache.logging.log4j:log4j-core:2.22.0")
    implementation ("commons-cli:commons-cli:1.6.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar{
    dependsOn("shadowJar")
    enabled = false
}

tasks.shadowJar{
    mergeServiceFiles()
    manifest {
        attributes(
            "Manifest-Version" to "1.0",
            "Main-Class" to "${application.mainClass}",
            "Created-By" to "${java.sourceCompatibility} and gradle ${gradle.gradleVersion}",
            "Built-By" to "hirrao",
            "Implementation-Version" to "${version}"
        )
    }
    archiveFileName.set("SocketClient-${version}.jar")
}
