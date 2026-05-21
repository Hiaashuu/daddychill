# 📦 AppInfo Library

[![](https://jitpack.io/v/Hiaashuu/daddychill.svg)](https://jitpack.io/#Hiaashuu/daddychill)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg)](https://android-arsenal.com/api?level=21)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-purple.svg)](https://kotlinlang.org)

A lightweight Android library that provides structured, package-name-keyed information about pre-installed system and bloatware apps. Built to be **brand-agnostic** — the same `com.android.bluetooth` entry covers every device that ships it, with zero duplicate data across brands.

---

## 🧠 What Is This?

Android devices ship with hundreds of pre-installed apps. Most users have no idea what they do, whether they're safe to remove, or what privacy risks they carry.

This library solves that by providing a **queryable, offline database** of known Android packages with:

- **Safety classification** — CRITICAL, CAUTION, SAFE, BLOATWARE
- **Removal status** — whether it's safe to disable via ADB
- **Key permissions** — what the app actually accesses on your device
- **Privacy notes** — whether it phones home or tracks you
- **ADB removal commands** — ready to copy and run
- **Replacements** — better alternatives where applicable

**Core design principle:** `packageName` is the unique key. No device brands, no duplicates.  
`com.android.bluetooth` is the same single entry whether it appears on OnePlus, Samsung, Pixel, or anything else.

---

## ✅ Requirements

| Requirement | Minimum |
|-------------|---------|
| Android SDK | 21 (Android 5.0 Lollipop) |
| Kotlin | 2.1.0+ |
| JitPack | Required for dependency resolution |

---

## 🚀 Installation

### Step 1 — Add JitPack to your project

In your root `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

Or if you use the older `build.gradle` (Groovy):

```groovy
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2 — Add the dependency

In your app module's `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.Hiaashuu:daddychill:1.0.2")
}
```

Or Groovy:

```groovy
dependencies {
    implementation 'com.github.Hiaashuu:daddychill:1.0.2'
}
```

> Replace `1.0.0` with the [latest release tag](https://github.com/Hiaashuu/daddychill/releases).

### Step 3 — Sync Gradle

Click **Sync Now** in Android Studio / Android IDE, or run:

```bash
./gradlew build
```

---

## 📖 Usage

All access goes through the `AppInfoLibrary` singleton object.  
No initialization needed. No `Application` setup. Just call and go.

> Only `scanInstalledApps()` requires a `Context`. Everything else is Context-free.

---

### 🔍 Look up a single package

```kotlin
import com.hiaashuu.appinfo.AppInfoLibrary

val info = AppInfoLibrary.getInfo("com.android.bluetooth")

if (info != null) {
    println(info.appName)          // "Bluetooth"
    println(info.purpose)          // "Core Bluetooth stack: audio, file transfer..."
    println(info.safetyLevel)      // SafetyLevel.CAUTION
    println(info.removalStatus)    // RemovalStatus.CAUTION
    println(info.removalCommand)   // "adb shell pm disable-user --user 0 com.android.bluetooth"
    println(info.privacyNote)      // null (no privacy concern)
} else {
    println("Package not in database")
}
```

---

### 📱 Scan all installed apps on a device

Cross-references every installed app against the database. Skips unknown packages silently.

```kotlin
val results: List<PackageAppInfo> = AppInfoLibrary.scanInstalledApps(context)

results.forEach { info ->
    println("${info.appName} [${info.safetyLevel}] → ${info.removalStatus}")
}
```

---

### 📋 Look up multiple packages at once

```kotlin
val packages = listOf(
    "com.android.bluetooth",
    "com.google.android.youtube",
    "com.facebook.system"
)

val infos: List<PackageAppInfo> = AppInfoLibrary.getInfoForPackages(packages)
```

---

### 🔴 Get all CRITICAL packages

```kotlin
val critical: List<PackageAppInfo> = AppInfoLibrary.getCritical()

critical.forEach { info ->
    println("NEVER REMOVE: ${info.packageName} — ${info.purpose}")
}
```

---

### 🟢 Get everything safe to remove

```kotlin
val safeList: List<PackageAppInfo> = AppInfoLibrary.getSafeToRemove()

safeList.forEach { info ->
    println("${info.appName}: ${info.removalCommand}")
}
```

---

### 🔒 Get all privacy-risk packages

```kotlin
val privacyRisks: List<PackageAppInfo> = AppInfoLibrary.getPrivacyConcerns()

privacyRisks.forEach { info ->
    println("${info.appName}: ${info.privacyNote}")
}
```

---

### 🗂️ Filter by category

```kotlin
import com.hiaashuu.appinfo.models.AppCategory

val facebookApps = AppInfoLibrary.getByCategory(AppCategory.META_FACEBOOK)
val googleApps   = AppInfoLibrary.getByCategory(AppCategory.GOOGLE)
val qualcomm     = AppInfoLibrary.getByCategory(AppCategory.QUALCOMM)
val oplusApps    = AppInfoLibrary.getByCategory(AppCategory.ONEPLUS_OPLUS)
```

---

### ⚠️ Filter by safety level

```kotlin
import com.hiaashuu.appinfo.models.SafetyLevel

val bloatware = AppInfoLibrary.getBySafetyLevel(SafetyLevel.BLOATWARE)
val caution   = AppInfoLibrary.getBySafetyLevel(SafetyLevel.CAUTION)
val safe      = AppInfoLibrary.getBySafetyLevel(SafetyLevel.SAFE)
```

---

### ✅ Check if a package exists in the database

```kotlin
val isKnown: Boolean = AppInfoLibrary.isKnown("com.android.bluetooth")  // true
val unknown: Boolean = AppInfoLibrary.isKnown("com.some.random.app")     // false
```

---

### 📊 Database stats

```kotlin
val total: Int = AppInfoLibrary.count()
println("$total packages in database")

val all: Map<String, PackageAppInfo> = AppInfoLibrary.getAll()
```

---

## 🔌 Full Example — Scan Device and Categorize Results

```kotlin
import com.hiaashuu.appinfo.AppInfoLibrary
import com.hiaashuu.appinfo.models.SafetyLevel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Scan every installed app and match against database
        val knownApps = AppInfoLibrary.scanInstalledApps(this)

        val critical  = knownApps.filter { it.safetyLevel == SafetyLevel.CRITICAL }
        val bloatware = knownApps.filter { it.safetyLevel == SafetyLevel.BLOATWARE }
        val privacy   = knownApps.filter { it.privacyNote != null }

        Log.d("AppInfo", "Critical apps found   : ${critical.size}")
        Log.d("AppInfo", "Bloatware found        : ${bloatware.size}")
        Log.d("AppInfo", "Privacy risks found    : ${privacy.size}")

        // Print ADB removal commands for all bloatware
        bloatware.forEach { info ->
            info.removalCommand?.let { cmd ->
                Log.d("AppInfo", cmd)
            }
        }
    }
}
```

---

## 🧱 Data Models

### `PackageAppInfo`

The core data class returned by every query.

| Field | Type | Description |
|-------|------|-------------|
| `packageName` | `String` | Unique package identifier e.g. `com.android.bluetooth` |
| `appName` | `String` | Human-readable name |
| `purpose` | `String` | What the app actually does |
| `category` | `AppCategory` | Which vendor/group it belongs to |
| `safetyLevel` | `SafetyLevel` | How dangerous removal is |
| `removalStatus` | `RemovalStatus` | Whether removal is recommended |
| `keyPermissions` | `List<String>` | Permissions the app holds |
| `privacyNote` | `String?` | Non-null means a privacy risk exists |
| `impactIfDisabled` | `String?` | What breaks if you remove it |
| `replacements` | `List<String>` | Better alternatives (if any) |
| `removalCommand` | `String?` | ADB command to safely disable it |
| `notes` | `String?` | Extra context |

---

### `SafetyLevel`

```kotlin
enum class SafetyLevel {
    CRITICAL,   // System will break or become unstable. Never remove.
    CAUTION,    // Has system dependencies. Remove only if you know the impact.
    SAFE,       // Safe to disable if you don't use the feature.
    BLOATWARE   // Pre-installed junk with no system role. Remove freely.
}
```

---

### `RemovalStatus`

```kotlin
enum class RemovalStatus {
    NO,      // Do not remove under any circumstance.
    CAUTION, // Can be removed — test core features after.
    YES      // Safe to remove. No meaningful system impact.
}
```

---

### `AppCategory`

```kotlin
enum class AppCategory {
    ANDROID_SYSTEM,
    GOOGLE,
    GOOGLE_CORE,
    ONEPLUS_OPLUS,
    COLOROS_OPPO,
    QUALCOMM,
    META_FACEBOOK,
    MICROSOFT,
    HEYTAP_NEARME,
    THIRD_PARTY
}
```

---

## 📋 API Reference

| Method | Parameters | Returns | Description |
|--------|-----------|---------|-------------|
| `getInfo()` | `packageName: String` | `PackageAppInfo?` | Single package lookup |
| `getInfoForPackages()` | `packageNames: List<String>` | `List<PackageAppInfo>` | Batch lookup |
| `scanInstalledApps()` | `context: Context` | `List<PackageAppInfo>` | Scans device |
| `getCritical()` | — | `List<PackageAppInfo>` | All CRITICAL entries |
| `getSafeToRemove()` | — | `List<PackageAppInfo>` | All YES entries |
| `getCaution()` | — | `List<PackageAppInfo>` | All CAUTION entries |
| `getPrivacyConcerns()` | — | `List<PackageAppInfo>` | All with privacyNote |
| `getBySafetyLevel()` | `level: SafetyLevel` | `List<PackageAppInfo>` | Filter by level |
| `getByCategory()` | `category: AppCategory` | `List<PackageAppInfo>` | Filter by category |
| `isKnown()` | `packageName: String` | `Boolean` | Database existence check |
| `count()` | — | `Int` | Total packages in DB |
| `getAll()` | — | `Map<String, PackageAppInfo>` | Full database |

---

## 🗃️ Database Coverage

| Category | Status |
|----------|--------|
| Android System | ✅ Active |
| Google Apps | ✅ Active |
| OnePlus / OPLUS | ✅ Active |
| Qualcomm | ✅ Active |
| Meta / Facebook | ✅ Active |
| ColorOS / OPPO | 🔄 In Progress |
| Microsoft | 🔄 In Progress |
| HeyTap / NearMe | 🔄 In Progress |

> Database grows with each release. If `getInfo()` returns `null`, the package isn't in the database yet — handle that gracefully.

---

## 🤝 Contributing

Pull requests are welcome. To add missing packages:

1. Fork this repository
2. Open `library/src/main/kotlin/com/hiaashuu/appinfo/data/AppDatabase.kt`
3. Add your entry inside the `buildMap { }` block:

```kotlin
put(
    "com.example.yourpackage",
    PackageAppInfo(
        packageName  = "com.example.yourpackage",
        appName      = "App Name",
        purpose      = "Clear description of what this app does.",
        category     = AppCategory.ANDROID_SYSTEM,
        safetyLevel  = SafetyLevel.SAFE,
        removalStatus = RemovalStatus.YES,
        keyPermissions = listOf("PERMISSION_ONE", "PERMISSION_TWO"),
        privacyNote    = "Describe tracking concern here, or null if none.",
        impactIfDisabled = "What breaks when this is disabled.",
        replacements   = listOf("Alternative App Name"),
        removalCommand = "adb shell pm disable-user --user 0 com.example.yourpackage",
        notes          = "Any extra context, or null."
    )
)
```

4. Submit a Pull Request

**Contribution guidelines:**
- One package per PR for clean review history
- Cite your sources (AOSP docs, XDA, permission audits)
- Do not guess safety levels — research before submitting
- Use `null` for fields you're uncertain about rather than guessing

---

## 📌 Versioning

This project follows [Semantic Versioning](https://semver.org/):

| Change | Version bump |
|--------|-------------|
| Breaking API changes | MAJOR (2.0.0) |
| New packages or new query methods | MINOR (1.1.0) |
| Wrong data fixes, corrections | PATCH (1.0.1) |

---

## ⚖️ License

```
MIT License

Copyright (c) 2026 Hiaashuu

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

## ⚠️ Disclaimer

This library is for **informational and educational purposes only.**

- Data is based on AOSP documentation, community research, and permission auditing
- Safety ratings are general guidance — behavior may vary by device, ROM version, and carrier
- Always test on a non-critical device before bulk removal
- The author is not responsible for any device issues caused by acting on this information
- Always use `adb shell pm disable-user` (reversible) instead of `pm uninstall` where possible

---

## 🔗 Links

- 📦 [JitPack Package](https://jitpack.io/#Hiaashuu/daddychill)
- 🐛 [Report an Issue](https://github.com/Hiaashuu/daddychill/issues)
- 📬 [GitHub Profile](https://github.com/Hiaashuu)
