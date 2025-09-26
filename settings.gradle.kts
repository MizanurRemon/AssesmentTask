pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AssesmentTask"
include(":app")
include(":features:auth:auth_data")
include(":features:auth:auth_presentation")
include(":features:auth:auth_domain")
include(":core:common")
include(":core:data")
include(":core:database")
include(":core:datastore")
include(":core:designsystem")
include(":core:domain")
include(":core:ui")
include(":core:network")
include(":features:feed:feed_data")
include(":features:feed:feed_domain")
include(":features:feed:feed_presentation")
