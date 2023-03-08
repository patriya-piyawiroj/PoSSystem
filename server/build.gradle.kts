plugins {
    application
    kotlin("jvm")
    id("org.jetbrains.kotlinx.kover") version "0.4.2"
}

application {
    mainClass.set("payment.server.PaymentServerKt")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

dependencies {
    // gRPC
    implementation(project(":stub"))
    runtimeOnly("io.grpc:grpc-netty:${rootProject.ext["grpcVersion"]}")

    // Postgres
    implementation("org.postgresql:postgresql:42.3.1")
    implementation("com.zaxxer:HikariCP:5.0.0")

    // Testing
    testImplementation(kotlin("test-junit"))
    testImplementation("io.grpc:grpc-testing:${rootProject.ext["grpcVersion"]}")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")

    // Config
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.11.2")

    // Logging
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.11")
    implementation("ch.qos.logback:logback-classic:1.2.6")
}

tasks.register<JavaExec>("PaymentServer") {
    dependsOn("classes")
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("payment.server.PaymentServerKt")
}

val paymentServerStartScripts = tasks.register<CreateStartScripts>("paymentServerStartScripts") {
    mainClass.set("payment.server.PaymentsServerKt")
    applicationName = "pricing-server"
    outputDir = tasks.named<CreateStartScripts>("startScripts").get().outputDir
    classpath = tasks.named<CreateStartScripts>("startScripts").get().classpath
}

tasks.named("startScripts") {
    dependsOn(paymentServerStartScripts)
}

tasks.withType<Test> {
    useJUnit()

    testLogging {
        events = setOf(org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED, org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED, org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED)
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        showStandardStreams = true
    }
}