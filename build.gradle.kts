@file:Suppress("VulnerableLibrariesLocal")

plugins {
    java
}

val pluginVersion: String by extra

group = "net.tonimatasdev"
version = pluginVersion

repositories {
    mavenCentral()
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven(url = "https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
}

tasks.withType<ProcessResources> {
    filesMatching("plugin.yml") {
        expand("pluginVersion" to pluginVersion)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}