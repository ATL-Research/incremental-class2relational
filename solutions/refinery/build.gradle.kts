plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/ATL-Research/*")
        credentials {
            username = project.findProperty("gpr.user").toString() ?: System.getenv("GITHUB_ACTOR")
            password = project.findProperty("gpr.token").toString() ?: System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation("tools.refinery:refinery-store:0.1.6")
    implementation("tools.refinery:refinery-store-query:0.1.6")
    implementation("tools.refinery:refinery-store-dse:0.1.6")
    implementation("tools.refinery:refinery-store-query-interpreter:0.1.6")
    implementation("tools.refinery:refinery-logic:0.1.6")

    implementation("org.eclipse.xtext:org.eclipse.xtext.xbase:2.38.0")

    implementation("io.github.atlresearch.ttc2023:solutiondriver:0.5")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks {
    register<JavaExec>("runClass2Relational"){
        val mainRuntimeClasspath = sourceSets.main.map { it.runtimeClasspath }
        dependsOn(mainRuntimeClasspath)
        classpath(mainRuntimeClasspath)
        mainClass.set("c2r.refinery.C2RRefineryMain")
        standardInput = System.`in`
        group = "domain"
        description = "Execute model transformation from Class domain to Relational domain."
    }
}