plugins {
	java
	id("org.springframework.boot") version "4.0.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.company"
version = "0.0.1-SNAPSHOT"
description = "Technical test"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")//
	implementation("org.springframework.boot:spring-boot-starter-validation")//
	implementation("org.springframework.boot:spring-boot-starter-webmvc")//

	runtimeOnly("com.h2database:h2")

	developmentOnly("org.springframework.boot:spring-boot-devtools")

	testImplementation("org.springframework.boot:spring-boot-startet-test")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
