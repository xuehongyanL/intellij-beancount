plugins {
  id("java")
  id("org.jetbrains.intellij") version "1.9.0"
  id("org.jetbrains.kotlin.jvm") version "1.7.20"
  id("io.freefair.lombok") version "6.5.1"
}

group = "space.wanderful.intellij.plugin"
version = "0.3.0"

repositories {
  mavenCentral()
}

sourceSets {
  main {
    java {
      srcDirs("src/main/gen")
    }
  }
}

dependencies {
  implementation("io.vavr:vavr:0.10.4")
  testImplementation("junit:junit:4.13.2")
}

java {
  sourceCompatibility = JavaVersion.VERSION_17
}

intellij {
  version.set("2022.2.3")
  plugins.set(listOf("com.intellij.java"))
}

tasks {
  buildSearchableOptions {
    enabled = false
  }

  patchPluginXml {
    version.set("${project.version}")
    sinceBuild.set("213")
    untilBuild.set("222.*")
  }

  compileKotlin {
    kotlinOptions.jvmTarget = "17"
  }

  compileTestKotlin {
    kotlinOptions.jvmTarget = "17"
  }

  test {
    // This path value is a machine-specific placeholder text.
    // Set idea.home.path to the absolute path to the intellij-community source
    // on your local machine. For real world projects, use variants described in:
    // https://docs.gradle.org/current/userguide/build_environment.html
    systemProperty("idea.home.path", "/Users/xuehongyan/.gradle/caches/modules-2/files-2.1/com.jetbrains.intellij.idea/ideaIC/2022.2.3/2af6809be127f13b2a50a13e1987a8051feeed1a/ideaIC-2022.2.3")
  }
}
