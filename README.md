# Todo List App

A cross-platform Todo List application built with Kotlin Multiplatform and Compose Multiplatform. Manage your tasks and projects on both Android and iOS from a single shared codebase.

## Overview

This is a personal task and project manager. It lets you create, edit, and organize daily tasks, group them into projects, set priorities and dates, and track progress — with a shared UI built in Compose Multiplatform and local persistence via Room and DataStore.

## Features

- **Cross-platform:** Shared UI and business logic for Android and iOS.
- **Task management:** Create, edit, complete, and delete tasks.
- **Projects & categories:** Group tasks into projects and categories.
- **Priorities & dates:** Set task priorities and start/end dates.
- **Custom animations:** Animated curved bottom navigation bar.
- **Onboarding:** Welcome screens for first-time users.
- **Settings:** Theme (dark mode) and app preferences persisted locally.
- **Local notifications:** Task reminders via platform notification APIs.
- **Data persistence:** Room database + DataStore for local storage.

## Technology stack

- Kotlin Multiplatform, Kotlin 2.3.0
- Compose Multiplatform 1.10.0, Material 3
- Android Gradle Plugin 9.0.0, Gradle 9.3.0
- Koin 4.1.1 (dependency injection)
- Room 2.8.4 + Kotlin Serialization + KSP
- Jetpack DataStore Preferences
- Navigation3 for Compose Multiplatform
- Coil 3 (image loading), Kizitonwose Compose Calendar

## Architecture

Shared code lives in `:composeApp` (`commonMain`, `androidMain`, `iosMain`, `commonTest`) following a layered structure:

- `todoApp/domain` — repository contracts (`TodoRepository`)
- `todoApp/data` — Room entities, DAOs, repository implementation, mappers
- `todoApp/ui` — screens, view models, components, theme, navigation, notifications
- `com.abhijeet` — DI modules and platform entry points (`App`, `di`, `Platform`)

State is handled with ViewModels, `StateFlow`, `collectAsState`, and Koin dependency injection.

## Project structure

- `:composeApp` — shared Kotlin Multiplatform source (UI, domain, data)
- `:androidApp` — Android application module (`com.abhijeet.todoApp`)
- `iosApp/` — Xcode iOS application

## Prerequisites

- Android Studio (latest stable)
- JDK 17
- Android SDK (minSdk 24, targetSdk 36)
- Xcode (for building/running the iOS target)

## Setup and installation

1. Open the project folder in Android Studio.
2. Wait for Gradle to sync and download dependencies.
3. Select the `androidApp` configuration and run on an emulator or device.
4. For iOS, open `iosApp` in Xcode and run on a simulator or device.

## Build and run

Using the Gradle wrapper (configuration cache disabled if needed):

```sh
# Debug Android build
./gradlew :androidApp:assembleDebug

# Install on connected device/emulator
./gradlew :androidApp:installDebug

# Local unit tests (Android + JVM)
./gradlew :androidApp:testDebugUnitTest
./gradlew :composeApp:jvmTest
```

If Gradle configuration cache fails in your environment, run with:

```sh
GRADLE_OPTS="-Dorg.gradle.configuration-cache=false" ./gradlew :androidApp:assembleDebug
```

## Configuration

No API keys, signing credentials, or external-service configuration are required to build and run locally. The application ID is `com.abhijeet.todoApp`. If you integrate Firebase, push notifications, or other console-backed services, configure them for this application ID in their respective consoles.

## Testing

- `./gradlew :androidApp:testDebugUnitTest` — Android unit tests
- `./gradlew :composeApp:jvmTest` — shared common tests on the JVM

## License and attribution

This project uses third-party libraries (Kotlin, Jetpack Compose, Koin, Room, Compose Multiplatform, Coil, Navigation3, and others), each distributed under its own license. No application-level license file is included in the repository.
