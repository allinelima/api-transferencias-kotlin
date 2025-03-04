plugins {
    kotlin("jvm") version "1.8.10" // Versão do Kotlin
    id("org.springframework.boot") version "2.7.5" // Versão do Spring Boot
    id("io.spring.dependency-management") version "1.0.14.RELEASE"
    kotlin("plugin.spring") version "1.8.10"
}

group = "com.example" // Defina seu grupo, normalmente o domínio invertido
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral() // Repositório Maven central
}

dependencies {
    // Kotlin
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    // Spring Boot
    implementation("org.springframework.boot:spring-boot-starter-web") // Para criar APIs REST
    implementation("org.springframework.boot:spring-boot-starter-data-jpa") // Para integração com banco de dados (H2)
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf") // Se usar templates, por exemplo

    // Banco de dados H2 em memória
    runtimeOnly("com.h2database:h2")

    // Testes
    testImplementation("org.springframework.boot:spring-boot-starter-test") // Para realizar testes unitários
    testImplementation("org.junit.jupiter:junit-jupiter-api") // Dependência para JUnit
    testImplementation("org.junit.jupiter:junit-jupiter-engine")

    // Dependências adicionais conforme necessidade (Swagger, etc)
}

tasks.withType<Test> {
    useJUnitPlatform() // Configura JUnit 5
}
