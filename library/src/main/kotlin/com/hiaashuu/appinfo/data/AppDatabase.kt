package com.hiaashuu.appinfo.data

import com.hiaashuu.appinfo.models.AppCategory
import com.hiaashuu.appinfo.models.PackageAppInfo
import com.hiaashuu.appinfo.models.RemovalStatus
import com.hiaashuu.appinfo.models.SafetyLevel

/**
 * Central package database.
 * Key   = packageName (unique, brand-agnostic)
 * Value = PackageAppInfo
 *
 * To add more packages: follow the exact same pattern below.
 * Package names are the single source of truth — no brands, no devices.
 */
internal object AppDatabase {

    val all: Map<String, PackageAppInfo> by lazy {
        buildMap {

            // ─────────────────────────────────────────────────
            // ANDROID SYSTEM — CRITICAL (Never Remove)
            // ─────────────────────────────────────────────────

            put(
                "com.android.cellbroadcastreceiver",
                PackageAppInfo(
                    packageName = "com.android.cellbroadcastreceiver",
                    appName = "Cell Broadcast Receiver",
                    purpose = "Receives emergency alerts (AMBER, earthquake, government alerts) via cell tower broadcast.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "RECEIVE_EMERGENCY_BROADCAST",
                        "READ_PHONE_STATE",
                        "ACCESS_NETWORK_STATE"
                    ),
                    impactIfDisabled = "Breaks emergency alert system. Required by law in many regions.",
                    notes = "Legal/regulatory requirement. Do not attempt removal."
                )
            )

            put(
                "com.android.bluetooth",
                PackageAppInfo(
                    packageName = "com.android.bluetooth",
                    appName = "Bluetooth",
                    purpose = "Core Bluetooth stack: audio, file transfer, wearables, car connectivity.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "BLUETOOTH",
                        "BLUETOOTH_ADMIN",
                        "ACCESS_FINE_LOCATION",
                        "NEARBY_WIFI_DEVICES"
                    ),
                    privacyNote = "Location permission required for BLE scanning by Android policy.",
                    impactIfDisabled = "No wireless audio, smartwatches, car pairing, or file sharing. Third-party apps still depend on this.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.bluetooth",
                    notes = "Disable only if you never use Bluetooth at all."
                )
            )

            put(
                "com.android.bluetoothmidiservice",
                PackageAppInfo(
                    packageName = "com.android.bluetoothmidiservice",
                    appName = "Bluetooth MIDI Service",
                    purpose = "Enables Bluetooth MIDI for musical instruments and controllers.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("BLUETOOTH", "ACCESS_NETWORK_STATE"),
                    impactIfDisabled = "MIDI keyboards and controllers won't connect via Bluetooth.",
                    replacements = listOf("MIDI BLE Client (com.kxmt.midi.ble)"),
                    removalCommand = "adb shell pm disable-user --user 0 com.android.bluetoothmidiservice"
                )
            )

