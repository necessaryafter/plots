plugins {
    id("java")
    id("java-library")
    id("com.diffplug.spotless") version ("6.11.0")
    id("com.github.johnrengelman.shadow") version ("7.1.1")
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")
    apply(plugin = "com.diffplug.spotless")
    apply(plugin = "com.github.johnrengelman.shadow")

    repositories {
        mavenCentral()

        maven(url = "https://jitpack.io")
        maven(url = "https://repo.nickuc.com/maven2/")
        maven(url = "https://repo.nickuc.com/maven-releases/")
        maven(url = "https://repo.dmulloy2.net/repository/public/")
        maven(url = "https://repo.bg-software.com/repository/nms/")
        maven(url = "https://oss.sonatype.org/content/groups/public/")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshot")
        maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        maven(url = "https://repo.extendedclip.com/content/repositories/placeholderapi/")
        maven(url = "https://repo.aikar.co/content/groups/aikar/")
        maven(url = "https://repo.glaremasters.me/repository/concuncan/")
    }

    dependencies {
        api("org.mongodb:mongodb-driver-sync:4.10.1")
        api("co.aikar:acf-paper:0.5.1-SNAPSHOT")

        compileOnlyApi("org.spigotmc:spigot:1.8.8-R0.1-SNAPSHOT")
        compileOnlyApi("com.grinderwolf:slimeworldmanager-api:2.2.1")

        compileOnlyApi("org.projectlombok:lombok:1.18.26")
        annotationProcessor("org.projectlombok:lombok:1.18.26")
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    spotless {
        java {
            removeUnusedImports()
            palantirJavaFormat()
            formatAnnotations()
            importOrder()
        }
    }
}