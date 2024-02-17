import java.io.FileInputStream
import java.util.Properties

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            val properties = Properties().apply {
                load(FileInputStream(File("local.properties")))
            }

            setUrl("https://jitpack.io")
            credentials {
                username = properties.getProperty("TC_JITPACK_TOKEN")
            }
        }
    }
}

rootProject.name = "DigitalFlyer Demo"
include(":app")
