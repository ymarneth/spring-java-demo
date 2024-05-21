plugins {
	idea
	jacoco
	id("org.springframework.boot")
	id("io.spring.dependency-management")
    id("org.asciidoctor.jvm.convert")
	kotlin("jvm")
	kotlin("plugin.spring")
}

group = "at.risc.ci-templates-demo"
version = "0.0.1-SNAPSHOT"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")
    testRuntimeOnly("com.h2database:h2")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    testImplementation("com.ninja-squad:springmockk:4.0.2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework:spring-web")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
