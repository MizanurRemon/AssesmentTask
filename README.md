# AssesmentTask

An Android sample app built with **Kotlin** and **Jetpack Compose** that demonstrates clean architecture, modularization, offline‑first data, and infinite scrolling. It uses **Hilt** for DI, **Room** for local cache, **coroutines/Flow** for async streams, and a simple REST source (DummyJSON) to populate a paginated feed.

> Repo structure shows modules like `app/`, `core/`, `features/`, and shared Gradle logic in `buildSrc/` (see repository tree).

---

## ✨ Features

* **Feed list** with paging / "load more" and list item actions
* **Offline‑first** local cache using Room
* **Network state** awareness (Wi‑Fi/Cellular/Ethernet/Bluetooth)
* **Error/Loading/End rows** in the list for great UX
* **Theming** and edge‑to‑edge Compose setup
* **Hilt** dependency injection

> The sample API used during development: `https://dummyjson.com/products?limit=10`.

---

## 🧱 Project structure

```
AssesmentTask/
├─ app/                 # App entry (navigation, DI setup, themes)
├─ core/                # Shared core code (network, database, utils)
├─ features/            # Feature modules (e.g., feed)
├─ buildSrc/            # Centralized Gradle versions & plugins
├─ gradle/              # Wrapper files
├─ *.gradle.kts         # Root Gradle configs
```

* **`app`** – Android application module with Compose UI, navigation, and Hilt setup.
* **`core`** – Cross‑cutting concerns (e.g., Room DB entities/DAO, network, Result wrappers, utils).
* **`features`** – Independent feature modules (e.g., feed presentation/domain/data).

> The code follows a **Clean Architecture**‑style split (`data` ↔ `domain` ↔ `presentation`) inside features.

---

## 🧰 Tech stack

* **Language:** Kotlin (Coroutines, Flow)
* **UI:** Jetpack **Compose**
* **DI:** **Hilt**
* **DB:** **Room**
* **Networking:** Retrofit/OkHttp (or a thin HTTP client) with Result wrappers
* **Image loading:** Coil (Compose `AsyncImage`)
* **Prefs:** DataStore (for lightweight sessions)

> Some utilities reference a Crashlytics helper; you can stub/disable it for local builds.

---

## 🚀 Getting started

### Prerequisites

* **Android Studio Koala (or newer)**
* **JDK 11** (Gradle/AGP are configured for Java 11)
* **Android SDK**: compile/target from project Gradle

### 1) Clone

```bash
git clone https://github.com/MizanurRemon/AssesmentTask.git
cd AssesmentTask
```

### 2) Open & sync

Open the project in **Android Studio**, let Gradle sync.

### 3) Run the app

* Select a device/emulator running **API level per `minSdk`/`targetSdk`** defined in `app/build.gradle.kts`.
* Hit **Run** ▶️ from Android Studio.

## 🧭 How pagination works (TL;DR)

* UI emits **`loadNextPage()`** when the list scrolls near bottom.
* ViewModel calls a **UseCase** with `limit/skip` (page size)
* Repository fetches remote data and stores it to **Room**
* UI observes a **Flow<List<Item>>** from DB

## 🗺️ Roadmap / nice‑to‑haves

* Improved theming + dark mode toggle screen



## Screenshots & Assets

Use this Google Drive folder to store  screen recordings:

* [Drive – AssesmentTask Assets](https://drive.google.com/drive/folders/15HeCjSKA0tuomObytgK9M8DVFkAFZBHx?usp=sharing)

