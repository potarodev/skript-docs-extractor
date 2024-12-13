plugins {
    kotlin("jvm") version "2.1.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "io.github.potarodev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }
    maven("https://repo.skriptlang.org/releases") {
        name = "skriptlang"
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.3-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    compileOnly("com.github.SkriptLang:Skript:2.9.5")
}

val targetJavaVersion = 21
kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}

tasks {
    runServer {
        minecraftVersion("1.21.4")
        downloadPlugins {
            // !! put all addons here in runtask format https://github.com/jpenilla/run-task/wiki/Basic-Usage#downloading-plugins
            github("SkriptLang", "Skript", "2.9.5", "Skript-2.9.5.jar")
            github("SkriptLang", "skript-reflect", "v2.5.1", "skript-reflect-2.5.1.jar")
        }
    }
}