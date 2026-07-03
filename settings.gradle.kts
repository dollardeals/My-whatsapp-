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
        // Vosk offline speech recognition
        maven { url = uri("https://alphacephei.com/maven/") }
    }
}
rootProject.name = "AliBahiAssistant"
include(":app")
