plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.hibernate:hibernate-gradle-plugin:5.6.15.Final")
    implementation("mysql:mysql-connector-java:8.0.28")
    implementation("io.freefair.gradle:lombok-plugin:8.4")
}

tasks.test {
    useJUnitPlatform()
}