application {
    mainClass.set("com.hirrao.socketserver.main.Main")
    mainModule.set("com.hirrao.socketserver")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
}

tasks.jar {
    dependsOn("shadowJar")
    enabled = false
}

tasks.shadowJar {
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
    archiveFileName.set("SocketServer-${version}.jar")
}

