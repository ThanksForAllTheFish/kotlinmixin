import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.3.11"
	kotlin("jvm") version kotlinVersion
	java
	id("org.springframework.boot") version "2.1.1.RELEASE"
	id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
	id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion
}

apply(plugin = "io.spring.dependency-management")

repositories {
	jcenter()
}

dependencies {
	implementation(kotlin("stdlib"))
	implementation(kotlin("reflect"))

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.hsqldb:hsqldb")
	testImplementation("org.junit.jupiter:junit-jupiter-api")
	testImplementation("org.junit.jupiter:junit-jupiter-engine")
	testImplementation("org.junit.jupiter:junit-jupiter-params")
}

group = "org.t4atf.kotlinmixin"
version = "0.0.1-SNAPSHOT"

tasks {
	withType(KotlinCompile::class.java).all {
		kotlinOptions {
			jvmTarget = "1.8"
			freeCompilerArgs = listOf("-Xjsr305=strict")
		}
	}
}