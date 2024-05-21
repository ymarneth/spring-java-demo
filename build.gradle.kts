import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    id("org.springframework.boot") version "3.2.5" apply false
    id("io.spring.dependency-management") version "1.1.4"
    id("org.asciidoctor.jvm.convert") version "3.3.2"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

group = "at.risc.spring-java-demo"

setJavaVersion()
configureRepositories()
configureJavaTest()

fun setJavaVersion() = configure(allprojects) {
    val javaVersion = "21"
    tasks.withType<JavaCompile> {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
}

fun configureRepositories() = configure(allprojects) {
    repositories {
        mavenCentral()
    }
}

fun configureJavaTest() {
    subprojects.forEach { project ->
        project.afterEvaluate {
            if (!project.plugins.hasPlugin(JavaPlugin::class.java)) {
                return@afterEvaluate
            }
            project.tasks.withType<Test> {
                useJUnitPlatform()
            }
        }
    }
}