            put(
                "com.android.cameraextensions",
                PackageAppInfo(
                    packageName = "com.android.cameraextensions",
                    appName = "Camera Extensions Proxy",
                    purpose = "Bridges third-party camera apps to vendor-specific camera features like Night Mode and Portrait.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "CAMERA",
                        "WRITE_EXTERNAL_STORAGE",
                        "INTERACT_ACROSS_USERS"
                    ),
                    impactIfDisabled = "Third-party cameras lose access to hardware-level features. May break GCam.",
                    notes = "Required for Camera2 API extensions. Keep unless you only use stock camera."
                )
            )

            put(
                "com.android.DeviceAsWebcam",
                PackageAppInfo(
                    packageName = "com.android.DeviceAsWebcam",
                    appName = "Webcam Service",
                    purpose = "Allows phone to function as a USB webcam for PCs (Android 14+ feature).",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("CAMERA", "USB_PERMISSION", "FOREGROUND_SERVICE"),
                    privacyNote = "Only activates when USB tethering mode is selected. No background data.",
                    impactIfDisabled = "Webcam option disappears from USB preferences.",
                    replacements = listOf("DroidCam (www.droidcam.com)", "Iriun (iriun.com)"),
                    removalCommand = "adb shell pm disable-user --user 0 com.android.DeviceAsWebcam"
                )
            )

            put(
                "com.android.apps.tag",
                PackageAppInfo(
                    packageName = "com.android.apps.tag",
                    appName = "Tags (NFC)",
                    purpose = "NFC tag reading and writing service. Android Beam successor.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("NFC", "RECEIVE_BOOT_COMPLETED"),
                    impactIfDisabled = "Cannot read or write NFC tags. Google Pay still works (uses separate NFC stack).",
                    replacements = listOf("NFC Tools (com.wakdev.wdnfc)"),
                    removalCommand = "adb shell pm disable-user --user 0 com.android.apps.tag"
                )
            )

            put(
                "com.android.avatarpicker",
                PackageAppInfo(
                    packageName = "com.android.avatarpicker",
                    appName = "Choose a Picture",
                    purpose = "System dialog for selecting avatar and profile pictures in Android 14+.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_EXTERNAL_STORAGE", "READ_MEDIA_IMAGES"),
                    impactIfDisabled = "Fallback to basic file picker when apps request an avatar.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.avatarpicker"
                )
            )

            put(
                "com.android.bips",
                PackageAppInfo(
                    packageName = "com.android.bips",
                    appName = "BIPS",
                    purpose = "Bluetooth Image Transfer Protocol — legacy image sharing between devices.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("BLUETOOTH", "READ_EXTERNAL_STORAGE"),
                    impactIfDisabled = "None for modern usage. Replaced by Nearby Share.",
                    replacements = listOf("Nearby Share (built-in)"),
                    removalCommand = "adb shell pm disable-user --user 0 com.android.bips"
                )
            )

            put(
                "com.android.bookmarkprovider",
                PackageAppInfo(
                    packageName = "com.android.bookmarkprovider",
                    appName = "Bookmark Provider",
                    purpose = "Syncs browser bookmarks across Android system components.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_BOOKMARKS", "WRITE_BOOKMARKS"),
                    impactIfDisabled = "System-level bookmark sharing stops. Chrome and Firefox apps are unaffected.",
                    replacements = listOf("Chrome Sync", "Firefox Sync"),
                    removalCommand = "adb shell pm disable-user --user 0 com.android.bookmarkprovider"
                )
            )

            put(
                "com.android.calllogbackup",
                PackageAppInfo(
                    packageName = "com.android.calllogbackup",
                    appName = "Call Log Backup",
                    purpose = "Backs up call history to Google Account during device setup.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_CALL_LOG", "WRITE_CALL_LOG", "GET_ACCOUNTS"),
                    privacyNote = "Uploads call metadata to Google if backup is enabled.",
                    impactIfDisabled = "Call history won't restore on new device setup.",
                    replacements = listOf("SMS Backup & Restore (com.riteshsahu.CallLogBackupRestore)"),
                    removalCommand = "adb shell pm disable-user --user 0 com.android.calllogbackup"
                )
            )

            put(
                "com.android.backupconfirm",
                PackageAppInfo(
                    packageName = "com.android.backupconfirm",
                    appName = "Backup Confirm",
                    purpose = "Shows a confirmation dialog before ADB backup operations.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("BACKUP", "MANAGE_USERS"),
                    impactIfDisabled = "ADB backups proceed without a confirmation prompt.",
                    notes = "Purely a UI confirmation. Does not affect backup functionality."
                )
            )

            put(
                "com.android.dreams.basic",
                PackageAppInfo(
                    packageName = "com.android.dreams.basic",
                    appName = "Basic Daydream",
                    purpose = "Default Daydream screensaver (colors and clock) displayed while charging.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Daydream screensaver no longer available.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.dreams.basic"
                )
            )

            put(
                "com.android.egg",
                PackageAppInfo(
                    packageName = "com.android.egg",
                    appName = "Android Easter Egg",
                    purpose = "Hidden Easter egg mini-game. Accessible via repeated taps on Android version in Settings.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "None. Pure novelty app.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.egg"
                )
            )

            put(
                "com.android.managedprovisioning",
                PackageAppInfo(
                    packageName = "com.android.managedprovisioning",
                    appName = "Managed Provisioning",
                    purpose = "Handles device enrollment for enterprise MDM (Mobile Device Management) setups.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("MANAGE_DEVICE_ADMINS", "MANAGE_USERS"),
                    impactIfDisabled = "Cannot enroll device into enterprise MDM. No impact for personal devices.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.managedprovisioning"
                )
            )

            put(
                "com.android.musicfx",
                PackageAppInfo(
                    packageName = "com.android.musicfx",
                    appName = "MusicFX",
                    purpose = "System-level equalizer and audio effects (bass boost, reverb) for music apps.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Built-in audio effects unavailable. Third-party EQ apps still work.",
                    replacements = listOf("Poweramp Equalizer", "Wavelet"),
                    removalCommand = "adb shell pm disable-user --user 0 com.android.musicfx"
                )
            )

            put(
                "com.android.pacprocessor",
                PackageAppInfo(
                    packageName = "com.android.pacprocessor",
                    appName = "PAC Processor",
                    purpose = "Processes PAC (Proxy Auto-Config) files for enterprise or carrier network proxy setups.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("ACCESS_NETWORK_STATE"),
                    impactIfDisabled = "PAC-based proxy configurations stop working. No impact if not on enterprise Wi-Fi.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.pacprocessor"
                )
            )

            put(
                "com.android.printspooler",
                PackageAppInfo(
                    packageName = "com.android.printspooler",
                    appName = "Print Spooler",
                    purpose = "Manages print jobs and connects to printer services (Wi-Fi, cloud).",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("ACCESS_WIFI_STATE", "WRITE_EXTERNAL_STORAGE"),
                    impactIfDisabled = "Cannot print from any app. Printing dialogs will fail.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.printspooler"
                )
            )

            put(
                "com.android.storagemanager",
                PackageAppInfo(
                    packageName = "com.android.storagemanager",
                    appName = "Storage Manager",
                    purpose = "System storage cleaner that suggests deleting old photos, downloads, and app data.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("MANAGE_EXTERNAL_STORAGE", "READ_EXTERNAL_STORAGE"),
                    impactIfDisabled = "Storage cleanup suggestions disappear from Settings.",
                    replacements = listOf("Files by Google (com.google.android.apps.nbu.files)"),
                    removalCommand = "adb shell pm disable-user --user 0 com.android.storagemanager"
                )
            )

            put(
                "com.android.traceur",
                PackageAppInfo(
                    packageName = "com.android.traceur",
                    appName = "System Tracing",
                    purpose = "Developer tool for recording system performance traces (CPU, memory, I/O).",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("DUMP", "READ_LOGS"),
                    impactIfDisabled = "System Tracing option disappears from Developer Options.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.traceur"
                )
            )

            // ─────────────────────────────────────────────────
            // ANDROID SYSTEM — OVERLAYS / BLOATWARE
            // ─────────────────────────────────────────────────

            put(
                "com.android.SystemUIResOverlay",
                PackageAppInfo(
                    packageName = "com.android.SystemUIResOverlay",
                    appName = "SystemUI Resource Overlay",
                    purpose = "Vendor visual customizations for status bar, quick settings, animations.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Reverts UI to stock Android appearance. OEM-specific animations and icon styles may disappear.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.SystemUIResOverlay",
                    notes = "Resource Overlay (RRO) package. Test before keeping disabled."
                )
            )

            put(
                "com.android.bluetooth.oplus.overlay",
                PackageAppInfo(
                    packageName = "com.android.bluetooth.oplus.overlay",
                    appName = "Bluetooth OPLUS Overlay",
                    purpose = "OnePlus/OPLUS-specific visual and behavioral overlay for the Bluetooth stack.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Bluetooth reverts to stock AOSP appearance. Core Bluetooth function unaffected.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.bluetooth.oplus.overlay"
                )
            )

            // ─────────────────────────────────────────────────
            // GOOGLE APPS — SAFE TO REMOVE
            // ─────────────────────────────────────────────────

            put(
                "com.google.android.youtube",
                PackageAppInfo(
                    packageName = "com.google.android.youtube",
                    appName = "YouTube",
                    purpose = "Google's pre-installed video streaming app.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "CAMERA",
                        "RECORD_AUDIO",
                        "READ_EXTERNAL_STORAGE",
                        "ACCESS_NETWORK_STATE"
                    ),
                    privacyNote = "Collects watch history, search terms, and device identifiers for ad targeting.",
                    impactIfDisabled = "YouTube must be reinstalled from Play Store if needed.",
                    replacements = listOf("ReVanced (YouTube mod)", "NewPipe (open-source)"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.youtube"
                )
            )

            put(
                "com.google.android.gm",
                PackageAppInfo(
                    packageName = "com.google.android.gm",
                    appName = "Gmail",
                    purpose = "Google's pre-installed email client.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "READ_CONTACTS",
                        "WRITE_CONTACTS",
                        "GET_ACCOUNTS",
                        "READ_EXTERNAL_STORAGE"
                    ),
                    privacyNote = "Scans email content for ad targeting if using Gmail-hosted account.",
                    impactIfDisabled = "Email access stops unless another app is configured.",
                    replacements = listOf("Outlook", "Thunderbird", "Proton Mail", "Fairmail"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.gm"
                )
            )

            put(
                "com.google.android.apps.photos",
                PackageAppInfo(
                    packageName = "com.google.android.apps.photos",
                    appName = "Google Photos",
                    purpose = "Google's pre-installed photo gallery and cloud backup app.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "READ_MEDIA_IMAGES",
                        "READ_MEDIA_VIDEO",
                        "ACCESS_FINE_LOCATION"
                    ),
                    privacyNote = "Uploads photos to Google servers. Shares metadata for ad targeting.",
                    impactIfDisabled = "Loses cloud backup. Local photos still accessible via file manager.",
                    replacements = listOf("Simple Gallery (open-source)", "Aves", "Immich (self-hosted)"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.photos"
                )
            )

            put(
                "com.google.android.gms.location.history",
                PackageAppInfo(
                    packageName = "com.google.android.gms.location.history",
                    appName = "Google Location History",
                    purpose = "Records and syncs your physical location history to Google's servers.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "ACCESS_FINE_LOCATION",
                        "ACCESS_BACKGROUND_LOCATION"
                    ),
                    privacyNote = "High privacy risk. Continuously tracks and uploads your real-world movements.",
                    impactIfDisabled = "Google Timeline feature disabled. No impact on navigation.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.gms.location.history"
                )
            )

            put(
                "com.google.android.feedback",
                PackageAppInfo(
                    packageName = "com.google.android.feedback",
                    appName = "Google Feedback",
                    purpose = "Crash reporting and feedback submission for Google apps.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("ACCESS_NETWORK_STATE"),
                    privacyNote = "Sends crash reports and device diagnostics to Google.",
                    impactIfDisabled = "Google apps lose the ability to submit crash reports.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.feedback"
                )
            )

            put(
                "com.google.mainline.telemetry",
                PackageAppInfo(
                    packageName = "com.google.mainline.telemetry",
                    appName = "Google Telemetry",
                    purpose = "Collects and transmits anonymous usage and crash data from mainline modules.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("ACCESS_NETWORK_STATE"),
                    privacyNote = "Continuously sends telemetry data to Google in the background.",
                    impactIfDisabled = "No user-facing impact. Reduces background data usage.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.mainline.telemetry"
                )
            )

            put(
                "com.google.android.adservices.api",
                PackageAppInfo(
                    packageName = "com.google.android.adservices.api",
                    appName = "AdServices API",
                    purpose = "Google's Privacy Sandbox on Android. Provides interest-based ad targeting without third-party cookies.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("ACCESS_NETWORK_STATE"),
                    privacyNote = "Core ad-tracking infrastructure. Disabling improves privacy significantly.",
                    impactIfDisabled = "Ad personalization reduced. No functional app impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.adservices.api"
                )
            )

            // ─────────────────────────────────────────────────
            // ONEPLUS / OPLUS — SAFE TO REMOVE
            // ─────────────────────────────────────────────────

            put(
                "com.oplus.logkit",
                PackageAppInfo(
                    packageName = "com.oplus.logkit",
                    appName = "OPLUS Log Kit",
                    purpose = "Internal debug log collection tool used by OnePlus/OPLUS for diagnostics.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_LOGS", "DUMP"),
                    privacyNote = "Collects system logs. No benefit to end users.",
                    impactIfDisabled = "None for regular use.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.logkit"
                )
            )

            put(
                "com.oplus.statistics.rom",
                PackageAppInfo(
                    packageName = "com.oplus.statistics.rom",
                    appName = "OPLUS ROM Statistics",
                    purpose = "Collects and uploads ROM usage statistics and analytics to OnePlus servers.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("ACCESS_NETWORK_STATE"),
                    privacyNote = "Telemetry app. Sends ROM behavior data to OnePlus without clear user consent.",
                    impactIfDisabled = "None for user. Stops telemetry upload.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.statistics.rom"
                )
            )

            put(
                "com.oplus.crashbox",
                PackageAppInfo(
                    packageName = "com.oplus.crashbox",
                    appName = "OPLUS Crash Box",
                    purpose = "Captures and reports crash logs from OPLUS system apps to OnePlus servers.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_LOGS", "ACCESS_NETWORK_STATE"),
                    privacyNote = "Sends crash dumps and device identifiers to OnePlus.",
                    impactIfDisabled = "OPLUS crash reporting stops. No user-facing impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.crashbox"
                )
            )

            put(
                "com.oplus.themestore",
                PackageAppInfo(
                    packageName = "com.oplus.themestore",
                    appName = "OPLUS Theme Store",
                    purpose = "OnePlus/OPLUS store for downloading paid and free themes.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "INTERNET",
                        "ACCESS_NETWORK_STATE",
                        "READ_EXTERNAL_STORAGE"
                    ),
                    impactIfDisabled = "Cannot browse or install OPLUS themes.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.themestore"
                )
            )

            put(
                "com.oplus.trafficmonitor",
                PackageAppInfo(
                    packageName = "com.oplus.trafficmonitor",
                    appName = "OPLUS Traffic Monitor",
                    purpose = "Monitors per-app data usage and reports it to OnePlus analytics.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("ACCESS_NETWORK_STATE", "READ_NETWORK_USAGE_HISTORY"),
                    privacyNote = "Tracks which apps consume data and uploads the stats to OnePlus.",
                    impactIfDisabled = "Stops data usage tracking by OnePlus. No functional impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.trafficmonitor"
                )
            )

            put(
                "com.oplus.upgradeguide",
                PackageAppInfo(
                    packageName = "com.oplus.upgradeguide",
                    appName = "OPLUS Upgrade Guide",
                    purpose = "Shows promotional upgrade guides and tips after OTA updates.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("ACCESS_NETWORK_STATE"),
                    impactIfDisabled = "Post-update promotional popups stop appearing.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.upgradeguide"
                )
            )

            put(
                "com.oplus.wallpapers",
                PackageAppInfo(
                    packageName = "com.oplus.wallpapers",
                    appName = "OPLUS Wallpapers",
                    purpose = "OnePlus branded wallpaper app with curated wallpaper packs.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "ACCESS_NETWORK_STATE",
                        "READ_EXTERNAL_STORAGE",
                        "SET_WALLPAPER"
                    ),
                    impactIfDisabled = "OPLUS wallpaper catalog unavailable. System wallpaper picker still works.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.wallpapers"
                )
            )

            put(
                "com.oplus.wifibackuprestore",
                PackageAppInfo(
                    packageName = "com.oplus.wifibackuprestore",
                    appName = "OPLUS WiFi Backup & Restore",
                    purpose = "Backs up saved Wi-Fi credentials to the cloud for device transfers.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("ACCESS_WIFI_STATE", "ACCESS_NETWORK_STATE"),
                    privacyNote = "Uploads Wi-Fi passwords and SSIDs to OnePlus cloud servers.",
                    impactIfDisabled = "Wi-Fi credentials won't sync to new OnePlus devices.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.wifibackuprestore"
                )
            )

            put(
                "com.oplus.uxdesign",
                PackageAppInfo(
                    packageName = "com.oplus.uxdesign",
                    appName = "OPLUS UX Design",
                    purpose = "Core OnePlus UX design layer: animations, transitions, UI spacing across ColorOS.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "May break OnePlus UI animations and visual consistency across system apps.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.uxdesign",
                    notes = "Test immediately after disabling. Re-enable if UI glitches appear."
                )
            )

            put(
                "com.oplus.wirelesssettings",
                PackageAppInfo(
                    packageName = "com.oplus.wirelesssettings",
                    appName = "OPLUS Wireless Settings",
                    purpose = "Extended wireless settings UI for OnePlus-specific connectivity features.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf("ACCESS_WIFI_STATE", "ACCESS_NETWORK_STATE"),
                    impactIfDisabled = "Some OnePlus-specific Wi-Fi or network settings may disappear from the Settings app.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.wirelesssettings"
                )
            )

            // ─────────────────────────────────────────────────
            // META / FACEBOOK — BLOATWARE
            // ─────────────────────────────────────────────────

            put(
                "com.facebook.appmanager",
                PackageAppInfo(
                    packageName = "com.facebook.appmanager",
                    appName = "Facebook App Manager",
                    purpose = "Background installer and updater for Facebook's suite of apps without Play Store.",
                    category = AppCategory.META_FACEBOOK,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "INTERNET",
                        "ACCESS_NETWORK_STATE",
                        "INSTALL_PACKAGES",
                        "RECEIVE_BOOT_COMPLETED"
                    ),
                    privacyNote = "Silently installs and updates Facebook apps in the background. High tracking risk.",
                    impactIfDisabled = "Facebook apps can no longer silently self-update.",
                    removalCommand = "adb shell pm disable-user --user 0 com.facebook.appmanager"
                )
            )

            put(
                "com.facebook.services",
                PackageAppInfo(
                    packageName = "com.facebook.services",
                    appName = "Facebook Services",
                    purpose = "Background service layer that keeps Facebook SDKs active even without the main Facebook app.",
                    category = AppCategory.META_FACEBOOK,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "INTERNET",
                        "ACCESS_NETWORK_STATE",
                        "RECEIVE_BOOT_COMPLETED",
                        "GET_ACCOUNTS"
                    ),
                    privacyNote = "Runs continuously in the background. Collects device and behavior data.",
                    impactIfDisabled = "Reduces Facebook tracking significantly. Core apps still work.",
                    removalCommand = "adb shell pm disable-user --user 0 com.facebook.services"
                )
            )

            put(
                "com.facebook.system",
                PackageAppInfo(
                    packageName = "com.facebook.system",
                    appName = "Facebook System",
                    purpose = "System-level Facebook integration layer pre-installed by OEM agreement.",
                    category = AppCategory.META_FACEBOOK,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "INTERNET",
                        "READ_CONTACTS",
                        "ACCESS_FINE_LOCATION",
                        "RECEIVE_BOOT_COMPLETED"
                    ),
                    privacyNote = "One of the highest-risk pre-installed packages. Has system-level data access.",
                    impactIfDisabled = "No functional impact. Major privacy improvement.",
                    removalCommand = "adb shell pm disable-user --user 0 com.facebook.system"
                )
            )

            // ─────────────────────────────────────────────────
            // QUALCOMM — CRITICAL
            // ─────────────────────────────────────────────────

            put(
                "com.qualcomm.qti.gpudrivers.pineapple.api34",
                PackageAppInfo(
                    packageName = "com.qualcomm.qti.gpudrivers.pineapple.api34",
                    appName = "Adreno GPU Drivers",
                    purpose = "Updatable Adreno GPU drivers for Snapdragon chipsets (Android 13+ GKI model).",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "GPU acceleration fails. Severe graphics degradation or black screen.",
                    notes = "Hardware-level GPU driver. Never remove."
                )
            )

            put(
                "com.qualcomm.qti.qms.service.trustzoneaccess",
                PackageAppInfo(
                    packageName = "com.qualcomm.qti.qms.service.trustzoneaccess",
                    appName = "TrustZone Access Service",
                    purpose = "Bridges Android framework to Qualcomm's TrustZone secure execution environment (TEE).",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Breaks secure key storage, fingerprint, and DRM. May require factory reset.",
                    notes = "Security-critical. Removal will break Widevine DRM and biometric authentication."
                )
            )

            put(
                "com.qualcomm.qti.powersavemode",
                PackageAppInfo(
                    packageName = "com.qualcomm.qti.powersavemode",
                    appName = "Qualcomm Power Save Mode",
                    purpose = "Qualcomm-level battery optimization that throttles CPU/GPU at the chip layer.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Battery saving becomes less effective. Performance may improve slightly.",
                    replacements = listOf("Android Adaptive Battery (built-in)"),
                    removalCommand = "adb shell pm disable-user --user 0 com.qualcomm.qti.powersavemode"
                )
            )

            put(
                "com.qualcomm.qti.cne",
                PackageAppInfo(
                    packageName = "com.qualcomm.qti.cne",
                    appName = "Qualcomm CNE (Connectivity Engine)",
                    purpose = "Qualcomm's intelligent network switching engine. Manages Wi-Fi vs LTE handoffs.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf("ACCESS_NETWORK_STATE", "ACCESS_WIFI_STATE"),
                    impactIfDisabled = "Network handoffs between Wi-Fi and mobile data may become less smooth.",
                    removalCommand = "adb shell pm disable-user --user 0 com.qualcomm.qti.cne"
                )
            )

            put(
                "com.qualcomm.qti.devicestatisticsservice",
                PackageAppInfo(
                    packageName = "com.qualcomm.qti.devicestatisticsservice",
                    appName = "Qualcomm Device Statistics Service",
                    purpose = "Collects hardware telemetry (modem, CPU, radio) and reports to Qualcomm.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("ACCESS_NETWORK_STATE"),
                    privacyNote = "Sends hardware usage telemetry to Qualcomm servers in the background.",
                    impactIfDisabled = "Stops hardware telemetry. No functional impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.qualcomm.qti.devicestatisticsservice"
                )
            )

            // ─────────────────────────────────────────────────
            // THIRD PARTY
            // ─────────────────────────────────────────────────

            put(
                "com.aiunit.aon",
                PackageAppInfo(
                    packageName = "com.aiunit.aon",
                    appName = "AON Service",
                    purpose = "Always-On neural processing service for wake-word detection (Hey Siri-style triggers).",
                    category = AppCategory.THIRD_PARTY,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf("RECORD_AUDIO", "RECEIVE_BOOT_COMPLETED"),
                    privacyNote = "Always listening for wake words. Privacy concern for microphone usage.",
                    impactIfDisabled = "Voice wake-word functionality breaks on supported apps.",
                    removalCommand = "adb shell pm disable-user --user 0 com.aiunit.aon"
                )
            )

            put(
                "com.gms.android.ncm.overlay.common",
                PackageAppInfo(
                    packageName = "com.gms.android.ncm.overlay.common",
                    appName = "NCM Overlay (Common)",
                    purpose = "Network configuration manager overlay. Common resource package.",
                    category = AppCategory.THIRD_PARTY,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "None reported. Resource-only overlay package.",
                    removalCommand = "adb shell pm disable-user --user 0 com.gms.android.ncm.overlay.common"
                )
            )

            put(
                "com.mediatek.omacp",
                PackageAppInfo(
                    packageName = "com.mediatek.omacp",
                    appName = "Omacp (MediaTek)",
                    purpose = "OMA Client Provisioning for auto-configuring APN and MMS settings. MediaTek chipset only.",
                    category = AppCategory.THIRD_PARTY,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("RECEIVE_SMS", "WRITE_APN_SETTINGS"),
                    impactIfDisabled = "None on Qualcomm devices. This is a MediaTek package — irrelevant on Snapdragon hardware.",
                    removalCommand = "adb shell pm disable-user --user 0 com.mediatek.omacp"
                )
            )

            put(
                "com.redteamobile.roaming",
                PackageAppInfo(
                    packageName = "com.redteamobile.roaming",
                    appName = "ORoaming",
                    purpose = "Virtual SIM roaming service that routes international calls through eSIM profiles.",
                    category = AppCategory.THIRD_PARTY,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "ACCESS_FINE_LOCATION",
                        "READ_PHONE_STATE",
                        "ACCESS_NETWORK_STATE"
                    ),
                    privacyNote = "Tracks location to determine roaming zone. Uploads location data to ORoaming servers.",
                    impactIfDisabled = "Virtual roaming via ORoaming stops. Physical SIM roaming still works.",
                    removalCommand = "adb shell pm disable-user --user 0 com.redteamobile.roaming"
                )
            )

            put(
                "com.wapi.wapicertmanage",
                PackageAppInfo(
                    packageName = "com.wapi.wapicertmanage",
                    appName = "WAPI Certificate Manager",
                    purpose = "Manages WAPI (Chinese government Wi-Fi security standard) certificates.",
                    category = AppCategory.THIRD_PARTY,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("ACCESS_WIFI_STATE"),
                    impactIfDisabled = "WAPI Wi-Fi connections fail. Critical for devices sold in China.",
                    notes = "Only relevant in China. Safe to ignore outside China but do not remove — may affect certificate store."
                )
            )

            // ─────────────────────────────────────────────────
            // ADD MORE PACKAGES HERE — FOLLOW THE EXACT SAME PATTERN
            // put(
            //     "com.example.package",
            //     PackageAppInfo(
            //         packageName = "com.example.package",
            //         appName = "App Name",
            //         purpose = "What it does.",
            //         category = AppCategory.ANDROID_SYSTEM,
            //         safetyLevel = SafetyLevel.SAFE,
            //         removalStatus = RemovalStatus.YES,
            //         keyPermissions = listOf("PERMISSION_ONE"),
            //         privacyNote = "Optional — null if no concern",
            //         impactIfDisabled = "What breaks.",
            //         replacements = listOf("Alternative app"),
            //         removalCommand = "adb shell pm disable-user --user 0 com.example.package",
            //         notes = "Optional extra note"
            //     )
            // )
            // ─────────────────────────────────────────────────

        }
    }
}