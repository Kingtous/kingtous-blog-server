import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.1"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.spring") version "1.4.21"
}

group = "cn.kingtous"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    maven { url = uri("http://maven.aliyun.com/nexus/content/groups/public/") }
    maven { url = uri("http://maven.aliyun.com/nexus/content/repositories/jcenter") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-devtools")
    implementation("junit:junit:4.12")
    compile("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.3")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    implementation("com.alibaba:druid-spring-boot-starter")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly ("mysql:mysql-connector-java")

    implementation("com.google.guava:guava:29.0-jre")
    implementation("com.google.code.gson:gson:2.8.5")
    implementation("com.qiniu:qiniu-java-sdk:7.4.+")
//    compile("org.springframework.boot:spring-boot-devtools")   // 热部署
//    compileOnly("org.projectlombok:lombok:1.18.12")

//    runtimeOnly("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
