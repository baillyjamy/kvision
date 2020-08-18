buildscript {
    extra.set("production", (findProperty("prod") ?: findProperty("production") ?: "false") == "true")
}

plugins {
    kotlin("js")
    id("maven-publish")
}

repositories()

kotlin {
    kotlinJsTargets()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    api(rootProject)
    implementation(npm("pace-progressbar", "^1.0.9"))
    testImplementation(kotlin("test-js"))
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(kotlin.sourceSets.main.get().kotlin)
}

publishing {
    publications {
        create<MavenPublication>("kotlin") {
            from(components["kotlin"])
            artifact(tasks["sourcesJar"])
            pom {
                defaultPom()
            }
        }
    }
}

setupPublication()
