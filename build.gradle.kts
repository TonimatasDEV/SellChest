@file:Suppress("VulnerableLibrariesLocal")

plugins {
    java
}

val pluginVersion: String by extra

val libs: Configuration by configurations.creating

group = "net.tonimatasdev"
version = pluginVersion

repositories {
    mavenCentral()
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven(url = "https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    implementation("org.spigotmc:spigot-api:1.20.1-R0.1-SNAPSHOT")
    libs("com.google.code.gson:gson:2.10.1")
    libs.dependencies.map { implementation(it) }
}

tasks.withType<Jar> {
    from(libs.map { if (it.isDirectory) it else zipTree(it) })
}

tasks.withType<ProcessResources> {
    filesMatching("plugin.yml") {
        expand("pluginVersion" to pluginVersion)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}