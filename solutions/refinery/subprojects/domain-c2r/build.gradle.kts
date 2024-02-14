/*
 * SPDX-FileCopyrightText: 2021-2023 The Refinery Authors <https://refinery.tools/>
 *
 * SPDX-License-Identifier: EPL-2.0
 */

plugins {
	id("tools.refinery.gradle.java-library")
	id("tools.refinery.gradle.jmh")
}

repositories{
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
	api(project(":refinery-store"))
	api(project(":refinery-store-query"))
	api(project(":refinery-store-query-interpreter"))
	api(project(":refinery-store-dse"))
	api(project(":refinery-language-semantics"))
	api(project(":refinery-generator"))
	api(project(":refinery-store-dse-visualization"))
	implementation(libs.eclipseCollections.api)
	implementation("io.github.atlresearch.ttc2023:solutiondriver:0.5")
    runtimeOnly(libs.eclipseCollections)
}

tasks{
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


