import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.Properties

// Load properties from gradle.properties
val props = Properties()
props.load(project.rootProject.file("gradle.properties").inputStream())

plugins {
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

group = "org.bonespirito"
version = props.getProperty("applicationVersion")

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

println("Spring Boot Version: ${props.getProperty("springBootVersion")}")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:${props.getProperty("springBootVersion")}")
    implementation(
        "com.fasterxml.jackson.module:jackson-module-kotlin:" +
            props.getProperty("jacksonModuleKotlinVersion"),
    )
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${props.getProperty("kotlinReflectVersion")}")
    implementation("org.json:json:${props.getProperty("jsonVersion")}")
    implementation("com.beust:klaxon:${props.getProperty("klaxonVersion")}")
    implementation("com.networknt:json-schema-validator:${props.getProperty("jsonSchemaValidatorVersion")}")

    implementation("org.springframework.boot:spring-boot-starter:${props.getProperty("springBootVersion")}")
    implementation("com.google.code.gson:gson:${props.getProperty("gsonVersion")}")
    implementation(platform("software.amazon.awssdk:bom:${props.getProperty("awsSdkVersion")}"))
    implementation("software.amazon.awssdk:dynamodb:${props.getProperty("awsSdkVersion")}")

    implementation("io.github.boostchicken:spring-data-dynamodb:${props.getProperty("springDataDynamodbVersion")}")

    developmentOnly("org.springframework.boot:spring-boot-devtools:${props.getProperty("springBootDevtoolsVersion")}")
    testImplementation(
        "org.springframework.boot:spring-boot-starter-test:" +
            props.getProperty("springBootStarterTestVersion"),
    )
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
