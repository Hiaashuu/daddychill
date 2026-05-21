package com.hiaashuu.appinfo.data

import com.hiaashuu.appinfo.models.AppCategory
import com.hiaashuu.appinfo.models.PackageAppInfo
import com.hiaashuu.appinfo.models.RemovalStatus
import com.hiaashuu.appinfo.models.SafetyLevel

internal object AppDatabase {
    val all: Map<String, PackageAppInfo> by lazy {
        buildMap {

            put(
                "com.android.cellbroadcastreceiver",
                PackageAppInfo(
                    packageName = "com.android.cellbroadcastreceiver",
                    appName = "Cell Broadcast Receiver",
                    purpose = "Receives emergency alerts (AMBER, earthquake, government alerts).",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("RECEIVE_EMERGENCY_BROADCAST", "READ_PHONE_STATE"),
                    impactIfDisabled = "Emergency alerts will stop. Required by law in many regions.",
                    notes = "Do not remove. Legal requirement."
                )
            )

            put(
                "com.android.phone",
                PackageAppInfo(
                    packageName = "com.android.phone",
                    appName = "Phone Services",
                    purpose = "Core telephony framework: dialer backend, SIM management, mobile data.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("CALL_PHONE", "READ_PHONE_STATE", "SEND_SMS"),
                    impactIfDisabled = "Device cannot make calls or use mobile data. Requires factory reset.",
                    notes = "Core telephony component. Never remove."
                )
            )

            put(                "com.android.systemui",
                PackageAppInfo(
                    packageName = "com.android.systemui",
                    appName = "System UI",
                    purpose = "Manages status bar, notifications, quick settings, and lock screen.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("STATUS_BAR", "SYSTEM_ALERT_WINDOW"),
                    impactIfDisabled = "Bootloop or black screen. Device becomes unusable.",
                    notes = "Critical UI component. Never remove."
                )
            )

            put(
                "com.android.shell",
                PackageAppInfo(
                    packageName = "com.android.shell",
                    appName = "Shell",
                    purpose = "Core Android command-line environment.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("INTERACT_ACROSS_USERS", "READ_LOGS"),
                    impactIfDisabled = "ADB commands fail; system scripts crash; OTA updates may break.",
                    notes = "Core framework dependency."
                )
            )

            put(
                "com.android.settings",
                PackageAppInfo(
                    packageName = "com.android.settings",
                    appName = "Settings",
                    purpose = "Main system settings interface.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("WRITE_SECURE_SETTINGS", "MANAGE_USERS"),
                    impactIfDisabled = "Settings app disappears; system config inaccessible.",
                    notes = "Critical system component."
                )
            )

            put(
                "com.android.keychain",
                PackageAppInfo(
                    packageName = "com.android.keychain",
                    appName = "Key Chain",
                    purpose = "Manages cryptographic keys, digital certificates, and secure app authentication.",                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("KEYCHAIN", "MANAGE_USERS"),
                    impactIfDisabled = "Wi-Fi Enterprise auth, VPN, banking logins, and payments fail.",
                    notes = "Security framework core."
                )
            )

            put(
                "com.android.location.fused",
                PackageAppInfo(
                    packageName = "com.android.location.fused",
                    appName = "Fused Location",
                    purpose = "Combines GPS, Wi-Fi, and cell data for accurate location.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("ACCESS_FINE_LOCATION", "ACCESS_COARSE_LOCATION"),
                    impactIfDisabled = "All location services break. Maps and geofencing fail.",
                    notes = "Core location provider."
                )
            )

            put(
                "com.android.providers.contacts",
                PackageAppInfo(
                    packageName = "com.android.providers.contacts",
                    appName = "Contacts Storage",
                    purpose = "Central database for all contacts.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("READ_CONTACTS", "WRITE_CONTACTS"),
                    impactIfDisabled = "Contacts disappear system-wide. Dialer and messaging apps crash.",
                    notes = "Core content provider."
                )
            )

            put(
                "com.android.providers.downloads",
                PackageAppInfo(
                    packageName = "com.android.providers.downloads",
                    appName = "Download Manager",
                    purpose = "System-wide download queue manager.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("INTERNET", "WRITE_EXTERNAL_STORAGE"),
                    impactIfDisabled = "Play Store updates and app downloads fail.",                    notes = "Framework dependency."
                )
            )

            put(
                "com.android.providers.media",
                PackageAppInfo(
                    packageName = "com.android.providers.media",
                    appName = "Media Storage",
                    purpose = "Indexes and serves photos, videos, and audio files to all apps.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("READ_EXTERNAL_STORAGE", "WRITE_EXTERNAL_STORAGE"),
                    impactIfDisabled = "Gallery and media apps show empty. File selection fails.",
                    notes = "Core media framework."
                )
            )

            put(
                "com.android.providers.settings",
                PackageAppInfo(
                    packageName = "com.android.providers.settings",
                    appName = "Settings Provider",
                    purpose = "Stores and syncs system settings (brightness, Wi-Fi, etc).",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("WRITE_SECURE_SETTINGS", "READ_SECURE_SETTINGS"),
                    impactIfDisabled = "Settings crash; preferences reset.",
                    notes = "Core system provider."
                )
            )

            put(
                "com.android.providers.telephony",
                PackageAppInfo(
                    packageName = "com.android.providers.telephony",
                    appName = "Phone Call/SMS Storage",
                    purpose = "Database for call logs, SMS, and telephony state.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("READ_CALL_LOG", "READ_SMS", "WRITE_SMS"),
                    impactIfDisabled = "Dialer, Messages, and SMS apps crash. RCS breaks.",
                    notes = "Core telephony provider."
                )
            )

            put(                "com.android.server.telecom",
                PackageAppInfo(
                    packageName = "com.android.server.telecom",
                    appName = "Call Management",
                    purpose = "Core telephony call routing: VoIP, SIM calls, video calls.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("MANAGE_PHONE_CALLS", "MODIFY_PHONE_STATE"),
                    impactIfDisabled = "Cannot place/receive calls. VoIP apps fail.",
                    notes = "Core telephony framework."
                )
            )

            put(
                "com.android.credentialmanager",
                PackageAppInfo(
                    packageName = "com.android.credentialmanager",
                    appName = "Credential Manager",
                    purpose = "Android 14+ passkey and biometric autofill system.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("USE_CREDENTIALS", "USE_FINGERPRINT"),
                    impactIfDisabled = "Passkeys, biometric autofill, and app logins break.",
                    notes = "Replaces Smart Lock. Critical for modern login."
                )
            )

            put(
                "com.android.externalstorage",
                PackageAppInfo(
                    packageName = "com.android.externalstorage",
                    appName = "External Storage",
                    purpose = "Mounts USB OTG, SD cards, and external media.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("MOUNT_UNMOUNT_FILESYSTEMS"),
                    impactIfDisabled = "USB drives and SD cards won't mount.",
                    notes = "Core storage framework."
                )
            )

            put(
                "com.android.intentresolver",
                PackageAppInfo(
                    packageName = "com.android.intentresolver",
                    appName = "Intent Resolver",
                    purpose = "System dialog for 'Open with' and 'Share via'.",                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("INTERACT_ACROSS_USERS", "SYSTEM_ALERT_WINDOW"),
                    impactIfDisabled = "Sharing and file opening breaks system-wide.",
                    notes = "Core Android framework."
                )
            )

            put(
                "com.android.emergency",
                PackageAppInfo(
                    packageName = "com.android.emergency",
                    appName = "Emergency SOS",
                    purpose = "Power-button emergency calling and medical info.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("CALL_PHONE", "ACCESS_FINE_LOCATION"),
                    impactIfDisabled = "Emergency SOS menu breaks.",
                    notes = "Critical safety feature."
                )
            )

            put(
                "com.android.bluetooth",
                PackageAppInfo(
                    packageName = "com.android.bluetooth",
                    appName = "Bluetooth",
                    purpose = "Core Bluetooth stack: audio, file transfer, wearables.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf("BLUETOOTH", "ACCESS_FINE_LOCATION"),
                    impactIfDisabled = "Wireless audio, smartwatches, and file sharing stop.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.bluetooth",
                    notes = "Disable only if you never use Bluetooth."
                )
            )

            put(
                "com.android.certinstaller",
                PackageAppInfo(
                    packageName = "com.android.certinstaller",
                    appName = "Certificate Installer",
                    purpose = "Installs CA certificates, VPN profiles, and enterprise Wi-Fi credentials.",                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf("INSTALL_CERTIFICATES", "MANAGE_USERS"),
                    impactIfDisabled = "Cannot install security certs; VPN/Enterprise Wi-Fi fails.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.certinstaller",
                    notes = "Keep if you use custom VPNs or work profiles."
                )
            )

            put(
                "com.android.companiondevicemanager",
                PackageAppInfo(
                    packageName = "com.android.companiondevicemanager",
                    appName = "Companion Device Manager",
                    purpose = "Manages smartwatch and IoT pairing flows.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf("BLUETOOTH_CONNECT", "BLUETOOTH_SCAN"),
                    impactIfDisabled = "Watch/fitness band pairing prompts may fail.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.companiondevicemanager",
                    notes = "Disable only if you don't pair companion devices."
                )
            )

            put(
                "com.android.cameraextensions",
                PackageAppInfo(
                    packageName = "com.android.cameraextensions",
                    appName = "Camera Extensions Proxy",
                    purpose = "Bridges third-party camera apps to vendor-specific features (Night, Portrait).",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf("CAMERA", "WRITE_EXTERNAL_STORAGE"),
                    impactIfDisabled = "Third-party cameras (like GCam) may lose hardware features.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.cameraextensions",
                    notes = "Required for Camera2 API extensions."
                )
            )

            put(
                "com.android.inputdevices",
                PackageAppInfo(
                    packageName = "com.android.inputdevices",
                    appName = "Input Devices",
                    purpose = "Manages external keyboards, mice, gamepads, and stylus drivers.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CAUTION,                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf("INJECT_EVENTS", "SET_INPUT_METHOD"),
                    impactIfDisabled = "External input devices may not pair correctly.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.inputdevices",
                    notes = "Keep if you use Bluetooth keyboards or game controllers."
                )
            )

            put(
                "com.android.nfc",
                PackageAppInfo(
                    packageName = "com.android.nfc",
                    appName = "NFC Service",
                    purpose = "Core NFC stack for contactless payments and tags.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf("NFC", "ACCESS_FINE_LOCATION"),
                    impactIfDisabled = "Google Pay and NFC tags stop working.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.nfc",
                    notes = "Disable only if you never use NFC."
                )
            )

            put(
                "com.android.stk",
                PackageAppInfo(
                    packageName = "com.android.stk",
                    appName = "SIM Toolkit",
                    purpose = "Carrier SIM Toolkit interface (balance check, roaming).",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf("READ_PHONE_STATE", "CALL_PHONE"),
                    impactIfDisabled = "SIM menu disappears; carrier services inaccessible.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.stk",
                    notes = "Disable only if you manage carrier features via dialer codes."
                )
            )

            put(
                "com.android.wallpaper.livepicker",
                PackageAppInfo(
                    packageName = "com.android.wallpaper.livepicker",
                    appName = "Motion Wallpaper Selector",
                    purpose = "System dialog for selecting live wallpapers.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf("SET_WALLPAPER", "READ_EXTERNAL_STORAGE"),                    impactIfDisabled = "Live wallpaper picker disappears.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.wallpaper.livepicker",
                    notes = "Disable only if you use static wallpapers."
                )
            )

            put(
                "com.android.DeviceAsWebcam",
                PackageAppInfo(
                    packageName = "com.android.DeviceAsWebcam",
                    appName = "Webcam Service",
                    purpose = "Allows phone to function as a USB webcam for PCs.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("CAMERA", "USB_PERMISSION"),
                    impactIfDisabled = "Webcam option disappears from USB preferences.",
                    replacements = listOf("DroidCam", "Iriun"),
                    removalCommand = "adb shell pm disable-user --user 0 com.android.DeviceAsWebcam",
                    notes = "Safe to remove if not used."
                )
            )

            put(
                "com.android.apps.tag",
                PackageAppInfo(
                    packageName = "com.android.apps.tag",
                    appName = "Tags (NFC)",
                    purpose = "NFC tag reading and writing service.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("NFC", "RECEIVE_BOOT_COMPLETED"),
                    impactIfDisabled = "Cannot read/write NFC tags.",
                    replacements = listOf("NFC Tools"),
                    removalCommand = "adb shell pm disable-user --user 0 com.android.apps.tag"
                )
            )

            put(
                "com.android.avatarpicker",
                PackageAppInfo(
                    packageName = "com.android.avatarpicker",
                    appName = "Choose a Picture",
                    purpose = "System dialog for selecting avatar/profile pictures.",
                    category = AppCategory.ANDROID_SYSTEM,                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_EXTERNAL_STORAGE", "READ_MEDIA_IMAGES"),
                    impactIfDisabled = "Fallback to basic file picker for avatars.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.avatarpicker"
                )
            )

            put(
                "com.android.bips",
                PackageAppInfo(
                    packageName = "com.android.bips",
                    appName = "BIPS",
                    purpose = "Legacy Bluetooth Image Transfer Protocol.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("BLUETOOTH", "READ_EXTERNAL_STORAGE"),
                    impactIfDisabled = "None (replaced by Nearby Share).",
                    replacements = listOf("Nearby Share"),
                    removalCommand = "adb shell pm disable-user --user 0 com.android.bips"
                )
            )

            put(
                "com.android.bookmarkprovider",
                PackageAppInfo(
                    packageName = "com.android.bookmarkprovider",
                    appName = "Bookmark Provider",
                    purpose = "Syncs browser bookmarks across system components.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_BOOKMARKS", "WRITE_BOOKMARKS"),
                    impactIfDisabled = "System-level bookmark sharing stops.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.bookmarkprovider"
                )
            )

            put(
                "com.android.calllogbackup",
                PackageAppInfo(
                    packageName = "com.android.calllogbackup",
                    appName = "Call Log Backup",
                    purpose = "Backs up call history to Google Account during setup.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_CALL_LOG", "WRITE_CALL_LOG"),
                    privacyNote = "Uploads call metadata to Google.",                    impactIfDisabled = "Call history won't restore on new device setup.",
                    replacements = listOf("SMS Backup & Restore"),
                    removalCommand = "adb shell pm disable-user --user 0 com.android.calllogbackup"
                )
            )

            put(
                "com.android.backupconfirm",
                PackageAppInfo(
                    packageName = "com.android.backupconfirm",
                    appName = "Backup Confirm",
                    purpose = "Shows confirmation dialog before ADB backup operations.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("BACKUP", "MANAGE_USERS"),
                    impactIfDisabled = "ADB backups proceed without prompt.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.backupconfirm"
                )
            )

            put(
                "com.android.dreams.basic",
                PackageAppInfo(
                    packageName = "com.android.dreams.basic",
                    appName = "Basic Daydream",
                    purpose = "Default screensaver (clock, photos) while charging.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "Daydream screensaver removed from Settings.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.dreams.basic"
                )
            )

            put(
                "com.android.egg",
                PackageAppInfo(
                    packageName = "com.android.egg",
                    appName = "Android Easter Egg",
                    purpose = "Hidden Android 14 themed mini-game.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "Easter egg inaccessible.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.egg"
                )
            )

            put(                "com.android.managedprovisioning",
                PackageAppInfo(
                    packageName = "com.android.managedprovisioning",
                    appName = "Work Setup",
                    purpose = "Sets up and manages Android Work Profile.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("MANAGE_USERS", "MANAGE_PROFILE_OWNER"),
                    impactIfDisabled = "Work profile setup fails.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.managedprovisioning"
                )
            )

            put(
                "com.android.microdroid.empty_payload",
                PackageAppInfo(
                    packageName = "com.android.microdroid.empty_payload",
                    appName = "Microdroid Empty Payload",
                    purpose = "Virtualization test payload for secure containers.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "Zero user impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.microdroid.empty_payload"
                )
            )

            put(
                "com.android.musicfx",
                PackageAppInfo(
                    packageName = "com.android.musicfx",
                    appName = "MusicFX",
                    purpose = "System audio effects framework (bass boost, equalizer).",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("MODIFY_AUDIO_SETTINGS"),
                    impactIfDisabled = "Built-in audio enhancements disappear.",
                    replacements = listOf("Wavelet", "Poweramp Equalizer"),
                    removalCommand = "adb shell pm disable-user --user 0 com.android.musicfx"
                )
            )

            put(
                "com.android.ncm.overlay.common",
                PackageAppInfo(
                    packageName = "com.android.ncm.overlay.common",
                    appName = "NCM Overlay Common",
                    purpose = "Network Connectivity Manager overlay.",                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "None (Resource Overlay package).",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.ncm.overlay.common"
                )
            )

            put(
                "com.android.pacprocessor",
                PackageAppInfo(
                    packageName = "com.android.pacprocessor",
                    appName = "PAC Processor",
                    purpose = "Processes Proxy Auto-Config files for enterprise Wi-Fi.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "No impact unless using corporate proxy.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.pacprocessor"
                )
            )

            put(
                "com.android.printspooler",
                PackageAppInfo(
                    packageName = "com.android.printspooler",
                    appName = "Print Spooler",
                    purpose = "System print queue for wireless/USB printers.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "Print dialog disappears.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.printspooler"
                )
            )

            put(
                "com.android.providers.blockednumber",
                PackageAppInfo(
                    packageName = "com.android.providers.blockednumber",
                    appName = "Blocked Numbers Storage",
                    purpose = "Central database for blocked phone numbers.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_CALL_LOG", "WRITE_CALL_LOG"),
                    impactIfDisabled = "Blocked numbers reset.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.providers.blockednumber"
                )
            )
            put(
                "com.android.providers.partnerbookmarks",
                PackageAppInfo(
                    packageName = "com.android.providers.partnerbookmarks",
                    appName = "Partner Bookmarks Provider",
                    purpose = "Legacy provider for pre-installed bookmarks.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "Pre-loaded carrier bookmarks disappear.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.providers.partnerbookmarks"
                )
            )

            put(
                "com.android.proxyhandler",
                PackageAppInfo(
                    packageName = "com.android.proxyhandler",
                    appName = "ProxyHandler",
                    purpose = "Manages HTTP/HTTPS proxy configs for Wi-Fi.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "No impact for personal use.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.proxyhandler"
                )
            )

            put(
                "com.android.role.notes.enabled",
                PackageAppInfo(
                    packageName = "com.android.role.notes.enabled",
                    appName = "Notes Role Enabled",
                    purpose = "Declares system support for Notes app role.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "No functional impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.role.notes.enabled"
                )
            )

            put(
                "com.android.safetycenter.resources.overlay",
                PackageAppInfo(
                    packageName = "com.android.safetycenter.resources.overlay",
                    appName = "Safety Center Resource Overlay",
                    purpose = "Visual resources for Android Safety Center.",
                    category = AppCategory.ANDROID_SYSTEM,                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "Safety Center UI may revert to stock.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.safetycenter.resources.overlay"
                )
            )

            put(
                "com.android.safetycenter.styles.overlay",
                PackageAppInfo(
                    packageName = "com.android.safetycenter.styles.overlay",
                    appName = "Safety Center Styles Overlay",
                    purpose = "Styles for Android Safety Center UI.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "Safety Center UI styles change.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.safetycenter.styles.overlay"
                )
            )

            put(
                "com.android.se.overlay.target",
                PackageAppInfo(
                    packageName = "com.android.se.overlay.target",
                    appName = "SE Overlay Target",
                    purpose = "Secure element configuration overlay.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "Minor config fallback; no user impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.se.overlay.target"
                )
            )

            put(
                "com.android.sharedstoragebackup",
                PackageAppInfo(
                    packageName = "com.android.sharedstoragebackup",
                    appName = "Shared Storage Backup",
                    purpose = "Backs up shared storage to Google Account.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_EXTERNAL_STORAGE", "GET_ACCOUNTS"),
                    privacyNote = "Uploads media metadata to Google.",
                    impactIfDisabled = "Shared files won't restore on setup.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.sharedstoragebackup"
                )
            )
            put(
                "com.android.storagemanager",
                PackageAppInfo(
                    packageName = "com.android.storagemanager",
                    appName = "Storage Manager",
                    purpose = "Monitors internal storage and suggests cleaning.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_EXTERNAL_STORAGE", "WRITE_EXTERNAL_STORAGE"),
                    impactIfDisabled = "Auto-clean features stop.",
                    replacements = listOf("Files by Google"),
                    removalCommand = "adb shell pm disable-user --user 0 com.android.storagemanager"
                )
            )

            put(
                "com.android.traceur",
                PackageAppInfo(
                    packageName = "com.android.traceur",
                    appName = "System Tracing",
                    purpose = "Developer tool for system-wide performance traces.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "Tracing features disappear from Developer Options.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.traceur"
                )
            )

            put(
                "com.android.virtualmachine.res",
                PackageAppInfo(
                    packageName = "com.android.virtualmachine.res",
                    appName = "Virtual Machine Resources",
                    purpose = "Resources for Android's virtualization framework.",
                    category = AppCategory.ANDROID_SYSTEM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "Zero user impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.virtualmachine.res"
                )
            )

            put(                "com.google.android.youtube",
                PackageAppInfo(
                    packageName = "com.google.android.youtube",
                    appName = "YouTube",
                    purpose = "Google's pre-installed video streaming app.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("CAMERA", "RECORD_AUDIO", "ACCESS_FINE_LOCATION"),
                    privacyNote = "Tracks watch history and search queries for ads.",
                    impactIfDisabled = "YouTube app disappears; web access still works.",
                    replacements = listOf("NewPipe", "LibreTube"),
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
                    keyPermissions = listOf("GET_ACCOUNTS", "READ_CONTACTS", "CAMERA"),
                    impactIfDisabled = "Gmail app disappears; web access still works.",
                    replacements = listOf("FairEmail", "Outlook", "Proton Mail"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.gm"
                )
            )

            put(
                "com.google.android.apps.photos",
                PackageAppInfo(
                    packageName = "com.google.android.apps.photos",
                    appName = "Google Photos",
                    purpose = "Cloud photo backup and AI organization.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_MEDIA_IMAGES", "CAMERA", "ACCESS_FINE_LOCATION"),
                    privacyNote = "Uploads photos to Google servers.",
                    impactIfDisabled = "Photos app disappears; gallery works via other apps.",
                    replacements = listOf("Simple Gallery", "Nextcloud Photos"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.photos"
                )
            )

            put(                "com.google.android.gms.location.history",
                PackageAppInfo(
                    packageName = "com.google.android.gms.location.history",
                    appName = "Google Location History",
                    purpose = "Records and syncs precise location history to Google.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("ACCESS_FINE_LOCATION", "ACCESS_BACKGROUND_LOCATION"),
                    privacyNote = "High privacy risk: creates detailed movement profile.",
                    impactIfDisabled = "Google Timeline stops; location-based suggestions degrade.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.gms.location.history",
                    notes = "Highly recommended to remove for privacy."
                )
            )

            put(
                "com.google.android.feedback",
                PackageAppInfo(
                    packageName = "com.google.android.feedback",
                    appName = "Market Feedback Agent",
                    purpose = "Collects crash reports and user feedback for Play Store.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_LOGS", "PACKAGE_USAGE_STATS"),
                    privacyNote = "Sends diagnostic data to Google.",
                    impactIfDisabled = "Crash reports not sent.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.feedback"
                )
            )

            put(
                "com.google.mainline.telemetry",
                PackageAppInfo(
                    packageName = "com.google.mainline.telemetry",
                    appName = "Mainline Telemetry",
                    purpose = "Collects crash reporting and usage analytics for mainline modules.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_LOGS", "PACKAGE_USAGE_STATS"),
                    privacyNote = "Sends diagnostic data to Google.",
                    impactIfDisabled = "Google receives less diagnostic data.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.mainline.telemetry"
                )
            )

            put(
                "com.google.android.adservices.api",                PackageAppInfo(
                    packageName = "com.google.android.adservices.api",
                    appName = "Ad Privacy",
                    purpose = "Implements Privacy Sandbox (Topics API) for ad targeting.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("QUERY_ALL_PACKAGES", "PACKAGE_USAGE_STATS"),
                    privacyNote = "Tracks app usage for ad targeting.",
                    impactIfDisabled = "Ad personalization falls back to generic ads.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.adservices.api",
                    notes = "Recommended to remove for privacy."
                )
            )

            put(
                "com.google.android.apps.bard",
                PackageAppInfo(
                    packageName = "com.google.android.apps.bard",
                    appName = "Gemini",
                    purpose = "Google's AI assistant app.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("INTERNET", "CAMERA", "RECORD_AUDIO"),
                    impactIfDisabled = "Gemini app disappears.",
                    replacements = listOf("Microsoft Copilot", "Claude"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.bard"
                )
            )

            put(
                "com.google.android.apps.nbu.files",
                PackageAppInfo(
                    packageName = "com.google.android.apps.nbu.files",
                    appName = "Files by Google",
                    purpose = "File manager with cleaning tools and cloud backup.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_EXTERNAL_STORAGE", "WRITE_EXTERNAL_STORAGE"),
                    impactIfDisabled = "Files app disappears.",
                    replacements = listOf("Solid Explorer", "Mixplorer"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.nbu.files"
                )
            )

            put(
                "com.google.android.apps.nbu.paisa.user",
                PackageAppInfo(                    packageName = "com.google.android.apps.nbu.paisa.user",
                    appName = "Google Pay (India)",
                    purpose = "UPI payment app for India.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_SMS", "READ_PHONE_STATE", "CAMERA"),
                    impactIfDisabled = "Google Pay UPI features unavailable.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.nbu.paisa.user",
                    notes = "Safe to remove if not in India or not using UPI."
                )
            )

            put(
                "com.google.android.apps.restore",
                PackageAppInfo(
                    packageName = "com.google.android.apps.restore",
                    appName = "Android Switch",
                    purpose = "Transfers data from old device during setup.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_EXTERNAL_STORAGE", "GET_ACCOUNTS"),
                    impactIfDisabled = "Zero impact post-setup.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.restore"
                )
            )

            put(
                "com.google.android.apps.setupwizard.searchselector",
                PackageAppInfo(
                    packageName = "com.google.android.apps.setupwizard.searchselector",
                    appName = "Search Engine Selector",
                    purpose = "Setup wizard screen for choosing default search engine.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "Zero impact post-setup.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.setupwizard.searchselector"
                )
            )

            put(
                "com.google.android.apps.tachyon",
                PackageAppInfo(
                    packageName = "com.google.android.apps.tachyon",
                    appName = "Google Meet",
                    purpose = "Video conferencing app.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("CAMERA", "RECORD_AUDIO", "INTERNET"),
                    impactIfDisabled = "Meet app disappears.",
                    replacements = listOf("Zoom", "Microsoft Teams"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.tachyon"
                )
            )

            put(
                "com.google.android.apps.wellbeing",
                PackageAppInfo(
                    packageName = "com.google.android.apps.wellbeing",
                    appName = "Digital Wellbeing",
                    purpose = "Screen time tracking and app timers.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("PACKAGE_USAGE_STATS", "QUERY_ALL_PACKAGES"),
                    privacyNote = "Tracks all app usage patterns and screen time.",
                    impactIfDisabled = "Digital Wellbeing dashboard disappears.",
                    replacements = listOf("ActionDash", "StayFree"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.wellbeing"
                )
            )

            put(
                "com.google.android.apps.work.clouddpc",
                PackageAppInfo(
                    packageName = "com.google.android.apps.work.clouddpc",
                    appName = "Device Policy",
                    purpose = "Enterprise device management.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("MANAGE_DEVICE_ADMINS", "MANAGE_USERS"),
                    impactIfDisabled = "Work profile setup fails.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.work.clouddpc"
                )
            )

            put(
                "com.google.android.appsearch.apk",
                PackageAppInfo(
                    packageName = "com.google.android.appsearch.apk",
                    appName = "AppSearch",
                    purpose = "On-device app content indexing.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("QUERY_ALL_PACKAGES", "READ_EXTERNAL_STORAGE"),                    impactIfDisabled = "In-app search may be slower.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.appsearch.apk"
                )
            )

            put(
                "com.google.android.accessibility.switchaccess",
                PackageAppInfo(
                    packageName = "com.google.android.accessibility.switchaccess",
                    appName = "Switch Access",
                    purpose = "Accessibility service for motor impairments.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "Switch Access option disappears.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.accessibility.switchaccess"
                )
            )

            put(
                "com.google.android.calendar",
                PackageAppInfo(
                    packageName = "com.google.android.calendar",
                    appName = "Google Calendar",
                    purpose = "Official Google calendar app.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_CALENDAR", "WRITE_CALENDAR"),
                    impactIfDisabled = "Calendar UI removed; sync still works.",
                    replacements = listOf("Etar", "Outlook"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.calendar"
                )
            )

            put(
                "com.google.android.chrome",
                PackageAppInfo(
                    packageName = "com.google.android.chrome",
                    appName = "Chrome",
                    purpose = "Pre-installed Google web browser.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("CAMERA", "MICROPHONE", "ACCESS_FINE_LOCATION"),
                    privacyNote = "Syncs history and passwords to Google.",
                    impactIfDisabled = "Default browser falls back to HeyTap/OnePlus.",
                    replacements = listOf("Firefox", "Brave", "Cromite"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.chrome"
                )            )

            put(
                "com.google.android.documentsui",
                PackageAppInfo(
                    packageName = "com.google.android.documentsui",
                    appName = "Files (System Picker)",
                    purpose = "System document picker UI for file selection.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf("MANAGE_EXTERNAL_STORAGE", "READ_EXTERNAL_STORAGE"),
                    impactIfDisabled = "All file pickers break; attaching files fails.",
                    notes = "Critical system component. Do not remove unless you have an alternative file picker configured."
                )
            )

            put(
                "com.google.android.federatedcompute",
                PackageAppInfo(
                    packageName = "com.google.android.federatedcompute",
                    appName = "Federated Compute",
                    purpose = "Privacy-preserving on-device ML training.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("PACKAGE_USAGE_STATS", "INTERNET"),
                    impactIfDisabled = "Personalization features may learn slower.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.federatedcompute"
                )
            )

            put(
                "com.google.android.gms.supervision",
                PackageAppInfo(
                    packageName = "com.google.android.gms.supervision",
                    appName = "Family Link Supervision",
                    purpose = "Parental controls for child accounts.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("MANAGE_USERS", "PACKAGE_USAGE_STATS"),
                    impactIfDisabled = "Family Link controls stop.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.gms.supervision"
                )
            )

            put(
                "com.google.android.hotspot2.osulogin",
                PackageAppInfo(                    packageName = "com.google.android.hotspot2.osulogin",
                    appName = "OSU Login",
                    purpose = "Automates login for enterprise Wi-Fi networks.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "Auto-login to enterprise Wi-Fi fails.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.hotspot2.osulogin"
                )
            )

            put(
                "com.google.android.marvin.talkback",
                PackageAppInfo(
                    packageName = "com.google.android.marvin.talkback",
                    appName = "TalkBack",
                    purpose = "Screen reader for visually impaired users.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "TalkBack option disappears.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.marvin.talkback"
                )
            )

            put(
                "com.google.android.printservice.recommendation",
                PackageAppInfo(
                    packageName = "com.google.android.printservice.recommendation",
                    appName = "Print Service Recommendation",
                    purpose = "Suggests compatible printer drivers.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "Print dialog won't suggest new printers.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.printservice.recommendation"
                )
            )

            put(
                "com.google.android.projection.gearhead",
                PackageAppInfo(
                    packageName = "com.google.android.projection.gearhead",
                    appName = "Android Auto",
                    purpose = "Projects phone UI to car display.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("ACCESS_FINE_LOCATION", "BLUETOOTH_CONNECT"),
                    impactIfDisabled = "Android Auto won't connect to car.",                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.projection.gearhead"
                )
            )

            put(
                "com.google.android.setupwizard",
                PackageAppInfo(
                    packageName = "com.google.android.setupwizard",
                    appName = "Android Setup",
                    purpose = "Initial device setup wizard.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("MANAGE_USERS", "GET_ACCOUNTS"),
                    impactIfDisabled = "Zero impact post-setup.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.setupwizard"
                )
            )

            put(
                "com.google.android.uwb.resources",
                PackageAppInfo(
                    packageName = "com.google.android.uwb.resources",
                    appName = "UWB Resources",
                    purpose = "Ultra-Wideband framework resources (not used on 13R).",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    impactIfDisabled = "Zero impact on OnePlus 13R.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.uwb.resources"
                )
            )

            put(
                "com.coloros.accessibilityassistant",
                PackageAppInfo(
                    packageName = "com.coloros.accessibilityassistant",
                    appName = "AI VoiceScribe",
                    purpose = "Real-time speech-to-text transcription, live captions, and accessibility voice commands.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "RECORD_AUDIO",
                        "PROCESS_OUTGOING_AUDIO",
                        "SYSTEM_ALERT_WINDOW",
                        "INTERNET"
                    ),
                    privacyNote = "Processes audio locally but may upload anonymized data for model improvement.",
                    impactIfDisabled = "Live Caption, Voice Typing enhancements, and AI transcription stop.",
                    replacements = listOf("Google Live Transcribe", "Otter.ai", "SpeechTexter"),                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.accessibilityassistant"
                )
            )

            put(
                "com.coloros.activation",
                PackageAppInfo(
                    packageName = "com.coloros.activation",
                    appName = "E-warranty Card",
                    purpose = "Displays device warranty status, activation date, and service center info.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("READ_PHONE_STATE", "INTERNET", "ACCESS_NETWORK_STATE"),
                    impactIfDisabled = "Warranty info inaccessible via Settings; check via OnePlus website instead.",
                    replacements = listOf("OnePlus website", "OnePlus Care app"),
                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.activation"
                )
            )

            put(
                "com.coloros.assistantscreen",
                PackageAppInfo(
                    packageName = "com.coloros.assistantscreen",
                    appName = "Shelf",
                    purpose = "Left-home-screen panel with widgets, shortcuts, news feed, and quick actions.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "QUERY_ALL_PACKAGES",
                        "READ_PHONE_STATE",
                        "INTERNET",
                        "ACCESS_FINE_LOCATION"
                    ),
                    privacyNote = "May collect usage patterns for personalized content recommendations.",
                    impactIfDisabled = "Swipe-right home screen panel disappears; widgets still accessible via long-press.",
                    replacements = listOf("Google Discover", "Niagara Widgets", "Smart Launcher panels"),
                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.assistantscreen"
                )
            )

            put(
                "com.coloros.bootreg",
                PackageAppInfo(
                    packageName = "com.coloros.bootreg",
                    appName = "Startup Wizard",
                    purpose = "Initial device setup wizard: language, accounts, permissions, OnePlus services enrollment.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.CRITICAL,                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "MANAGE_USERS",
                        "WRITE_SECURE_SETTINGS",
                        "GET_ACCOUNTS",
                        "INTERNET"
                    ),
                    impactIfDisabled = "⚠️ BOOTLOOP RISK: Removing breaks boot sequence and initial setup flow. Device may get stuck in repeated boot.",
                    notes = "CRITICAL: Do not remove. Required for boot completion even after initial setup."
                )
            )

            put(
                "com.coloros.childrenspace",
                PackageAppInfo(
                    packageName = "com.coloros.childrenspace",
                    appName = "Kids Mode",
                    purpose = "Parental control environment: app lockdown, time limits, content filtering, usage reports.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "MANAGE_USERS",
                        "QUERY_ALL_PACKAGES",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Kids Mode option disappears from Settings; no impact on regular usage.",
                    replacements = listOf("Google Family Link", "Kids Place", "Secure Kids"),
                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.childrenspace"
                )
            )

            put(
                "com.coloros.colordirectservice",
                PackageAppInfo(
                    packageName = "com.coloros.colordirectservice",
                    appName = "Screen Recognition",
                    purpose = "AI-powered on-screen content analysis: text extraction, object recognition, smart suggestions.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "READ_FRAME_BUFFER",
                        "SYSTEM_ALERT_WINDOW",
                        "INTERNET",
                        "PACKAGE_USAGE_STATS"
                    ),
                    privacyNote = "Analyzes screen content locally; may send anonymized usage data.",
                    impactIfDisabled = "Smart Sidebar suggestions, text selection AI, and visual search degrade.",                    replacements = listOf("Google Lens", "Bubble Screen Translate"),
                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.colordirectservice"
                )
            )

            put(
                "com.coloros.compass2",
                PackageAppInfo(
                    packageName = "com.coloros.compass2",
                    appName = "Compass",
                    purpose = "Digital compass app using magnetometer sensor for direction finding.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("ACCESS_FINE_LOCATION", "BODY_SENSORS"),
                    impactIfDisabled = "Compass app disappears; maps still show direction via GPS.",
                    replacements = listOf("Google Maps compass", "Compass Steel 3", "GPS Essentials"),
                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.compass2"
                )
            )

            put(
                "com.coloros.floatassistant",
                PackageAppInfo(
                    packageName = "com.coloros.floatassistant",
                    appName = "Assistive Ball",
                    purpose = "Floating shortcut button for quick actions: screenshot, lock screen, app switch, gestures.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "SYSTEM_ALERT_WINDOW",
                        "BIND_ACCESSIBILITY_SERVICE",
                        "QUERY_ALL_PACKAGES"
                    ),
                    impactIfDisabled = "Floating ball disappears; all actions still accessible via gestures/buttons.",
                    replacements = listOf("Assistive Touch", "Floating Menu", "built-in gestures"),
                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.floatassistant"
                )
            )

            put(
                "com.coloros.lockassistant",
                PackageAppInfo(
                    packageName = "com.coloros.lockassistant",
                    appName = "Assistant (Lock Screen)",
                    purpose = "Lock screen shortcuts, quick camera/music access, and notification interaction helpers.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,                    keyPermissions = listOf(
                        "SYSTEM_ALERT_WINDOW",
                        "READ_NOTIFICATIONS",
                        "CAMERA",
                        "RECORD_AUDIO"
                    ),
                    impactIfDisabled = "Lock screen shortcuts disappear; core lock/unlock functionality unaffected.",
                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.lockassistant"
                )
            )

            put(
                "com.coloros.ocrscanner",
                PackageAppInfo(
                    packageName = "com.coloros.ocrscanner",
                    appName = "Scan",
                    purpose = "Document scanning, QR/barcode reader, text extraction (OCR), and translation.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "CAMERA",
                        "READ_EXTERNAL_STORAGE",
                        "INTERNET",
                        "PROCESS_TEXT"
                    ),
                    impactIfDisabled = "Scan shortcut disappears; QR codes still scannable via camera/Google Lens.",
                    replacements = listOf("Google Lens", "Adobe Scan", "Microsoft Lens", "QR & Barcode Scanner"),
                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.ocrscanner"
                )
            )

            put(
                "com.coloros.ocs.opencapabilityservice",
                PackageAppInfo(
                    packageName = "com.coloros.ocs.opencapabilityservice",
                    appName = "OpenCapabilityService",
                    purpose = "Framework for cross-app feature sharing: clipboard sync, drag-and-drop, multi-window coordination.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "INTERACT_ACROSS_USERS",
                        "QUERY_ALL_PACKAGES",
                        "SYSTEM_ALERT_WINDOW"
                    ),
                    impactIfDisabled = "Some multi-app workflows may degrade; clipboard sync between apps may fail.",
                    notes = "ColorOS framework dependency. Test before keeping disabled."
                )
            )
            put(
                "com.coloros.operationManual",
                PackageAppInfo(
                    packageName = "com.coloros.operationManual",
                    appName = "Help & Feedback",
                    purpose = "In-device user manual, troubleshooting guides, and feedback submission portal.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("INTERNET", "READ_PHONE_STATE", "QUERY_ALL_PACKAGES"),
                    impactIfDisabled = "Help section in Settings shows generic Android help; feedback form inaccessible.",
                    replacements = listOf("OnePlus support website", "community forums"),
                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.operationManual"
                )
            )

            put(
                "com.coloros.scenemode",
                PackageAppInfo(
                    packageName = "com.coloros.scenemode",
                    appName = "Simple Mode",
                    purpose = "Elderly/accessible UI mode: larger icons, simplified layout, emergency contacts, reduced animations.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "MANAGE_USERS",
                        "WRITE_SECURE_SETTINGS",
                        "QUERY_ALL_PACKAGES"
                    ),
                    impactIfDisabled = "Simple Mode option disappears from Settings; no impact on standard UI.",
                    replacements = listOf("Big Launcher", "Simple Mode apps", "Android Accessibility settings"),
                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.scenemode"
                )
            )

            put(
                "com.coloros.sceneservice",
                PackageAppInfo(
                    packageName = "com.coloros.sceneservice",
                    appName = "Enhanced Smart Data Service",
                    purpose = "Context-aware optimizations: app pre-loading, battery scheduling, network prioritization based on usage patterns.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "READ_PHONE_STATE",
                        "INTERNET",                        "ACCESS_NETWORK_STATE"
                    ),
                    privacyNote = "Collects app usage patterns and time-of-day behavior for optimization.",
                    impactIfDisabled = "Adaptive battery/network features may degrade; minor battery life impact possible.",
                    replacements = listOf("Android Adaptive Battery", "AccuBattery", "manual optimization"),
                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.sceneservice"
                )
            )

            put(
                "com.coloros.smartsidebar",
                PackageAppInfo(
                    packageName = "com.coloros.smartsidebar",
                    appName = "Smart Sidebar",
                    purpose = "Edge-swipe panel for quick app shortcuts, tools (calculator, screen record), and floating windows.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "SYSTEM_ALERT_WINDOW",
                        "QUERY_ALL_PACKAGES",
                        "PACKAGE_USAGE_STATS"
                    ),
                    impactIfDisabled = "Smart Sidebar gesture stops working; all features accessible via other methods.",
                    replacements = listOf("Edge Panel", "Floating Apps", "built-in split-screen gestures"),
                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.smartsidebar"
                )
            )

            put(
                "com.coloros.systemclone",
                PackageAppInfo(
                    packageName = "com.coloros.systemclone",
                    appName = "System Cloner",
                    purpose = "Creates isolated second space/profile with separate apps, accounts, and data (privacy/work separation).",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "MANAGE_USERS",
                        "INTERACT_ACROSS_USERS",
                        "QUERY_ALL_PACKAGES",
                        "WRITE_SECURE_SETTINGS"
                    ),
                    impactIfDisabled = "System Cloner option disappears; Android Work Profile still available via Settings.",
                    replacements = listOf("Android Work Profile", "Shelter", "Island"),
                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.systemclone"
                )
            )
            put(
                "com.coloros.translate.engine",
                PackageAppInfo(
                    packageName = "com.coloros.translate.engine",
                    appName = "Translate Service",
                    purpose = "On-device translation engine for system-wide text translation, camera translation, and live subtitles.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "PROCESS_TEXT",
                        "CAMERA",
                        "INTERNET",
                        "READ_EXTERNAL_STORAGE"
                    ),
                    impactIfDisabled = "System translate options disappear; Google Translate still works independently.",
                    replacements = listOf("Google Translate", "Microsoft Translator", "DeepL"),
                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.translate.engine"
                )
            )

            put(
                "com.coloros.video",
                PackageAppInfo(
                    packageName = "com.coloros.video",
                    appName = "Videos (System)",
                    purpose = "ColorOS stock video player with hardware decoding, gesture controls, and cloud sync integration.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "READ_EXTERNAL_STORAGE",
                        "WRITE_EXTERNAL_STORAGE",
                        "INTERNET",
                        "ACCESS_NETWORK_STATE"
                    ),
                    impactIfDisabled = "Video files open in alternative player or chooser dialog.",
                    replacements = listOf("VLC", "MX Player", "Nova Video Player", "Just (Video) Player"),
                    removalCommand = "adb shell pm disable-user --user 0 com.coloros.video"
                )
            )

            put(
                "com.coloros.weather.service",
                PackageAppInfo(
                    packageName = "com.coloros.weather.service",
                    appName = "Weather Services",
                    purpose = "Background service for ColorOS weather widget, lock screen weather, and location-based forecasts.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.CRITICAL,                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "ACCESS_FINE_LOCATION",
                        "ACCESS_COARSE_LOCATION",
                        "INTERNET",
                        "RECEIVE_BOOT_COMPLETED"
                    ),
                    privacyNote = "Sends location data to weather provider (typically AccuWeather or The Weather Channel).",
                    impactIfDisabled = "⚠️ SYSTEM INSTABILITY: Weather widget shows 'No data'; may cause system service crashes or boot issues.",
                    notes = "CRITICAL: Core ColorOS service dependency. Do not remove."
                )
            )

            put(
                "com.oppo.quicksearchbox",
                PackageAppInfo(
                    packageName = "com.oppo.quicksearchbox",
                    appName = "Global Search",
                    purpose = "System-wide search bar for apps, contacts, settings, web results, and AI suggestions.",
                    category = AppCategory.COLOROS_OPPO,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "QUERY_ALL_PACKAGES",
                        "READ_CONTACTS",
                        "READ_CALL_LOG",
                        "INTERNET",
                        "ACCESS_FINE_LOCATION",
                        "PACKAGE_USAGE_STATS"
                    ),
                    privacyNote = "Indexes app usage, search history, and location for personalized results.",
                    impactIfDisabled = "Swipe-down search bar disappears; app drawer search still works.",
                    replacements = listOf("Google app search", "Kiss Launcher search", "built-in app drawer search"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oppo.quicksearchbox"
                )
            )

            put(
                "com.android.hotwordenrollment.okgoogle",
                PackageAppInfo(
                    packageName = "com.android.hotwordenrollment.okgoogle",
                    appName = "Ok Google Hotword Enrollment",
                    purpose = "Trains voice model for 'Ok Google' / 'Hey Google' voice activation.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,                    keyPermissions = listOf("RECORD_AUDIO", "PROCESS_OUTGOING_AUDIO", "INTERNET"),
                    privacyNote = "Records voice samples for voice matching; stores voice model locally.",
                    impactIfDisabled = "'Ok Google' hotword detection stops; Google Assistant still works via button/long-press.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.hotwordenrollment.okgoogle"
                )
            )

            put(
                "com.android.hotwordenrollment.xgoogle",
                PackageAppInfo(
                    packageName = "com.android.hotwordenrollment.xgoogle",
                    appName = "Hey Google Hotword Enrollment",
                    purpose = "Trains voice model for 'Hey Google' voice activation (variant).",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("RECORD_AUDIO", "PROCESS_OUTGOING_AUDIO", "INTERNET"),
                    privacyNote = "Records voice samples for voice matching; stores voice model locally.",
                    impactIfDisabled = "'Hey Google' hotword detection stops; Google Assistant still works manually.",
                    removalCommand = "adb shell pm disable-user --user 0 com.android.hotwordenrollment.xgoogle"
                )
            )

            put(
                "com.google.ambient.streaming",
                PackageAppInfo(
                    packageName = "com.google.ambient.streaming",
                    appName = "Cross-device Services",
                    purpose = "Enables cross-device continuity: handoff calls/media between phone, tablet, watch, and ChromeOS.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "BLUETOOTH_CONNECT",
                        "BLUETOOTH_SCAN",
                        "INTERNET",
                        "ACCESS_FINE_LOCATION",
                        "QUERY_ALL_PACKAGES"
                    ),
                    impactIfDisabled = "Call/media handoff stops; Nearby Share may lose some features.",
                    replacements = listOf("KDE Connect", "LocalSend for file sharing", "manual call transfer"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.ambient.streaming"
                )
            )

            put(
                "com.google.android.accessibility.switchaccess",
                PackageAppInfo(
                    packageName = "com.google.android.accessibility.switchaccess",
                    appName = "Switch Access",                    purpose = "Accessibility service for users with motor impairments: switch control, scanning selection, gesture alternatives.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "BIND_ACCESSIBILITY_SERVICE",
                        "SYSTEM_ALERT_WINDOW",
                        "INTERACT_ACROSS_USERS"
                    ),
                    impactIfDisabled = "Switch Access option disappears from Accessibility settings.",
                    replacements = listOf("Android's built-in accessibility suite (TalkBack, Voice Access)"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.accessibility.switchaccess"
                )
            )

            put(
                "com.google.android.aicore",
                PackageAppInfo(
                    packageName = "com.google.android.aicore",
                    appName = "AI Core",
                    purpose = "On-device AI inference engine for Google apps: smart replies, image recognition, voice processing, predictive text.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "INTERNET",
                        "PACKAGE_USAGE_STATS",
                        "READ_PHONE_STATE",
                        "RECORD_AUDIO"
                    ),
                    privacyNote = "Processes data locally but may send anonymized telemetry for model improvement.",
                    impactIfDisabled = "Smart Reply, Live Caption, Pixel-specific AI features may degrade or stop.",
                    notes = "Framework dependency for many Google AI features. Disable only if privacy-focused."
                )
            )

            put(
                "com.google.android.apps.bard",
                PackageAppInfo(
                    packageName = "com.google.android.apps.bard",
                    appName = "Gemini",
                    purpose = "Google's AI assistant app: chat, image generation, code help, document analysis, and voice interaction.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "INTERNET",
                        "CAMERA",
                        "RECORD_AUDIO",
                        "READ_EXTERNAL_STORAGE",                        "POST_NOTIFICATIONS"
                    ),
                    privacyNote = "Conversations may be reviewed for model training unless disabled in Google Account settings.",
                    impactIfDisabled = "Gemini app disappears; Google Assistant still works independently.",
                    replacements = listOf("Microsoft Copilot", "Claude", "Perplexity", "web access to gemini.google.com"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.bard"
                )
            )

            put(
                "com.google.android.apps.maps",
                PackageAppInfo(
                    packageName = "com.google.android.apps.maps",
                    appName = "Google Maps",
                    purpose = "Official Google Maps navigation, location services, transit info, and location-based recommendations.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "ACCESS_FINE_LOCATION",
                        "ACCESS_COARSE_LOCATION",
                        "CAMERA",
                        "READ_CONTACTS",
                        "READ_PHONE_STATE",
                        "ACTIVITY_RECOGNITION"
                    ),
                    impactIfDisabled = "Breaks location APIs for many apps; ride-sharing, food delivery, weather, and geofencing may fail.",
                    replacements = listOf("Organic Maps", "Magic Earth", "HERE WeGo"),
                    notes = "Many third-party apps rely on Google's location framework. Keep if using any location-dependent features."
                )
            )

            put(
                "com.google.android.apps.nbu.files",
                PackageAppInfo(
                    packageName = "com.google.android.apps.nbu.files",
                    appName = "Files by Google",
                    purpose = "File manager with cleaning tools, duplicate finder, offline sharing, and cloud backup integration.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "READ_EXTERNAL_STORAGE",
                        "WRITE_EXTERNAL_STORAGE",
                        "MANAGE_EXTERNAL_STORAGE",
                        "INTERNET",
                        "BLUETOOTH"
                    ),
                    impactIfDisabled = "'Files' app disappears; file management still possible via Settings or third-party apps.",
                    replacements = listOf("Solid Explorer", "Mixplorer", "CX File Explorer", "Amaze"),                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.nbu.files"
                )
            )

            put(
                "com.google.android.apps.nbu.paisa.user",
                PackageAppInfo(
                    packageName = "com.google.android.apps.nbu.paisa.user",
                    appName = "Google Pay (India)",
                    purpose = "UPI payment app for India: bank transfers, bill payments, recharges, and merchant payments.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "READ_SMS",
                        "READ_PHONE_STATE",
                        "CAMERA",
                        "ACCESS_FINE_LOCATION",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Google Pay UPI features unavailable; Google Wallet still works for cards.",
                    replacements = listOf("PhonePe", "Paytm", "BHIM", "bank-specific UPI apps"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.nbu.paisa.user",
                    notes = "Safe to remove if not in India or not using UPI."
                )
            )

            put(
                "com.google.android.apps.restore",
                PackageAppInfo(
                    packageName = "com.google.android.apps.restore",
                    appName = "Android Switch",
                    purpose = "Transfers data from old Android/iOS device during setup: apps, photos, contacts, settings.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "READ_EXTERNAL_STORAGE",
                        "GET_ACCOUNTS",
                        "INTERNET",
                        "BLUETOOTH",
                        "NFC"
                    ),
                    impactIfDisabled = "Zero impact post-setup; transfer feature won't reappear.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.restore"
                )
            )

            put(
                "com.google.android.apps.safetyhub",                PackageAppInfo(
                    packageName = "com.google.android.apps.safetyhub",
                    appName = "Personal Safety",
                    purpose = "Emergency features: crash detection, emergency sharing, safety check-ins, location alerts.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "ACCESS_FINE_LOCATION",
                        "ACTIVITY_RECOGNITION",
                        "CALL_PHONE",
                        "SEND_SMS",
                        "PROCESS_OUTGOING_CALLS"
                    ),
                    privacyNote = "Continuously monitors motion/location for crash detection; shares location with emergency contacts.",
                    impactIfDisabled = "Crash detection, emergency sharing, and safety check-ins stop.",
                    replacements = listOf("Third-party safety apps, but Google's integration is more seamless"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.safetyhub"
                )
            )

            put(
                "com.google.android.apps.setupwizard.searchselector",
                PackageAppInfo(
                    packageName = "com.google.android.apps.setupwizard.searchselector",
                    appName = "Search Engine Selector",
                    purpose = "Setup wizard screen for choosing default search engine (Google, DuckDuckGo, Bing, etc.).",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("QUERY_ALL_PACKAGES", "INTERNET"),
                    impactIfDisabled = "Zero impact post-setup; search engine can still be changed in Chrome/Android settings.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.setupwizard.searchselector"
                )
            )

            put(
                "com.google.android.apps.tachyon",
                PackageAppInfo(
                    packageName = "com.google.android.apps.tachyon",
                    appName = "Google Meet",
                    purpose = "Video conferencing app with screen sharing, live captions, background blur, and calendar integration.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "CAMERA",
                        "RECORD_AUDIO",
                        "INTERNET",
                        "READ_CONTACTS",                        "POST_NOTIFICATIONS"
                    ),
                    impactIfDisabled = "Meet app disappears; web access still works via browser.",
                    replacements = listOf("Zoom", "Microsoft Teams", "Signal", "Jitsi Meet", "web meet.google.com"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.tachyon"
                )
            )

            put(
                "com.google.android.apps.walletnfcrel",
                PackageAppInfo(
                    packageName = "com.google.android.apps.walletnfcrel",
                    appName = "Google Wallet",
                    purpose = "Digital wallet for payment cards, transit passes, boarding passes, loyalty cards, and digital keys.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "NFC",
                        "CAMERA",
                        "ACCESS_FINE_LOCATION",
                        "INTERNET",
                        "READ_PHONE_STATE",
                        "USE_BIOMETRIC"
                    ),
                    impactIfDisabled = "Google Pay/Wallet features stop; transit cards and boarding passes inaccessible.",
                    replacements = listOf("Samsung Pay", "bank-specific apps, but NFC payment integration is less seamless"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.walletnfcrel"
                )
            )

            put(
                "com.google.android.apps.wellbeing",
                PackageAppInfo(
                    packageName = "com.google.android.apps.wellbeing",
                    appName = "Digital Wellbeing",
                    purpose = "Screen time tracking, app timers, focus mode, bedtime mode, and usage insights.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "QUERY_ALL_PACKAGES",
                        "POST_NOTIFICATIONS",
                        "WRITE_SECURE_SETTINGS"
                    ),
                    privacyNote = "Tracks all app usage patterns and screen time; data stored locally unless synced to Google.",
                    impactIfDisabled = "Digital Wellbeing dashboard disappears; Focus Mode and Bedtime Mode stop.",
                    replacements = listOf("ActionDash", "StayFree", "YourHour", "manual tracking"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.wellbeing"                )
            )

            put(
                "com.google.android.apps.work.clouddpc",
                PackageAppInfo(
                    packageName = "com.google.android.apps.work.clouddpc",
                    appName = "Device Policy",
                    purpose = "Enterprise device management: enforces work policies, app restrictions, security configs, and remote wipe.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "MANAGE_DEVICE_ADMINS",
                        "MANAGE_USERS",
                        "WRITE_SECURE_SETTINGS",
                        "QUERY_ALL_PACKAGES",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Work profile setup fails; enterprise apps can't enforce policies.",
                    replacements = listOf("Microsoft Intune", "VMware Workspace ONE (but they require similar framework)"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.apps.work.clouddpc"
                )
            )

            put(
                "com.google.android.appsearch.apk",
                PackageAppInfo(
                    packageName = "com.google.android.appsearch.apk",
                    appName = "AppSearch",
                    purpose = "On-device app content indexing for faster search within apps, messages, and files.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "QUERY_ALL_PACKAGES",
                        "READ_EXTERNAL_STORAGE",
                        "PACKAGE_USAGE_STATS"
                    ),
                    impactIfDisabled = "In-app search may be slower; universal search results less comprehensive.",
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.appsearch.apk"
                )
            )

            put(
                "com.google.android.as",
                PackageAppInfo(
                    packageName = "com.google.android.as",
                    appName = "Personalization Services",
                    purpose = "Context Hub / Ambient Intelligence: powers Now Playing, Adaptive Battery, Live Caption, and predictive features.",                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "READ_PHONE_STATE",
                        "ACTIVITY_RECOGNITION",
                        "PROCESS_OUTGOING_AUDIO",
                        "INTERNET"
                    ),
                    privacyNote = "Analyzes usage patterns, audio snippets (for Now Playing), and context to personalize features.",
                    impactIfDisabled = "Now Playing, Live Caption, Adaptive Battery, and predictive suggestions stop or degrade.",
                    notes = "Core Android intelligence framework. Disable only if privacy-focused."
                )
            )

            put(
                "com.google.android.as.oss",
                PackageAppInfo(
                    packageName = "com.google.android.as.oss",
                    appName = "Personalization Services OSS",
                    purpose = "Open-source components for Google's Ambient Intelligence framework.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "READ_PHONE_STATE",
                        "ACTIVITY_RECOGNITION"
                    ),
                    impactIfDisabled = "May break features powered by com.google.android.as.",
                    notes = "Companion package to com.google.android.as. Disable together if privacy-focused."
                )
            )

            put(
                "com.google.android.calendar",
                PackageAppInfo(
                    packageName = "com.google.android.calendar",
                    appName = "Google Calendar",
                    purpose = "Official Google calendar app with sync, reminders, event suggestions, and Google Workspace integration.",
                    category = AppCategory.GOOGLE,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "READ_CALENDAR",
                        "WRITE_CALENDAR",
                        "GET_ACCOUNTS",
                        "READ_CONTACTS",
                        "INTERNET",                        "POST_NOTIFICATIONS"
                    ),
                    impactIfDisabled = "Calendar sync still works via system provider; only the app UI is removed.",
                    replacements = listOf("Etar", "Simple Calendar", "Outlook", "Proton Calendar"),
                    removalCommand = "adb shell pm disable-user --user 0 com.google.android.calendar"
                )
            )

            put(
                "com.heytap.accessory",
                PackageAppInfo(
                    packageName = "com.heytap.accessory",
                    appName = "Quick Connect",
                    purpose = "Connects OnePlus devices to HeyTap ecosystem: smart home devices, wearables, and cross-device file sharing.",
                    category = AppCategory.HEYTAP_NEARME,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "BLUETOOTH_CONNECT",
                        "BLUETOOTH_SCAN",
                        "INTERNET",
                        "ACCESS_FINE_LOCATION",
                        "QUERY_ALL_PACKAGES"
                    ),
                    impactIfDisabled = "Quick Connect shortcuts disappear; HeyTap device pairing fails.",
                    replacements = listOf("Google Home", "Smart Life", "manufacturer apps"),
                    removalCommand = "adb shell pm disable-user --user 0 com.heytap.accessory"
                )
            )

            put(
                "com.heytap.browser",
                PackageAppInfo(
                    packageName = "com.heytap.browser",
                    appName = "Internet (HeyTap Browser)",
                    purpose = "ColorOS/HeyTap stock web browser with ad-blocking, video download, and cloud sync.",
                    category = AppCategory.HEYTAP_NEARME,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "INTERNET",
                        "CAMERA",
                        "RECORD_AUDIO",
                        "READ_EXTERNAL_STORAGE",
                        "ACCESS_FINE_LOCATION",
                        "QUERY_ALL_PACKAGES"                    ),
                    privacyNote = "May collect browsing history, search queries, and location for personalization.",
                    impactIfDisabled = "Browser app disappears; default browser falls back to Chrome or prompts for new default.",
                    replacements = listOf("Firefox", "Brave", "Cromite", "DuckDuckGo", "Chrome"),
                    removalCommand = "adb shell pm disable-user --user 0 com.heytap.browser"
                )
            )

            put(
                "com.heytap.cloud",
                PackageAppInfo(
                    packageName = "com.heytap.cloud",
                    appName = "HeyTap Cloud",
                    purpose = "OnePlus/ColorOS cloud backup: contacts, photos, notes, settings, and app data sync to HeyTap servers.",
                    category = AppCategory.HEYTAP_NEARME,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "GET_ACCOUNTS",
                        "READ_CONTACTS",
                        "READ_EXTERNAL_STORAGE",
                        "CAMERA",
                        "INTERNET",
                        "WAKE_LOCK"
                    ),
                    privacyNote = "Uploads personal data to HeyTap/OPPO servers; review privacy policy before enabling sync.",
                    impactIfDisabled = "HeyTap Cloud backup options disappear; Google backup still works.",
                    replacements = listOf("Google One", "Syncthing", "Nextcloud", "Dropbox"),
                    removalCommand = "adb shell pm disable-user --user 0 com.heytap.cloud"
                )
            )

            put(
                "com.heytap.colorfulengine",
                PackageAppInfo(
                    packageName = "com.heytap.colorfulengine",
                    appName = "Colorful Engine",
                    purpose = "Visual effects engine for ColorOS: dynamic wallpapers, theme animations, and UI transitions.",
                    category = AppCategory.HEYTAP_NEARME,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "READ_EXTERNAL_STORAGE",
                        "WAKE_LOCK",
                        "INTERNET"
                    ),
                    impactIfDisabled = "⚠️ UI INSTABILITY: Theme animations may break; UI transitions may fail; potential boot issues.",
                    notes = "CRITICAL: Core display rendering dependency. Do not remove."
                )
            )
            put(
                "com.heytap.htms",
                PackageAppInfo(
                    packageName = "com.heytap.htms",
                    appName = "HTMS",
                    purpose = "HeyTap Membership Service: manages HeyTap account, rewards, subscriptions, and promotional content.",
                    category = AppCategory.HEYTAP_NEARME,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "GET_ACCOUNTS",
                        "INTERNET",
                        "READ_PHONE_STATE",
                        "ACCESS_NETWORK_STATE"
                    ),
                    impactIfDisabled = "HeyTap membership features unavailable; no impact on core phone functions.",
                    removalCommand = "adb shell pm disable-user --user 0 com.heytap.htms"
                )
            )

            put(
                "com.heytap.market",
                PackageAppInfo(
                    packageName = "com.heytap.market",
                    appName = "HeyTap Market",
                    purpose = "HeyTap/OPPO app store: alternative to Play Store for regional apps, games, and OnePlus-exclusive content.",
                    category = AppCategory.HEYTAP_NEARME,
                    safetyLevel = SafetyLevel.BLOATWARE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "INSTALL_PACKAGES",
                        "QUERY_ALL_PACKAGES",
                        "INTERNET",
                        "READ_EXTERNAL_STORAGE",
                        "ACCESS_FINE_LOCATION"
                    ),
                    impactIfDisabled = "HeyTap Market app disappears; app updates must come from Play Store or sideloading.",
                    replacements = listOf("Google Play Store", "F-Droid", "Aurora Store", "Accrescent"),
                    removalCommand = "adb shell pm disable-user --user 0 com.heytap.market"
                )
            )

            put(
                "com.heytap.market.overlay",
                PackageAppInfo(
                    packageName = "com.heytap.market.overlay",
                    appName = "HeyTap Market Overlay",
                    purpose = "Resource overlay for HeyTap Market UI: theming, carrier configs, and regional customizations.",
                    category = AppCategory.HEYTAP_NEARME,                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "HeyTap Market UI may revert to defaults; functionality unchanged.",
                    removalCommand = "adb shell pm disable-user --user 0 com.heytap.market.overlay"
                )
            )

            put(
                "com.heytap.mcs",
                PackageAppInfo(
                    packageName = "com.heytap.mcs",
                    appName = "System Messages",
                    purpose = "HeyTap push notification service: delivers system alerts, promotional messages, and app notifications via HeyTap servers.",
                    category = AppCategory.HEYTAP_NEARME,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "INTERNET",
                        "RECEIVE_BOOT_COMPLETED",
                        "WAKE_LOCK",
                        "ACCESS_NETWORK_STATE"
                    ),
                    privacyNote = "May deliver promotional content; tracks notification engagement.",
                    impactIfDisabled = "HeyTap push notifications stop; Google FCM notifications still work.",
                    replacements = listOf("Google Firebase Cloud Messaging (FCM)"),
                    removalCommand = "adb shell pm disable-user --user 0 com.heytap.mcs"
                )
            )

            put(
                "com.heytap.mydevices",
                PackageAppInfo(
                    packageName = "com.heytap.mydevices",
                    appName = "My Devices",
                    purpose = "HeyTap ecosystem device manager: tracks connected wearables, earbuds, and smart home devices; shows battery status and firmware updates.",
                    category = AppCategory.HEYTAP_NEARME,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "BLUETOOTH_CONNECT",
                        "BLUETOOTH_SCAN",
                        "ACCESS_FINE_LOCATION",
                        "INTERNET",
                        "QUERY_ALL_PACKAGES"
                    ),
                    impactIfDisabled = "My Devices app disappears; HeyTap device management unavailable.",
                    replacements = listOf("Google Home", "manufacturer apps (OnePlus Buds app, etc.)"),
                    removalCommand = "adb shell pm disable-user --user 0 com.heytap.mydevices"
                )            )

            put(
                "com.nearme.instant.platform",
                PackageAppInfo(
                    packageName = "com.nearme.instant.platform",
                    appName = "InstantWeb Service Framework",
                    purpose = "Lightweight app framework for instant apps and mini-programs: runs web-based apps without full installation.",
                    category = AppCategory.HEYTAP_NEARME,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "INTERNET",
                        "QUERY_ALL_PACKAGES",
                        "READ_EXTERNAL_STORAGE"
                    ),
                    impactIfDisabled = "Instant apps/mini-programs won't launch; full app installation still works.",
                    removalCommand = "adb shell pm disable-user --user 0 com.nearme.instant.platform"
                )
            )

            put(
                "com.microsoft.appmanager",
                PackageAppInfo(
                    packageName = "com.microsoft.appmanager",
                    appName = "Microsoft Phone Link",
                    purpose = "Links Android phone to Windows PC: syncs notifications, messages, photos, calls, and enables remote control features.",
                    category = AppCategory.MICROSOFT,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "READ_SMS",
                        "READ_CALL_LOG",
                        "READ_CONTACTS",
                        "CAMERA",
                        "INTERNET",
                        "BLUETOOTH_CONNECT",
                        "ACCESS_FINE_LOCATION",
                        "QUERY_ALL_PACKAGES"
                    ),
                    privacyNote = "Shares SMS, call logs, contacts, and photos with Microsoft servers; review privacy policy before enabling.",
                    impactIfDisabled = "Phone Link app disappears; Windows PC won't sync with phone; all features unavailable.",
                    replacements = listOf("KDE Connect", "LocalSend", "Snapdrop", "manual file transfer"),
                    removalCommand = "adb shell pm disable-user --user 0 com.microsoft.appmanager"
                )
            )
            put(
                "com.microsoft.deviceintegrationservice",
                PackageAppInfo(
                    packageName = "com.microsoft.deviceintegrationservice",
                    appName = "Microsoft Device Integration Service",
                    purpose = "Background service for Microsoft ecosystem: enables cross-device features, account sync, and telemetry for Phone Link.",
                    category = AppCategory.MICROSOFT,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "INTERNET",
                        "ACCESS_NETWORK_STATE",
                        "RECEIVE_BOOT_COMPLETED",
                        "QUERY_ALL_PACKAGES",
                        "PACKAGE_USAGE_STATS"
                    ),
                    impactIfDisabled = "Phone Link background sync stops; cross-device features degrade.",
                    removalCommand = "adb shell pm disable-user --user 0 com.microsoft.deviceintegrationservice"
                )
            )

            put(
                "com.microsoftsdk.crossdeviceservicebroker",
                PackageAppInfo(
                    packageName = "com.microsoftsdk.crossdeviceservicebroker",
                    appName = "Microsoft Cross-Device Service Broker",
                    purpose = "SDK framework for cross-device communication: enables handoff, file sharing, and notification sync between Android and Windows.",
                    category = AppCategory.MICROSOFT,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "BLUETOOTH_CONNECT",
                        "INTERNET",
                        "ACCESS_NETWORK_STATE",
                        "QUERY_ALL_PACKAGES"
                    ),
                    impactIfDisabled = "Cross-device handoff features stop; no impact on core phone functionality.",
                    replacements = listOf("KDE Connect", "Nearby Share", "LocalSend"),
                    removalCommand = "adb shell pm disable-user --user 0 com.microsoftsdk.crossdeviceservicebroker"
                )
            )

            put(
                "com.oneplus.account",
                PackageAppInfo(
                    packageName = "com.oneplus.account",
                    appName = "OnePlus Account",
                    purpose = "Manages OnePlus account integration: cloud sync, membership benefits, device registration, and community features.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "GET_ACCOUNTS",
                        "INTERNET",
                        "READ_PHONE_STATE",
                        "ACCESS_NETWORK_STATE",
                        "READ_CONTACTS"
                    ),
                    privacyNote = "Syncs contacts, device info, and usage data to OnePlus servers.",
                    impactIfDisabled = "OnePlus cloud features unavailable; membership benefits inaccessible; community features stop.",
                    replacements = listOf("Google account sync", "OnePlus website for membership"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oneplus.account"
                )
            )

            put(
                "com.oneplus.calculator",
                PackageAppInfo(
                    packageName = "com.oneplus.calculator",
                    appName = "Calculator",
                    purpose = "Stock calculator app with basic arithmetic, scientific mode, currency conversion, and unit conversion.",                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("INTERNET"),
                    impactIfDisabled = "Calculator app disappears; all functions available via third-party apps or Google search.",
                    replacements = listOf("Google Calculator", "Real Calculator", "Calculator++", "web search"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oneplus.calculator"
                )
            )

            put(
                "com.oneplus.colorx",
                PackageAppInfo(
                    packageName = "com.oneplus.colorx",
                    appName = "ColorX Graphics Enhancement",
                    purpose = "OnePlus display tuning service: enhances color accuracy, HDR processing, and adaptive brightness algorithms.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "WRITE_SECURE_SETTINGS",
                        "READ_EXTERNAL_STORAGE",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Display color tuning may revert to defaults; HDR content may render less accurately.",
                    notes = "Display calibration dependency. Keep unless you prefer stock Android color profile.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oneplus.colorx"
                )
            )

            put(
                "com.oneplus.deskclock",
                PackageAppInfo(
                    packageName = "com.oneplus.deskclock",
                    appName = "Clock",
                    purpose = "Stock clock app: alarms, timers, stopwatch, world clock, and bedtime mode with OnePlus UI customizations.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "RECEIVE_BOOT_COMPLETED",
                        "WAKE_LOCK",
                        "VIBRATE",
                        "POST_NOTIFICATIONS"
                    ),
                    impactIfDisabled = "Clock app disappears; alarms/timers stop; system time functions unaffected.",
                    replacements = listOf("Google Clock", "Alarmy", "Timely", "built-in alarm via Google Assistant"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oneplus.deskclock"
                )
            )
            put(
                "com.oneplus.filemanager",
                PackageAppInfo(
                    packageName = "com.oneplus.filemanager",
                    appName = "My Files",
                    purpose = "Stock file manager: browse internal/external storage, manage files, cloud integration, and cleanup tools.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "MANAGE_EXTERNAL_STORAGE",
                        "READ_EXTERNAL_STORAGE",
                        "WRITE_EXTERNAL_STORAGE",
                        "INTERNET",
                        "ACCESS_NETWORK_STATE"
                    ),
                    impactIfDisabled = "File manager app disappears; file access still works via Settings or third-party apps.",
                    replacements = listOf("Solid Explorer", "Mixplorer", "CX File Explorer", "Files by Google"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oneplus.filemanager"
                )
            )

            put(
                "com.oneplus.gallery",
                PackageAppInfo(
                    packageName = "com.oneplus.gallery",
                    appName = "Photos (OnePlus)",
                    purpose = "OnePlus stock gallery: photo/video viewing, editing tools, album organization, and cloud sync integration.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "READ_MEDIA_IMAGES",
                        "READ_MEDIA_VIDEO",
                        "CAMERA",
                        "INTERNET",
                        "ACCESS_FINE_LOCATION",
                        "POST_NOTIFICATIONS"
                    ),
                    privacyNote = "May upload photo metadata to OnePlus servers if cloud sync enabled.",
                    impactIfDisabled = "Gallery app disappears; photos still accessible via Google Photos or third-party apps.",
                    replacements = listOf("Google Photos", "Simple Gallery", "F-Stop", "AGallery"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oneplus.gallery"
                )
            )

            put(
                "com.oneplus.membership",
                PackageAppInfo(                    packageName = "com.oneplus.membership",
                    appName = "OnePlus Membership",
                    purpose = "Manages OnePlus membership benefits: exclusive offers, early access, community perks, and loyalty rewards.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "GET_ACCOUNTS",
                        "INTERNET",
                        "READ_PHONE_STATE",
                        "ACCESS_NETWORK_STATE"
                    ),
                    impactIfDisabled = "Membership features unavailable; no impact on core phone functionality.",
                    replacements = listOf("OnePlus website for membership management"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oneplus.membership"
                )
            )

            put(
                "com.oneplus.oshare",
                PackageAppInfo(
                    packageName = "com.oneplus.oshare",
                    appName = "OShare",
                    purpose = "OnePlus file sharing service: fast local file transfer between OnePlus devices via Wi-Fi Direct.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "BLUETOOTH_CONNECT",
                        "BLUETOOTH_SCAN",
                        "ACCESS_FINE_LOCATION",
                        "INTERNET",
                        "READ_EXTERNAL_STORAGE"
                    ),
                    impactIfDisabled = "OShare file transfer unavailable; Nearby Share and other methods still work.",
                    replacements = listOf("Nearby Share", "Send Anywhere", "LocalSend", "SHAREit"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oneplus.oshare"
                )
            )

            put(
                "com.oplus.aimemory",
                PackageAppInfo(
                    packageName = "com.oplus.aimemory",
                    appName = "Mind Space",
                    purpose = "AI-powered memory optimization: predicts app usage, pre-loads frequently used apps, and manages RAM allocation.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(                        "PACKAGE_USAGE_STATS",
                        "QUERY_ALL_PACKAGES",
                        "INTERNET",
                        "READ_PHONE_STATE"
                    ),
                    privacyNote = "Analyzes app usage patterns for optimization; may send anonymized data to OnePlus.",
                    impactIfDisabled = "App launch times may increase slightly; RAM management less aggressive.",
                    replacements = listOf("Android Adaptive Memory", "manual app management"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.aimemory"
                )
            )

            put(
                "com.oplus.aiunit",
                PackageAppInfo(
                    packageName = "com.oplus.aiunit",
                    appName = "AI Service Engine",
                    purpose = "Core AI processing framework: powers on-device AI features like scene recognition, voice enhancement, and predictive text.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "RECORD_AUDIO",
                        "CAMERA",
                        "PACKAGE_USAGE_STATS",
                        "INTERNET",
                        "READ_PHONE_STATE"
                    ),
                    privacyNote = "Processes audio/camera data locally; may send anonymized model improvements to OnePlus.",
                    impactIfDisabled = "Camera AI, voice enhancement, and predictive features degrade or stop.",
                    notes = "OnePlus AI framework dependency. Disable only if privacy-focused.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.aiunit"
                )
            )

            put(
                "com.oplus.aiwriter",
                PackageAppInfo(
                    packageName = "com.oplus.aiwriter",
                    appName = "AI Writer",
                    purpose = "AI-powered text generation: assists with writing emails, messages, documents, and social media posts.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "INTERNET",
                        "READ_EXTERNAL_STORAGE",
                        "WRITE_EXTERNAL_STORAGE",
                        "PROCESS_TEXT"
                    ),                    privacyNote = "Text input may be processed via OnePlus/Google servers for AI generation.",
                    impactIfDisabled = "AI Writer feature disappears from keyboard and system apps.",
                    replacements = listOf("Google Gemini", "Microsoft Copilot", "Claude", "manual writing"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.aiwriter"
                )
            )

            put(
                "com.oplus.ambient.livealert",
                PackageAppInfo(
                    packageName = "com.oplus.ambient.livealert",
                    appName = "LiveSports",
                    purpose = "Live sports notifications: real-time scores, match alerts, and highlights for followed teams/leagues.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "INTERNET",
                        "ACCESS_NETWORK_STATE",
                        "POST_NOTIFICATIONS",
                        "RECEIVE_BOOT_COMPLETED"
                    ),
                    privacyNote = "Tracks sports preferences and notification engagement.",
                    impactIfDisabled = "Live sports alerts stop; no impact on core functionality.",
                    replacements = listOf("ESPN", "theScore", "Google Sports", "team-specific apps"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.ambient.livealert"
                )
            )

            put(
                "com.oplus.aod",
                PackageAppInfo(
                    packageName = "com.oplus.aod",
                    appName = "AOD (Always-On Display)",
                    purpose = "Manages Always-On Display: clock styles, notifications preview, battery optimization for AMOLED screen.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "SYSTEM_ALERT_WINDOW",
                        "RECEIVE_BOOT_COMPLETED",
                        "WAKE_LOCK",
                        "POST_NOTIFICATIONS"
                    ),
                    impactIfDisabled = "Always-On Display stops working; lock screen still functions normally.",
                    replacements = listOf("AOE - Always On AMOLED", "Custom AOD", "built-in lock screen widgets"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.aod"
                )
            )
            put(
                "com.oplus.appplatform",
                PackageAppInfo(
                    packageName = "com.oplus.appplatform",
                    appName = "App Services",
                    purpose = "Framework for OnePlus app ecosystem: manages app lifecycle, cross-app communication, and OPLUS service integration.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "QUERY_ALL_PACKAGES",
                        "INTERACT_ACROSS_USERS",
                        "PACKAGE_USAGE_STATS",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Some OnePlus apps may lose integration features; app switching or multi-window may degrade.",
                    notes = "OnePlus framework dependency. Test before keeping disabled.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.appplatform"
                )
            )

            put(
                "com.oplus.apprecover",
                PackageAppInfo(
                    packageName = "com.oplus.apprecover",
                    appName = "Recover System Apps",
                    purpose = "Restores pre-installed system apps after factory reset or accidental removal.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "INSTALL_PACKAGES",
                        "QUERY_ALL_PACKAGES",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Auto-recovery of system apps stops; manual reinstallation still possible.",
                    replacements = listOf("Manual APK installation", "ADB commands"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.apprecover"
                )
            )

            put(
                "com.oplus.appsense",
                PackageAppInfo(
                    packageName = "com.oplus.appsense",
                    appName = "AppSense",
                    purpose = "App usage analytics: tracks app launch frequency, session duration, and crash reporting for OnePlus optimization.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "QUERY_ALL_PACKAGES",
                        "INTERNET",
                        "READ_LOGS"
                    ),
                    privacyNote = "Sends anonymized app usage data to OnePlus servers.",
                    impactIfDisabled = "App optimization telemetry stops; no user-visible impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.appsense"
                )
            )

            put(
                "com.oplus.athena",
                PackageAppInfo(
                    packageName = "com.oplus.athena",
                    appName = "Athena",
                    purpose = "OnePlus AI optimization engine: predicts user behavior, pre-loads apps, manages resource allocation for performance.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "QUERY_ALL_PACKAGES",
                        "INTERNET",
                        "READ_PHONE_STATE",
                        "ACTIVITY_RECOGNITION"
                    ),
                    privacyNote = "Analyzes app usage patterns and time-of-day behavior for predictive optimization.",
                    impactIfDisabled = "⚠️ BOOTLOOP/STABILITY RISK: May break gesture navigation, app predictions, and system stability.",
                    notes = "CRITICAL: Core AI optimization dependency. Do not remove.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.athena"
                )
            )

            put(
                "com.oplus.atlas",
                PackageAppInfo(
                    packageName = "com.oplus.atlas",
                    appName = "Atlas Service",
                    purpose = "System resource scheduler: manages CPU/GPU frequency, thermal throttling, and performance profiles.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "WRITE_SECURE_SETTINGS",
                        "PACKAGE_USAGE_STATS",
                        "INTERNET",
                        "READ_PHONE_STATE"
                    ),                    impactIfDisabled = "Performance tuning may revert to defaults; gaming mode or battery optimization may degrade.",
                    notes = "Performance framework dependency. Keep for stability.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.atlas"
                )
            )

            put(
                "com.oplus.audio.effectcenter",
                PackageAppInfo(
                    packageName = "com.oplus.audio.effectcenter",
                    appName = "Audio Effect Center",
                    purpose = "OnePlus audio enhancement: Dolby Atmos tuning, spatial audio, equalizer presets, and headphone optimization.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "MODIFY_AUDIO_SETTINGS",
                        "RECORD_AUDIO",
                        "BLUETOOTH_CONNECT",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Audio enhancements disappear; headphones may lose OnePlus-specific tuning.",
                    replacements = listOf("Wavelet", "Poweramp Equalizer", "Flat Equalizer", "ViPER4Android"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.audio.effectcenter"
                )
            )

            put(
                "com.oplus.battery",
                PackageAppInfo(
                    packageName = "com.oplus.battery",
                    appName = "Battery",
                    purpose = "OnePlus battery management: adaptive charging, battery health monitoring, power saving modes, and usage analytics.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "BATTERY_STATS",
                        "PACKAGE_USAGE_STATS",
                        "WRITE_SECURE_SETTINGS",
                        "INTERNET"
                    ),
                    privacyNote = "Collects battery usage patterns and charging behavior for optimization.",
                    impactIfDisabled = "Adaptive charging stops; battery health monitoring unavailable; power saving modes may degrade.",
                    replacements = listOf("AccuBattery", "Battery Guru"),
                    notes = "System-level optimization dependency. Keep for battery health.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.battery"
                )
            )
            put(
                "com.oplus.beaconlink",
                PackageAppInfo(
                    packageName = "com.oplus.beaconlink",
                    appName = "BeaconLink",
                    purpose = "Bluetooth beacon detection: enables location-based triggers, smart home automation, and proximity actions.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "BLUETOOTH_SCAN",
                        "BLUETOOTH_CONNECT",
                        "ACCESS_FINE_LOCATION",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Beacon-triggered actions stop; Bluetooth functionality otherwise unaffected.",
                    replacements = listOf("Beacon Simulator", "Locate BE", "manual automation"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.beaconlink"
                )
            )

            put(
                "com.oplus.blur",
                PackageAppInfo(
                    packageName = "com.oplus.blur",
                    appName = "Blur",
                    purpose = "Visual blur effects engine: powers background blur in notifications, control center, and UI transitions.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "UI blur effects may fallback to solid colors; no functional impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.blur"
                )
            )

            put(
                "com.oplus.bootreg.res.overlay",
                PackageAppInfo(
                    packageName = "com.oplus.bootreg.res.overlay",
                    appName = "BootReg Resource Overlay",
                    purpose = "Resource overlay for startup wizard theming and carrier-specific setup customizations.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Zero impact after initial device setup.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.bootreg.res.overlay"
                )
            )
            put(
                "com.oplus.bttestmode",
                PackageAppInfo(
                    packageName = "com.oplus.bttestmode",
                    appName = "BT Test Mode",
                    purpose = "Bluetooth testing/debugging tool: used by engineers for RF testing, codec validation, and connectivity diagnostics.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "BLUETOOTH",
                        "BLUETOOTH_ADMIN",
                        "WRITE_SECURE_SETTINGS"
                    ),
                    impactIfDisabled = "Zero user impact; only affects engineering diagnostics.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.bttestmode"
                )
            )

            put(
                "com.oplus.callrecorder",
                PackageAppInfo(
                    packageName = "com.oplus.callrecorder",
                    appName = "Call Recording",
                    purpose = "Built-in call recording: records phone calls with auto-start, cloud backup, and transcription options.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "RECORD_AUDIO",
                        "READ_PHONE_STATE",
                        "PROCESS_OUTGOING_CALLS",
                        "READ_CALL_LOG",
                        "WRITE_EXTERNAL_STORAGE"
                    ),
                    privacyNote = "Legal consideration: Call recording laws vary by region; ensure compliance before use.",
                    impactIfDisabled = "Call recording option disappears from dialer; calls still function normally.",
                    replacements = listOf("Cube ACR", "Call Recorder - SKVALEX", "Automatic Call Recorder"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.callrecorder"
                )
            )

            put(
                "com.oplus.camera",
                PackageAppInfo(
                    packageName = "com.oplus.camera",
                    appName = "Camera",
                    purpose = "OnePlus stock camera app: photo/video capture, Night Mode, Portrait, Pro mode, and hardware-level camera optimizations.",
                    category = AppCategory.ONEPLUS_OPLUS,                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "CAMERA",
                        "RECORD_AUDIO",
                        "READ_EXTERNAL_STORAGE",
                        "WRITE_EXTERNAL_STORAGE",
                        "ACCESS_FINE_LOCATION",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Stock camera app disappears; camera hardware still accessible via other apps but may lose OnePlus-specific optimizations.",
                    replacements = listOf("Google Camera (GCam)", "Open Camera", "ProShot", "Filmic Pro"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.camera"
                )
            )

            put(
                "com.oplus.cast",
                PackageAppInfo(
                    packageName = "com.oplus.cast",
                    appName = "Screencast",
                    purpose = "Wireless display casting: Miracast, DLNA, and OnePlus-specific screen mirroring to TVs/monitors.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "INTERNET",
                        "ACCESS_NETWORK_STATE",
                        "BLUETOOTH_CONNECT",
                        "SYSTEM_ALERT_WINDOW"
                    ),
                    impactIfDisabled = "Wireless cast option disappears from Quick Settings; Chromecast still works via Google Home.",
                    replacements = listOf("Google Home (Chromecast)", "ApowerMirror", "Scrcpy (wired)"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.cast"
                )
            )

            put(
                "com.oplus.cell.map",
                PackageAppInfo(
                    packageName = "com.oplus.cell.map",
                    appName = "Cell Map",
                    purpose = "Cellular network mapping: tracks cell tower locations, signal strength heatmaps, and roaming optimization.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "ACCESS_FINE_LOCATION",
                        "READ_PHONE_STATE",
                        "ACCESS_NETWORK_STATE",                        "INTERNET"
                    ),
                    privacyNote = "Collects location and network data for coverage optimization.",
                    impactIfDisabled = "Network optimization may use generic data; no visible impact for most users.",
                    replacements = listOf("Network Cell Info", "OpenSignal"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.cell.map"
                )
            )

            put(
                "com.oplus.cellularqoe",
                PackageAppInfo(
                    packageName = "com.oplus.cellularqoe",
                    appName = "CellularQoe",
                    purpose = "Cellular Quality of Experience optimizer: monitors signal strength, manages network switching, and improves call/data reliability.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "READ_PHONE_STATE",
                        "ACCESS_NETWORK_STATE",
                        "CHANGE_NETWORK_STATE",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Network switching may become less intelligent; call quality or data stability may slightly degrade.",
                    notes = "Network optimization dependency. Test before keeping disabled.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.cellularqoe"
                )
            )

            put(
                "com.oplus.contentportal",
                PackageAppInfo(
                    packageName = "com.oplus.contentportal",
                    appName = "Content Portal",
                    purpose = "OnePlus content aggregator: delivers news, videos, promotions, and personalized recommendations in system apps.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "INTERNET",
                        "ACCESS_NETWORK_STATE",
                        "QUERY_ALL_PACKAGES",
                        "PACKAGE_USAGE_STATS"
                    ),
                    privacyNote = "Tracks content engagement and app usage for personalized recommendations.",
                    impactIfDisabled = "Content recommendations disappear from system apps; core functionality unaffected.",
                    replacements = listOf("Google Discover", "Feedly", "manual content browsing"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.contentportal"
                )            )

            put(
                "com.oplus.cosa",
                PackageAppInfo(
                    packageName = "com.oplus.cosa",
                    appName = "Cosa",
                    purpose = "OnePlus component service framework: manages modular app components, dynamic feature loading, and plugin architecture.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "QUERY_ALL_PACKAGES",
                        "INTERNET",
                        "READ_EXTERNAL_STORAGE"
                    ),
                    impactIfDisabled = "Some OnePlus app features may fail to load dynamically; minor functionality loss possible.",
                    notes = "OnePlus app framework dependency. Test before keeping disabled.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.cosa"
                )
            )

            put(
                "com.oplus.cota",
                PackageAppInfo(
                    packageName = "com.oplus.cota",
                    appName = "Configuration Update",
                    purpose = "OnePlus configuration OTA: delivers carrier settings, feature flags, and regional optimizations without full OS updates.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "INTERNET",
                        "RECEIVE_BOOT_COMPLETED",
                        "WRITE_SECURE_SETTINGS",
                        "READ_PHONE_STATE"
                    ),
                    impactIfDisabled = "Carrier settings and feature updates won't apply automatically; may miss regional optimizations.",
                    notes = "Keep for updates. Critical for carrier compatibility.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.cota"
                )
            )

            put(
                "com.oplus.crashbox",
                PackageAppInfo(
                    packageName = "com.oplus.crashbox",
                    appName = "Crashbox",
                    purpose = "Crash reporting and diagnostic collector: captures app/system crashes, ANRs, and sends logs to OnePlus for analysis.",
                    category = AppCategory.ONEPLUS_OPLUS,                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "READ_LOGS",
                        "PACKAGE_USAGE_STATS",
                        "INTERNET",
                        "READ_PHONE_STATE"
                    ),
                    privacyNote = "Sends crash logs and device state data to OnePlus servers.",
                    impactIfDisabled = "Crash reports not sent to OnePlus; no user-visible impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.crashbox"
                )
            )

            put(
                "com.oplus.customize.coreapp",
                PackageAppInfo(
                    packageName = "com.oplus.customize.coreapp",
                    appName = "Customize Core App",
                    purpose = "OnePlus customization framework: manages regional variants, carrier-specific features, and OEM branding.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "READ_PHONE_STATE",
                        "INTERNET",
                        "QUERY_ALL_PACKAGES"
                    ),
                    impactIfDisabled = "Regional/carrier features may revert to defaults; minor UI inconsistencies possible.",
                    notes = "Keep for stability. Core customization dependency.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.customize.coreapp"
                )
            )

            put(
                "com.oplus.deepthinker",
                PackageAppInfo(
                    packageName = "com.oplus.deepthinker",
                    appName = "Intelligent Services",
                    purpose = "OnePlus AI context engine: powers Smart Sidebar suggestions, app recommendations, and predictive actions based on usage.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "QUERY_ALL_PACKAGES",
                        "READ_PHONE_STATE",
                        "INTERNET",
                        "ACCESS_FINE_LOCATION"
                    ),                    privacyNote = "Analyzes app usage, location patterns, and time-of-day behavior for personalized suggestions.",
                    impactIfDisabled = "Smart Sidebar suggestions stop; app recommendations become generic; predictive features degrade.",
                    replacements = listOf("Manual app management"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.deepthinker"
                )
            )

            put(
                "com.oplus.dfs",
                PackageAppInfo(
                    packageName = "com.oplus.dfs",
                    appName = "DFS (Distributed File System)",
                    purpose = "OnePlus cloud file sync framework: enables seamless file access across OnePlus devices and cloud storage.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "MANAGE_EXTERNAL_STORAGE",
                        "INTERNET",
                        "GET_ACCOUNTS",
                        "ACCESS_NETWORK_STATE"
                    ),
                    impactIfDisabled = "Cross-device file sync stops; local file management unaffected.",
                    replacements = listOf("Google Drive", "Syncthing", "Nextcloud"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.dfs"
                )
            )

            put(
                "com.oplus.dmp",
                PackageAppInfo(
                    packageName = "com.oplus.dmp",
                    appName = "DMP (Device Management Platform)",
                    purpose = "OnePlus device management framework: handles enterprise policies, remote configuration, and MDM integration.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "MANAGE_USERS",
                        "WRITE_SECURE_SETTINGS",
                        "QUERY_ALL_PACKAGES",
                        "INTERNET",
                        "READ_PHONE_STATE"
                    ),
                    impactIfDisabled = "Enterprise device management features fail; work profile policies may not apply.",
                    replacements = listOf("Microsoft Intune", "VMware Workspace ONE"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.dmp"
                )
            )
            put(
                "com.oplus.eid",
                PackageAppInfo(
                    packageName = "com.oplus.eid",
                    appName = "Eid-Service",
                    purpose = "Electronic ID service: enables digital identity verification, e-signatures, and government ID integration (region-specific).",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "USE_BIOMETRIC",
                        "READ_PHONE_STATE",
                        "INTERNET",
                        "ACCESS_NETWORK_STATE"
                    ),
                    impactIfDisabled = "⚠️ SECURITY RISK: Digital ID verification stops; e-signature features unavailable; may break secure authentication flows.",
                    notes = "CRITICAL: Security service dependency. Do not remove.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.eid"
                )
            )

            put(
                "com.oplus.encryption",
                PackageAppInfo(
                    packageName = "com.oplus.encryption",
                    appName = "Private Safe",
                    purpose = "OnePlus Private Safe: encrypted vault for photos, videos, files, and notes with password/biometric protection.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "USE_BIOMETRIC",
                        "USE_FINGERPRINT",
                        "READ_EXTERNAL_STORAGE",
                        "WRITE_EXTERNAL_STORAGE",
                        "CAMERA",
                        "RECORD_AUDIO"
                    ),
                    impactIfDisabled = "Private Safe vault becomes inaccessible; encrypted files cannot be decrypted or accessed.",
                    replacements = listOf("Cryptomator", "EDS Lite", "Folder Lock"),
                    notes = "CRITICAL: Encryption dependency. Do not remove if using Private Safe.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.encryption"
                )
            )

            put(
                "com.oplus.engineercamera",
                PackageAppInfo(
                    packageName = "com.oplus.engineercamera",
                    appName = "Engineer Camera",                    purpose = "Engineering/debug camera mode: used by technicians for sensor calibration, focus testing, and hardware diagnostics.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "CAMERA",
                        "WRITE_SECURE_SETTINGS",
                        "READ_PHONE_STATE",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Zero user impact; only affects engineering diagnostics and factory calibration.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.engineercamera"
                )
            )

            put(
                "com.oplus.engineermode",
                PackageAppInfo(
                    packageName = "com.oplus.engineermode",
                    appName = "Commercial Engineer Mode",
                    purpose = "Engineering test suite: hardware diagnostics, sensor testing, network validation, and factory QA tools.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "CAMERA",
                        "RECORD_AUDIO",
                        "BLUETOOTH",
                        "ACCESS_FINE_LOCATION",
                        "WRITE_SECURE_SETTINGS",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Zero user impact; engineering menus disappear from dialer codes (*#808#).",
                    replacements = listOf("Phone Info", "Device Info HW", "CPU-Z"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.engineermode"
                )
            )

            put(
                "com.oplus.engineernetwork",
                PackageAppInfo(
                    packageName = "com.oplus.engineernetwork",
                    appName = "Engineer Network",
                    purpose = "Network engineering tools: signal strength testing, band locking, modem diagnostics, and carrier validation.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "READ_PHONE_STATE",
                        "CHANGE_NETWORK_STATE",                        "ACCESS_NETWORK_STATE",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Zero user impact; network engineering menus disappear.",
                    replacements = listOf("Network Cell Info", "LTE Discovery", "G-NetTrack"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.engineernetwork"
                )
            )

            put(
                "com.oplus.exsystemservice",
                PackageAppInfo(
                    packageName = "com.oplus.exsystemservice",
                    appName = "ExSystemService",
                    purpose = "Extended system service framework: manages cross-process communication, background task scheduling, and OEM service integration.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "INTERACT_ACROSS_USERS",
                        "QUERY_ALL_PACKAGES",
                        "PACKAGE_USAGE_STATS",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Some OnePlus background services may fail; app switching or multitasking may degrade.",
                    notes = "OnePlus framework dependency. Test before keeping disabled.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.exsystemservice"
                )
            )

            put(
                "com.oplus.eyeprotect",
                PackageAppInfo(
                    packageName = "com.oplus.eyeprotect",
                    appName = "Eye Comfort",
                    purpose = "Blue light filter and eye protection: adjusts screen color temperature, enables reading mode, and schedules eye comfort based on time.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "WRITE_SECURE_SETTINGS",
                        "RECEIVE_BOOT_COMPLETED",
                        "WAKE_LOCK"
                    ),
                    impactIfDisabled = "Eye Comfort toggle disappears from Quick Settings; screen color temperature reverts to defaults.",
                    replacements = listOf("Twilight", "Blue Light Filter", "Night Mode", "built-in Android Night Light"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.eyeprotect"
                )
            )
            put(
                "com.oplus.framework.res.overlay",
                PackageAppInfo(
                    packageName = "com.oplus.framework.res.overlay",
                    appName = "Framework Resource Overlay",
                    purpose = "OnePlus-specific resource overlays for display, Bluetooth, and SystemUI theming; customizes UI behavior per device/carrier.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "UI theming may revert to stock Android; OnePlus-specific animations or layouts may break.",
                    notes = "Keep for stability. Test-remove only duplicates.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.framework.res.overlay"
                )
            )

            put(
                "com.oplus.framework.rro.oneplus",
                PackageAppInfo(
                    packageName = "com.oplus.framework.rro.oneplus",
                    appName = "Framework RRO OnePlus",
                    purpose = "Runtime Resource Overlay for OnePlus-specific UI customizations across system apps.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "OnePlus visual customizations may revert to stock Android appearance.",
                    notes = "Keep for visual consistency. Test before keeping disabled.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.framework.rro.oneplus"
                )
            )

            put(
                "com.oplus.framework_bluetooth.overlay",
                PackageAppInfo(
                    packageName = "com.oplus.framework_bluetooth.overlay",
                    appName = "Framework Bluetooth Overlay",
                    purpose = "OnePlus-specific Bluetooth resource overlay for codec priorities and connection stability.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Bluetooth may fall back to generic Android behavior; codec settings may become less granular.",
                    notes = "Keep if using premium Bluetooth headphones.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.framework_bluetooth.overlay"
                )
            )

            put(
                "com.oplus.games",                PackageAppInfo(
                    packageName = "com.oplus.games",
                    appName = "Games (Game Space)",
                    purpose = "OnePlus Game Space: gaming optimization hub with performance modes, Do Not Disturb, screen recording, and macro support.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "SYSTEM_ALERT_WINDOW",
                        "RECORD_AUDIO",
                        "WRITE_SECURE_SETTINGS",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Game Space launcher disappears; gaming optimizations (performance mode, block notifications) stop.",
                    replacements = listOf("GFX Tool", "Game Booster", "manual performance settings"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.games"
                )
            )

            put(
                "com.oplus.gesture",
                PackageAppInfo(
                    packageName = "com.oplus.gesture",
                    appName = "Gestures & Motions",
                    purpose = "Gesture recognition engine: powers swipe gestures, shake actions, double-tap wake, and motion-based shortcuts.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "BODY_SENSORS",
                        "ACTIVITY_RECOGNITION",
                        "SYSTEM_ALERT_WINDOW",
                        "RECEIVE_BOOT_COMPLETED"
                    ),
                    impactIfDisabled = "Gesture shortcuts stop; basic navigation gestures still work via SystemUI.",
                    replacements = listOf("Built-in Android gestures", "Gesture Control", "Macrodroid"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.gesture"
                )
            )

            put(
                "com.oplus.healthservice",
                PackageAppInfo(
                    packageName = "com.oplus.healthservice",
                    appName = "Health Service",
                    purpose = "Health data aggregation: syncs fitness, sleep, heart rate data from wearables and health apps to OnePlus Health.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,                    keyPermissions = listOf(
                        "BODY_SENSORS",
                        "ACTIVITY_RECOGNITION",
                        "READ_HEALTH_DATA",
                        "INTERNET",
                        "BLUETOOTH_CONNECT"
                    ),
                    privacyNote = "Collects health metrics and activity patterns; may sync to OnePlus/HeyTap cloud.",
                    impactIfDisabled = "Health data sync stops; OnePlus Health app shows no data.",
                    replacements = listOf("Google Fit", "Samsung Health", "Health Connect"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.healthservice"
                )
            )

            put(
                "com.oplus.keyguard.clock.base",
                PackageAppInfo(
                    packageName = "com.oplus.keyguard.clock.base",
                    appName = "Keyguard Clock - Classic",
                    purpose = "Classic lock screen clock style resource for Always-On Display.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Classic clock style disappears from AOD settings; no functional impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.keyguard.clock.base"
                )
            )

            put(
                "com.oplus.keyguard.clock.gallery",
                PackageAppInfo(
                    packageName = "com.oplus.keyguard.clock.gallery",
                    appName = "Keyguard Clock - Snapshot",
                    purpose = "Snapshot-style lock screen clock resource for Always-On Display.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Snapshot clock style disappears from AOD settings; no functional impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.keyguard.clock.gallery"
                )
            )

            put(
                "com.oplus.keyguard.clock.graffiti",
                PackageAppInfo(
                    packageName = "com.oplus.keyguard.clock.graffiti",
                    appName = "Keyguard Clock - Playful",                    purpose = "Playful/graffiti-style lock screen clock resource for Always-On Display.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Playful clock style disappears from AOD settings; no functional impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.keyguard.clock.graffiti"
                )
            )

            put(
                "com.oplus.keyguard.clock.magazine",
                PackageAppInfo(
                    packageName = "com.oplus.keyguard.clock.magazine",
                    appName = "Keyguard Clock - Cover",
                    purpose = "Magazine/cover-style lock screen clock resource for Always-On Display.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Cover clock style disappears from AOD settings; no functional impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.keyguard.clock.magazine"
                )
            )

            put(
                "com.oplus.keyguard.personality.clocks",
                PackageAppInfo(
                    packageName = "com.oplus.keyguard.personality.clocks",
                    appName = "Keyguard Clock - Personality",
                    purpose = "Personality-style lock screen clock resource for Always-On Display.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Personality clock styles disappear from AOD settings; no functional impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.keyguard.personality.clocks"
                )
            )

            put(
                "com.oplus.keyguard.style.widgets",
                PackageAppInfo(
                    packageName = "com.oplus.keyguard.style.widgets",
                    appName = "Keyguard Widgets",
                    purpose = "Lock screen widget resources for Always-On Display customization.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = emptyList(),                    impactIfDisabled = "Lock screen widgets disappear from AOD settings; no functional impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.keyguard.style.widgets"
                )
            )

            put(
                "com.oplus.linker",
                PackageAppInfo(
                    packageName = "com.oplus.linker",
                    appName = "Device Connect",
                    purpose = "Cross-device connectivity: enables file sharing, notification sync, and screen mirroring between OnePlus devices.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "BLUETOOTH_CONNECT",
                        "BLUETOOTH_SCAN",
                        "INTERNET",
                        "ACCESS_FINE_LOCATION",
                        "QUERY_ALL_PACKAGES"
                    ),
                    impactIfDisabled = "Cross-device features stop; Nearby Share and Google ecosystem still work.",
                    replacements = listOf("Nearby Share", "KDE Connect", "LocalSend"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.linker"
                )
            )

            put(
                "com.oplus.location",
                PackageAppInfo(
                    packageName = "com.oplus.location",
                    appName = "Location Services",
                    purpose = "OnePlus location framework: enhances GPS accuracy, manages location permissions, and powers location-based features.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "ACCESS_FINE_LOCATION",
                        "ACCESS_COARSE_LOCATION",
                        "ACCESS_BACKGROUND_LOCATION",
                        "INTERNET"
                    ),
                    impactIfDisabled = "⚠️ LOCATION BREAKAGE: Location accuracy degrades; maps, ride-sharing, and geofencing may fail.",
                    notes = "CRITICAL: Core location framework dependency. Do not remove.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.location"
                )
            )

            put(
                "com.oplus.locationproxy",                PackageAppInfo(
                    packageName = "com.oplus.locationproxy",
                    appName = "Location Proxy",
                    purpose = "Proxy layer for OnePlus location services: manages location permission routing and provider selection.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "ACCESS_FINE_LOCATION",
                        "ACCESS_COARSE_LOCATION"
                    ),
                    impactIfDisabled = "⚠️ LOCATION BREAKAGE: Location services may fail; apps requiring location may crash.",
                    notes = "CRITICAL: Location framework proxy. Do not remove.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.locationproxy"
                )
            )

            put(
                "com.oplus.logkit",
                PackageAppInfo(
                    packageName = "com.oplus.logkit",
                    appName = "Feedback (LogKit)",
                    purpose = "System feedback collector: captures crash logs, performance metrics, and user feedback for OnePlus optimization.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "READ_LOGS",
                        "PACKAGE_USAGE_STATS",
                        "INTERNET",
                        "READ_PHONE_STATE",
                        "ACCESS_NETWORK_STATE"
                    ),
                    privacyNote = "Sends diagnostic data and usage patterns to OnePlus servers.",
                    impactIfDisabled = "Feedback option disappears from Settings; crash reports not sent to OnePlus.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.logkit"
                )
            )

            put(
                "com.oplus.mediacontroller",
                PackageAppInfo(
                    packageName = "com.oplus.mediacontroller",
                    appName = "Media Controller",
                    purpose = "Media playback control framework: manages audio/video routing, Bluetooth media controls, and lock screen media widgets.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "MODIFY_AUDIO_SETTINGS",                        "BLUETOOTH_CONNECT",
                        "SYSTEM_ALERT_WINDOW",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Lock screen media controls may break; Bluetooth headset controls may fail.",
                    notes = "Media framework dependency. Keep for media control.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.mediacontroller"
                )
            )

            put(
                "com.oplus.mediaturbo",
                PackageAppInfo(
                    packageName = "com.oplus.mediaturbo",
                    appName = "MediaTurbo",
                    purpose = "Media optimization engine for hardware decoding, HDR processing, and streaming quality.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "MODIFY_AUDIO_SETTINGS",
                        "WRITE_SECURE_SETTINGS"
                    ),
                    impactIfDisabled = "Video playback may fall back to software decoding. HDR/4K streaming may stutter.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.mediaturbo",
                    notes = "Test disable if experiencing playback issues."
                )
            )

            put(
                "com.oplus.melody",
                PackageAppInfo(                    packageName = "com.oplus.melody",
                    appName = "Wireless Earphones",
                    purpose = "OnePlus Buds integration for battery popups, touch controls, and spatial audio.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "BLUETOOTH_CONNECT",
                        "BLUETOOTH_SCAN",
                        "MODIFY_AUDIO_SETTINGS"
                    ),
                    impactIfDisabled = "OnePlus Buds lose advanced features. Basic Bluetooth audio still works.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.melody"
                )
            )

            put(
                "com.oplus.metis",
                PackageAppInfo(
                    packageName = "com.oplus.metis",
                    appName = "Smart Decision-Making Service",
                    purpose = "AI background scheduler for app pre-loading, RAM management, and battery/CPU allocation.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "QUERY_ALL_PACKAGES",
                        "ACTIVITY_RECOGNITION",
                        "WRITE_SECURE_SETTINGS"
                    ),
                    privacyNote = "Collects app usage patterns and time-of-day behavior for predictive optimization.",
                    impactIfDisabled = "App launch prediction may slow. RAM management becomes less aggressive.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.metis"
                )
            )

            put(
                "com.oplus.motionsense",
                PackageAppInfo(
                    packageName = "com.oplus.motionsense",
                    appName = "Motion Sense",
                    purpose = "Powers air gestures, shake actions, flip-to-silence, and proximity shortcuts.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "BODY_SENSORS",
                        "ACTIVITY_RECOGNITION",
                        "SYSTEM_ALERT_WINDOW"                    ),
                    impactIfDisabled = "Air gestures and motion shortcuts stop working.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.motionsense"
                )
            )

            put(
                "com.oplus.multiapp",
                PackageAppInfo(
                    packageName = "com.oplus.multiapp",
                    appName = "App Cloner",
                    purpose = "Creates parallel/duplicate app instances for dual accounts.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "MANAGE_USERS",
                        "QUERY_ALL_PACKAGES",
                        "INTERACT_ACROSS_USERS"
                    ),
                    impactIfDisabled = "App Cloner feature disappears. Existing cloned apps may stop functioning.",
                    replacements = listOf("Shelter", "Island", "Parallel Space"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.multiapp"
                )
            )

            put(
                "com.oplus.nas",
                PackageAppInfo(
                    packageName = "com.oplus.nas",
                    appName = "Network Services",
                    purpose = "Network acceleration and DNS optimization for gaming/streaming stability.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "CHANGE_NETWORK_STATE",
                        "ACCESS_NETWORK_STATE",
                        "WRITE_SECURE_SETTINGS"
                    ),
                    impactIfDisabled = "Network switching may become less intelligent. Gaming latency may increase slightly.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.nas"
                )
            )

            put(
                "com.oplus.ndsf",
                PackageAppInfo(
                    packageName = "com.oplus.ndsf",
                    appName = "Network Data Sharing Framework",                    purpose = "Cross-device internet sharing, tethering optimization, and mesh networking features.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "CHANGE_NETWORK_STATE",
                        "BLUETOOTH_CONNECT",
                        "MANAGE_USERS"
                    ),
                    impactIfDisabled = "Cross-device tethering stops. Standard Android hotspot still works.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.ndsf"
                )
            )

            put(
                "com.oplus.nearcomm",
                PackageAppInfo(
                    packageName = "com.oplus.nearcomm",
                    appName = "OplusNearComm",
                    purpose = "Proximity communication for fast device discovery and cross-device file sharing.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "BLUETOOTH_CONNECT",
                        "BLUETOOTH_SCAN",
                        "ACCESS_FINE_LOCATION"
                    ),
                    impactIfDisabled = "OnePlus ecosystem discovery stops. Nearby Share still works.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.nearcomm"
                )
            )

            put(
                "com.oplus.networksense",
                PackageAppInfo(
                    packageName = "com.oplus.networksense",
                    appName = "Network Sense",
                    purpose = "Predicts network quality, pre-fetches content, and optimizes data usage.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "ACCESS_FINE_LOCATION",
                        "ACCESS_NETWORK_STATE",
                        "PACKAGE_USAGE_STATS"
                    ),
                    privacyNote = "Collects location and network metrics for predictive optimization.",
                    impactIfDisabled = "Content pre-fetching stops. Network switching less proactive.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.networksense"                )
            )

            put(
                "com.oplus.nfcengineertest",
                PackageAppInfo(
                    packageName = "com.oplus.nfcengineertest",
                    appName = "NFC Engineer Test",
                    purpose = "Factory/debug tool for NFC antenna testing and payment validation.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf("NFC", "WRITE_SECURE_SETTINGS"),
                    impactIfDisabled = "Zero user impact. Only affects engineering diagnostics.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.nfcengineertest"
                )
            )

            put(
                "com.oplus.nhs",
                PackageAppInfo(
                    packageName = "com.oplus.nhs",
                    appName = "Network Health Service",
                    purpose = "Monitors connection quality, detects issues, and auto-applies network fixes.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "ACCESS_NETWORK_STATE",
                        "CHANGE_NETWORK_STATE",
                        "PACKAGE_USAGE_STATS"
                    ),
                    impactIfDisabled = "Auto-network troubleshooting stops. Manual reset still works.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.nhs"
                )
            )

            put(
                "com.oplus.notificationmanager",
                PackageAppInfo(
                    packageName = "com.oplus.notificationmanager",
                    appName = "Manage Notifications",
                    purpose = "Smart notification sorting, priority channels, DND automation, and history tracking.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "POST_NOTIFICATIONS",
                        "PACKAGE_USAGE_STATS",
                        "READ_NOTIFICATIONS",                        "WRITE_SECURE_SETTINGS"
                    ),
                    impactIfDisabled = "Smart notification sorting stops. DND automation may degrade.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.notificationmanager"
                )
            )

            put(
                "com.oplus.nrMode",
                PackageAppInfo(
                    packageName = "com.oplus.nrMode",
                    appName = "OplusNrModeControl",
                    purpose = "5G NR mode controller for band selection and power optimization on cellular networks.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "READ_PHONE_STATE",
                        "CHANGE_NETWORK_STATE",
                        "ACCESS_NETWORK_STATE"
                    ),
                    impactIfDisabled = "⚠️ BOOTLOOP/STABILITY RISK: Breaks 5G modem binding and network switching.",
                    notes = "CRITICAL: Modem optimization dependency. Do not remove.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.nrMode"
                )
            )

            put(
                "com.oplus.nwestimate",
                PackageAppInfo(
                    packageName = "com.oplus.nwestimate",
                    appName = "NW Estimate",
                    purpose = "Predicts bandwidth/latency/packet loss for adaptive streaming and app optimization.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "ACCESS_NETWORK_STATE",
                        "PACKAGE_USAGE_STATS",
                        "READ_PHONE_STATE"
                    ),
                    impactIfDisabled = "Adaptive video quality less accurate. App pre-loading less efficient.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.nwestimate"
                )
            )

            put(
                "com.oplus.obrain",
                PackageAppInfo(
                    packageName = "com.oplus.obrain",                    appName = "OBrain",
                    purpose = "Central AI brain for on-device features: scene recognition, voice enhancement, predictive text.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "RECORD_AUDIO",
                        "CAMERA",
                        "PACKAGE_USAGE_STATS",
                        "QUERY_ALL_PACKAGES",
                        "ACTIVITY_RECOGNITION"
                    ),
                    privacyNote = "Processes audio/camera/usage data locally. May send anonymized improvements to servers.",
                    impactIfDisabled = "Camera AI, voice enhancement, and predictive features degrade or stop.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.obrain"
                )
            )

            put(
                "com.oplus.olc",
                PackageAppInfo(
                    packageName = "com.oplus.olc",
                    appName = "Log Service",
                    purpose = "System logging framework for crash reports, performance metrics, and diagnostics.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "READ_LOGS",
                        "PACKAGE_USAGE_STATS",
                        "ACCESS_NETWORK_STATE"
                    ),
                    privacyNote = "Sends detailed diagnostic data and usage patterns to OnePlus servers.",
                    impactIfDisabled = "Crash reports not sent. Diagnostic menus show less data.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.olc"
                )
            )

            put(
                "com.oplus.omoji",
                PackageAppInfo(
                    packageName = "com.oplus.omoji",
                    appName = "Omoji",
                    purpose = "Generates personalized 3D avatars for messaging, stickers, and AR filters.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "CAMERA",
                        "READ_EXTERNAL_STORAGE",                        "WRITE_EXTERNAL_STORAGE"
                    ),
                    impactIfDisabled = "Omoji creation feature disappears. No core functionality impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.omoji"
                )
            )

            put(
                "com.oplus.onetrace",
                PackageAppInfo(
                    packageName = "com.oplus.onetrace",
                    appName = "OneTrace",
                    purpose = "Performance tracing tool for app launch times, CPU/memory usage, and debugging.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "READ_LOGS",
                        "PACKAGE_USAGE_STATS",
                        "DUMP"
                    ),
                    impactIfDisabled = "Tracing features disappear from Developer Options.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.onetrace"
                )
            )

            put(
                "com.oplus.ota",
                PackageAppInfo(
                    packageName = "com.oplus.ota",
                    appName = "Software Update",
                    purpose = "OTA update manager for system patches, security fixes, and firmware upgrades.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "RECEIVE_BOOT_COMPLETED",
                        "INTERNET",
                        "WRITE_SECURE_SETTINGS",
                        "MANAGE_USERS"
                    ),
                    impactIfDisabled = "⚠️ CRITICAL: Breaks OTA update delivery. Device stuck on current version.",
                    notes = "CRITICAL: Official update channel. Do not remove.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.ota"
                )
            )

            put(
                "com.oplus.owkservice",
                PackageAppInfo(                    packageName = "com.oplus.owkservice",
                    appName = "OwkService",
                    purpose = "Wearable key service for smartwatch authentication and cross-device security tokens.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "BLUETOOTH_CONNECT",
                        "USE_BIOMETRIC",
                        "MANAGE_USERS"
                    ),
                    impactIfDisabled = "Wearable auth stops. Basic Bluetooth pairing unaffected.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.owkservice"
                )
            )

            put(
                "com.oplus.pantanal.ums",
                PackageAppInfo(
                    packageName = "com.oplus.pantanal.ums",
                    appName = "Ubiquitous Manager Service",
                    purpose = "Cross-device task continuity, clipboard sync, and seamless app handoff.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "BLUETOOTH_CONNECT",
                        "INTERACT_ACROSS_USERS",
                        "MANAGE_USERS"
                    ),
                    impactIfDisabled = "Clipboard sync and task handoff stop. Single-device usage unaffected.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.pantanal.ums"
                )
            )

            put(
                "com.oplus.pay",
                PackageAppInfo(
                    packageName = "com.oplus.pay",
                    appName = "Secure Payment",
                    purpose = "Payment framework integrating with Google Pay and managing secure transaction tokens.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "NFC",
                        "USE_BIOMETRIC",
                        "READ_PHONE_STATE"
                    ),
                    impactIfDisabled = "OnePlus Pay features stop. Google Pay may still work but lose OEM optimizations.",                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.pay"
                )
            )

            put(
                "com.oplus.phonemanager",
                PackageAppInfo(
                    packageName = "com.oplus.phonemanager",
                    appName = "Phone Manager",
                    purpose = "System optimization hub: storage cleaner, battery optimizer, app manager, security scanner.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "QUERY_ALL_PACKAGES",
                        "DELETE_PACKAGES"
                    ),
                    impactIfDisabled = "Phone Manager app disappears. Individual features accessible via Settings.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.phonemanager"
                )
            )

            put(
                "com.oplus.plugin",
                PackageAppInfo(
                    packageName = "com.oplus.plugin",
                    appName = "Plugin",
                    purpose = "Dynamic feature loading framework for modular app components and third-party integrations.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "QUERY_ALL_PACKAGES",
                        "INSTALL_PACKAGES"
                    ),
                    impactIfDisabled = "Some system app features may fail to load dynamically.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.plugin"
                )
            )

            put(
                "com.oplus.postmanservice",
                PackageAppInfo(
                    packageName = "com.oplus.postmanservice",
                    appName = "Diagnostics",
                    purpose = "Diagnostic reporting service for hardware metrics and quality improvement.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,                    keyPermissions = listOf(
                        "READ_LOGS",
                        "PACKAGE_USAGE_STATS",
                        "ACCESS_NETWORK_STATE"
                    ),
                    privacyNote = "Sends hardware diagnostics and usage patterns to OnePlus servers.",
                    impactIfDisabled = "Diagnostic reports stop. No user-visible impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.postmanservice"
                )
            )

            put(
                "com.oplus.powermonitor",
                PackageAppInfo(
                    packageName = "com.oplus.powermonitor",
                    appName = "Power Monitor",
                    purpose = "Monitors per-app battery drain, manages background limits, and optimizes power allocation.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "BATTERY_STATS",
                        "PACKAGE_USAGE_STATS",
                        "WRITE_SECURE_SETTINGS"
                    ),
                    impactIfDisabled = "Adaptive battery management degrades. Background app control less aggressive.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.powermonitor"
                )
            )

            put(
                "com.oplus.pscanvas",
                PackageAppInfo(
                    packageName = "com.oplus.pscanvas",
                    appName = "Multi Windows",
                    purpose = "Split-screen and floating window framework for productivity multitasking.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "SYSTEM_ALERT_WINDOW",
                        "QUERY_ALL_PACKAGES",
                        "WRITE_SECURE_SETTINGS"
                    ),
                    impactIfDisabled = "Split-screen gestures may fail. Floating windows disappear.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.pscanvas"
                )
            )

            put(                "com.oplus.qualityprotect",
                PackageAppInfo(
                    packageName = "com.oplus.qualityprotect",
                    appName = "QualityProtect",
                    purpose = "System stability monitor detecting crashes/ANRs and auto-applying fixes.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "READ_LOGS",
                        "PACKAGE_USAGE_STATS",
                        "WRITE_SECURE_SETTINGS"
                    ),
                    impactIfDisabled = "Auto-crash fixes stop. Performance issues may persist longer.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.qualityprotect"
                )
            )

            put(
                "com.oplus.remotecontrol",
                PackageAppInfo(
                    packageName = "com.oplus.remotecontrol",
                    appName = "Remote PC Control",
                    purpose = "Remote desktop feature for controlling PC from phone or vice versa.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "SYSTEM_ALERT_WINDOW",
                        "RECORD_AUDIO",
                        "CAMERA"
                    ),
                    impactIfDisabled = "Remote PC feature disappears. No core functionality impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.remotecontrol"
                )
            )

            put(
                "com.oplus.romupdate",
                PackageAppInfo(
                    packageName = "com.oplus.romupdate",
                    appName = "Update Service",
                    purpose = "Background service checking/downloading OTA updates and coordinating with Software Update.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "INTERNET",
                        "RECEIVE_BOOT_COMPLETED",
                        "WRITE_SECURE_SETTINGS"                    ),
                    impactIfDisabled = "OTA checks may fail. Update notifications may not appear.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.romupdate"
                )
            )

            put(
                "com.oplus.safecenter",
                PackageAppInfo(
                    packageName = "com.oplus.safecenter",
                    appName = "Security Centre",
                    purpose = "Central security hub: app permissions, virus scanning, privacy dashboard, payment protection.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "QUERY_ALL_PACKAGES",
                        "WRITE_SECURE_SETTINGS",
                        "MANAGE_USERS",
                        "DELETE_PACKAGES"
                    ),
                    impactIfDisabled = "⚠️ BOOTLOOP RISK: Lock screen UI dependency. Security features break completely.",
                    notes = "CRITICAL: Do not remove. Required for system security and UI stability.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.safecenter"
                )
            )

            put(
                "com.oplus.sandbox.runtime",
                PackageAppInfo(
                    packageName = "com.oplus.sandbox.runtime",
                    appName = "Sandbox Runtime",
                    purpose = "App sandboxing framework for isolating high-risk apps and enforcing permission boundaries.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "INTERACT_ACROSS_USERS",
                        "QUERY_ALL_PACKAGES",
                        "MANAGE_USERS"
                    ),
                    impactIfDisabled = "App isolation features degrade. High-risk sandboxing may fail.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.sandbox.runtime"
                )
            )

            put(
                "com.oplus.sau",
                PackageAppInfo(                    packageName = "com.oplus.sau",
                    appName = "System Upgrade Services",
                    purpose = "Manages incremental OTA updates, delta patches, and rollback protection.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "WRITE_SECURE_SETTINGS",
                        "INTERNET",
                        "RECEIVE_BOOT_COMPLETED",
                        "MANAGE_USERS"
                    ),
                    impactIfDisabled = "⚠️ CRITICAL: OTA incremental updates fail. Rollback protection breaks.",
                    notes = "CRITICAL: Official update mechanism. Do not remove.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.sau"
                )
            )

            put(
                "com.oplus.sauhelper",
                PackageAppInfo(
                    packageName = "com.oplus.sauhelper",
                    appName = "SAUHelper",
                    purpose = "Validates update packages, manages download retries, coordinates with SAU framework.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "INTERNET",
                        "WRITE_EXTERNAL_STORAGE",
                        "ACCESS_NETWORK_STATE"
                    ),
                    impactIfDisabled = "Update download retries fail. Package validation degrades.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.sauhelper"
                )
            )

            put(
                "com.oplus.screenrecorder",
                PackageAppInfo(
                    packageName = "com.oplus.screenrecorder",
                    appName = "Screen Recording",
                    purpose = "Built-in screen recorder with audio, facecam overlay, editing tools, and sharing.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "RECORD_AUDIO",
                        "CAMERA",
                        "READ_EXTERNAL_STORAGE",                        "SYSTEM_ALERT_WINDOW"
                    ),
                    impactIfDisabled = "Screen recording shortcut disappears. Third-party recorders still work.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.screenrecorder"
                )
            )

            put(
                "com.oplus.screenshot",
                PackageAppInfo(
                    packageName = "com.oplus.screenshot",
                    appName = "Screenshot",
                    purpose = "Screenshot editor with annotation, cropping, sharing, and long-screenshot stitching.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "READ_EXTERNAL_STORAGE",
                        "WRITE_EXTERNAL_STORAGE"
                    ),
                    impactIfDisabled = "Screenshot editor disappears. Basic capture via buttons still works.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.screenshot"
                )
            )

            put(
                "com.oplus.securepay",
                PackageAppInfo(
                    packageName = "com.oplus.securepay",
                    appName = "Payment Protection",
                    purpose = "Monitors banking/payment apps for malware and secures transaction environments.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "QUERY_ALL_PACKAGES",
                        "WRITE_SECURE_SETTINGS"
                    ),
                    impactIfDisabled = "Payment security scanning stops. Banking apps may show warnings.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.securepay"
                )
            )

            put(
                "com.oplus.securityguard",
                PackageAppInfo(
                    packageName = "com.oplus.securityguard",
                    appName = "Security Events",
                    purpose = "Logs permission changes, app installations, network anomalies, and suspicious behavior.",                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "READ_LOGS",
                        "POST_NOTIFICATIONS"
                    ),
                    impactIfDisabled = "Security event notifications stop. No core security impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.securityguard"
                )
            )

            put(
                "com.oplus.securitykeyboard",
                PackageAppInfo(
                    packageName = "com.oplus.securitykeyboard",
                    appName = "Security Keyboard",
                    purpose = "Encrypted keyboard for password/PIN entry in banking and payment apps.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "INTERNET",
                        "USE_BIOMETRIC"
                    ),
                    impactIfDisabled = "Secure keyboard option disappears. Banking apps fallback to standard keyboard.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.securitykeyboard"
                )
            )

            put(
                "com.oplus.securitypermission",
                PackageAppInfo(
                    packageName = "com.oplus.securitypermission",
                    appName = "Permission Manager",
                    purpose = "Runtime permission management, privacy indicators, and permission history tracking.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "MANAGE_USERS",
                        "QUERY_ALL_PACKAGES",
                        "GET_APP_OPS_STATS",
                        "WRITE_SECURE_SETTINGS"
                    ),
                    impactIfDisabled = "⚠️ BOOTLOOP RISK: Permission prompts fail. Privacy dashboard breaks. Security model compromised.",
                    notes = "CRITICAL: Android security framework dependency. Do not remove.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.securitypermission"
                )            )

            put(
                "com.oplus.sense.netprediction",
                PackageAppInfo(
                    packageName = "com.oplus.sense.netprediction",
                    appName = "Network Prediction",
                    purpose = "Predicts network quality and pre-fetches content based on usage patterns.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "ACCESS_FINE_LOCATION",
                        "ACCESS_NETWORK_STATE",
                        "PACKAGE_USAGE_STATS"
                    ),
                    impactIfDisabled = "Content pre-fetching stops. Network switching less proactive.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.sense.netprediction"
                )
            )

            put(
                "com.oplus.sense.netscore",
                PackageAppInfo(
                    packageName = "com.oplus.sense.netscore",
                    appName = "Network Score",
                    purpose = "Scores connection reliability and optimizes app behavior based on network quality.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "ACCESS_NETWORK_STATE",
                        "PACKAGE_USAGE_STATS",
                        "READ_PHONE_STATE"
                    ),
                    impactIfDisabled = "Network quality scoring stops. Minor data efficiency impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.sense.netscore"
                )
            )

            put(
                "com.oplus.smartengine",
                PackageAppInfo(
                    packageName = "com.oplus.smartengine",
                    appName = "SmartEngine",
                    purpose = "AI optimization core for predictive app loading, thermal management, and performance tuning.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(                        "PACKAGE_USAGE_STATS",
                        "QUERY_ALL_PACKAGES",
                        "ACTIVITY_RECOGNITION",
                        "WRITE_SECURE_SETTINGS"
                    ),
                    privacyNote = "Collects detailed usage patterns, location context, and interaction frequency for AI.",
                    impactIfDisabled = "App launch prediction slows. Thermal management less aggressive.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.smartengine"
                )
            )

            put(
                "com.oplus.statistics.rom",
                PackageAppInfo(
                    packageName = "com.oplus.statistics.rom",
                    appName = "Basic Data Services",
                    purpose = "Telemetry collector for usage statistics, crash reports, and diagnostics.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "READ_LOGS",
                        "PACKAGE_USAGE_STATS",
                        "ACCESS_NETWORK_STATE"
                    ),
                    privacyNote = "Sends detailed usage patterns and device state to OnePlus servers.",
                    impactIfDisabled = "Usage statistics not sent. No user-visible impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.statistics.rom"
                )
            )

            put(
                "com.oplus.stdid",
                PackageAppInfo(
                    packageName = "com.oplus.stdid",
                    appName = "StdID",
                    purpose = "Manages anonymous device identifiers for analytics, attribution, and cross-app measurement.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "READ_PHONE_STATE",
                        "ACCESS_NETWORK_STATE"
                    ),
                    impactIfDisabled = "Anonymous analytics fallback to less reliable methods. No functional impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.stdid"
                )
            )

            put(                "com.oplus.stdsp",
                PackageAppInfo(
                    packageName = "com.oplus.stdsp",
                    appName = "StdSP Core",
                    purpose = "Standard service provider framework for modular service registration and OEM integration.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "INTERACT_ACROSS_USERS",
                        "QUERY_ALL_PACKAGES"
                    ),
                    impactIfDisabled = "Some OnePlus services may fail to register. Minor functionality loss possible.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.stdsp"
                )
            )

            put(
                "com.oplus.subsys",
                PackageAppInfo(
                    packageName = "com.oplus.subsys",
                    appName = "Subsystem Service",
                    purpose = "Coordinates hardware subsystems (camera, audio, sensors), power states, and inter-component communication.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "WRITE_SECURE_SETTINGS",
                        "PACKAGE_USAGE_STATS"
                    ),
                    impactIfDisabled = "Hardware coordination may degrade. Camera/audio/sensor handoffs less reliable.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.subsys"
                )
            )

            put(
                "com.oplus.systemui.plugins",
                PackageAppInfo(
                    packageName = "com.oplus.systemui.plugins",
                    appName = "SystemUI Plugin",
                    purpose = "Dynamic plugin loading for Quick Settings tiles, status bar customizations, and UI enhancements.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "SYSTEM_ALERT_WINDOW",
                        "QUERY_ALL_PACKAGES",
                        "WRITE_SECURE_SETTINGS"
                    ),
                    impactIfDisabled = "Custom QS tiles may fail to load. OnePlus UI enhancements revert to stock.",                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.systemui.plugins"
                )
            )

            put(
                "com.oplus.tai.borderpresearch",
                PackageAppInfo(
                    packageName = "com.oplus.tai.borderpresearch",
                    appName = "BorderPreSearch",
                    purpose = "Edge gesture framework for border-swipe shortcuts and gesture navigation enhancements.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "SYSTEM_ALERT_WINDOW",
                        "BODY_SENSORS",
                        "ACTIVITY_RECOGNITION"
                    ),
                    impactIfDisabled = "Edge-swipe shortcuts stop. Gesture navigation may revert to stock behavior.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.tai.borderpresearch"
                )
            )

            put(
                "com.oplus.tai.wifiqoe",
                PackageAppInfo(
                    packageName = "com.oplus.tai.wifiqoe",
                    appName = "WifiQoe",
                    purpose = "Wi-Fi Quality of Experience optimizer for band steering and gaming/streaming reliability.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "ACCESS_NETWORK_STATE",
                        "CHANGE_NETWORK_STATE",
                        "PACKAGE_USAGE_STATS"
                    ),
                    impactIfDisabled = "Wi-Fi optimization less intelligent. Streaming latency may increase on congested networks.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.tai.wifiqoe"
                )
            )

            put(
                "com.oplus.themestore",
                PackageAppInfo(
                    packageName = "com.oplus.themestore",
                    appName = "Theme Store",
                    purpose = "Downloads and applies custom themes, wallpapers, icons, fonts, and AOD styles.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "INTERNET",
                        "READ_EXTERNAL_STORAGE",
                        "WRITE_EXTERNAL_STORAGE",
                        "QUERY_ALL_PACKAGES"
                    ),
                    impactIfDisabled = "Theme Store app disappears; manually installed themes still work.",
                    replacements = listOf("Repainter", "KWGT", "zFont 3"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.themestore"
                )
            )

            put(                "com.oplus.trafficmonitor",
                PackageAppInfo(
                    packageName = "com.oplus.trafficmonitor",
                    appName = "Data Usage Monitor",
                    purpose = "Monitors mobile/Wi-Fi consumption, sets limits, alerts on overage, per-app breakdown.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "PACKAGE_USAGE_STATS",
                        "INTERNET",
                        "ACCESS_NETWORK_STATE",
                        "POST_NOTIFICATIONS"
                    ),
                    privacyNote = "Tracks app data usage patterns; may sync to OnePlus cloud if enabled.",
                    impactIfDisabled = "Data usage monitoring stops; Android built-in tracker still works via Settings.",
                    replacements = listOf("GlassWire", "My Data Manager"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.trafficmonitor"
                )
            )

            put(
                "com.oplus.uiengine",
                PackageAppInfo(
                    packageName = "com.oplus.uiengine",
                    appName = "UI Engine",
                    purpose = "Manages animations, transitions, blur effects, and visual consistency across system apps.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "SYSTEM_ALERT_WINDOW",
                        "WRITE_SECURE_SETTINGS",
                        "QUERY_ALL_PACKAGES"
                    ),
                    impactIfDisabled = "System animations may stutter; blur effects may fallback to solid.",
                    notes = "UI framework dependency. Keep for visual stability.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.uiengine"
                )
            )

            put(
                "com.oplus.upgradeguide",
                PackageAppInfo(
                    packageName = "com.oplus.upgradeguide",
                    appName = "Update Highlights",
                    purpose = "Showcases new features, changelogs, and tutorials after OS updates.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,                    keyPermissions = listOf(
                        "INTERNET",
                        "READ_PHONE_STATE",
                        "QUERY_ALL_PACKAGES"
                    ),
                    impactIfDisabled = "Update highlight screens won't appear post-OTA; updates still install normally.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.upgradeguide"
                )
            )

            put(
                "com.oplus.uxdesign",
                PackageAppInfo(
                    packageName = "com.oplus.uxdesign",
                    appName = "Wallpapers & Style",
                    purpose = "Manages dynamic wallpapers, color extraction, Material You integration, and UI theming.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "READ_EXTERNAL_STORAGE",
                        "WRITE_EXTERNAL_STORAGE",
                        "INTERNET",
                        "QUERY_ALL_PACKAGES"
                    ),
                    impactIfDisabled = "Dynamic wallpaper extraction stops; Material You color theming may revert.",
                    replacements = listOf("Backdrops", "Walli", "Repainter"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.uxdesign"
                )
            )

            put(
                "com.oplus.vde",
                PackageAppInfo(
                    packageName = "com.oplus.vde",
                    appName = "VDC Service",
                    purpose = "Video Display Controller: manages HDR processing, refresh rate switching, display optimization.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "WRITE_SECURE_SETTINGS",
                        "INTERNET",
                        "ACCESS_NETWORK_STATE"
                    ),
                    impactIfDisabled = "HDR video may render less accurately; refresh rate switching less smooth.",
                    notes = "Display optimization dependency. Keep for video quality.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.vde"
                )
            )
            put(
                "com.oplus.virtualcomm",
                PackageAppInfo(
                    packageName = "com.oplus.virtualcomm",
                    appName = "OplusVirtualComm",
                    purpose = "Cross-device messaging, notification sync, and seamless handoff between OnePlus devices.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "BLUETOOTH_CONNECT",
                        "INTERNET",
                        "QUERY_ALL_PACKAGES",
                        "MANAGE_USERS"
                    ),
                    impactIfDisabled = "Cross-device messaging stops; Nearby Share and Google ecosystem still work.",
                    replacements = listOf("Google Messages", "KDE Connect", "LocalSend"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.virtualcomm"
                )
            )

            put(
                "com.oplus.virtualcomm2",
                PackageAppInfo(
                    packageName = "com.oplus.virtualcomm2",
                    appName = "Virtual Comm Service 2",
                    purpose = "Secondary virtual communication framework for cross-device features.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "BLUETOOTH_CONNECT",
                        "INTERNET",
                        "QUERY_ALL_PACKAGES"
                    ),
                    impactIfDisabled = "Cross-device features stop; no impact on single-device usage.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.virtualcomm2"
                )
            )

            put(
                "com.oplus.wallpapers",
                PackageAppInfo(
                    packageName = "com.oplus.wallpapers",
                    appName = "Wallpapers",
                    purpose = "OnePlus wallpaper library: pre-installed static/dynamic wallpapers and AOD backgrounds.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,                    keyPermissions = listOf(
                        "READ_EXTERNAL_STORAGE",
                        "INTERNET"
                    ),
                    impactIfDisabled = "OnePlus wallpaper collection disappears; custom wallpapers still work.",
                    replacements = listOf("Backdrops", "Walli", "Zedge"),
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.wallpapers"
                )
            )

            put(
                "com.oplus.wifibackuprestore",
                PackageAppInfo(
                    packageName = "com.oplus.wifibackuprestore",
                    appName = "Wi-Fi Backup Restore",
                    purpose = "Backs up Wi-Fi credentials to cloud/HeyTap account for restore on new devices.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "GET_ACCOUNTS",
                        "INTERNET",
                        "ACCESS_NETWORK_STATE",
                        "WRITE_SECURE_SETTINGS"
                    ),
                    privacyNote = "Uploads Wi-Fi SSIDs and credentials to OnePlus/HeyTap servers if cloud sync enabled.",
                    impactIfDisabled = "Wi-Fi passwords won't auto-restore on new device; manual entry still works.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.wifibackuprestore"
                )
            )

            put(
                "com.oplus.wirelesssettings",
                PackageAppInfo(
                    packageName = "com.oplus.wirelesssettings",
                    appName = "Wireless Settings",
                    purpose = "Manages Wi-Fi, Bluetooth, NFC, and mobile network settings with OnePlus UI customizations.",
                    category = AppCategory.ONEPLUS_OPLUS,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "CHANGE_NETWORK_STATE",
                        "BLUETOOTH_CONNECT",
                        "NFC",
                        "INTERNET",
                        "WRITE_SECURE_SETTINGS"
                    ),
                    impactIfDisabled = "Wireless settings UI may revert to stock Android; OnePlus-specific toggles may disappear.",
                    notes = "Settings framework dependency. Keep for settings access.",
                    removalCommand = "adb shell pm disable-user --user 0 com.oplus.wirelesssettings"                )
            )

            put(
                "com.qti.dcf",
                PackageAppInfo(
                    packageName = "com.qti.dcf",
                    appName = "Qualcomm DCF",
                    purpose = "Device configuration framework for Snapdragon platform calibration and tuning.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Display power management may break; device calibration may fail.",
                    notes = "Hardware-level configuration service. Never remove."
                )
            )

            put(
                "com.qti.domserviceapp",
                PackageAppInfo(
                    packageName = "com.qti.domserviceapp",
                    appName = "Qualcomm DOM Service",
                    purpose = "Display optimization and management service for Snapdragon GPU/display pipeline.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Display rendering may degrade; HDR/refresh rate features may break.",
                    notes = "Critical display service. Do not remove."
                )
            )

            put(
                "com.qti.dpmserviceapp",
                PackageAppInfo(
                    packageName = "com.qti.dpmserviceapp",
                    appName = "Qualcomm DPM Service",
                    purpose = "Display power management service for battery optimization and thermal control.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Battery optimization may fail; thermal throttling may become aggressive.",
                    notes = "Power management dependency. Never remove."                )
            )

            put(
                "com.qti.qcc",
                PackageAppInfo(
                    packageName = "com.qti.qcc",
                    appName = "Qualcomm QCC",
                    purpose = "Qualcomm connectivity controller for modem/Wi-Fi/Bluetooth coordination.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Network switching may fail; connectivity instability possible.",
                    notes = "Connectivity framework core. Do not remove."
                )
            )

            put(
                "com.qualcomm.atfwd",
                PackageAppInfo(
                    packageName = "com.qualcomm.atfwd",
                    appName = "Qualcomm AT Forward",
                    purpose = "AT command forwarding service for modem control and carrier communication.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("READ_PHONE_STATE"),
                    impactIfDisabled = "Modem communication may fail; carrier features may break.",
                    notes = "Telephony framework dependency. Never remove."
                )
            )

            put(
                "com.qualcomm.ati.telephonyservice",
                PackageAppInfo(
                    packageName = "com.qualcomm.ati.telephonyservice",
                    appName = "Qualcomm ATI Telephony",
                    purpose = "Advanced telephony interface for carrier-specific features and VoLTE/VoWiFi support.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "READ_PHONE_STATE",
                        "MODIFY_PHONE_STATE",
                        "SEND_SMS"
                    ),
                    impactIfDisabled = "VoLTE/VoWiFi may fail; carrier features may break.",
                    notes = "Carrier telephony dependency. Do not remove."
                )            )

            put(
                "com.qualcomm.location",
                PackageAppInfo(
                    packageName = "com.qualcomm.location",
                    appName = "Qualcomm Location",
                    purpose = "Qualcomm GPS/GNSS engine: high-accuracy positioning, GLONASS/Galileo/BeiDou support, E911.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "ACCESS_FINE_LOCATION",
                        "ACCESS_COARSE_LOCATION",
                        "ACCESS_BACKGROUND_LOCATION",
                        "INTERNET",
                        "READ_PHONE_STATE"
                    ),
                    impactIfDisabled = "Location services break: Maps, ride-sharing, weather, geofencing fail.",
                    notes = "Hardware-level location framework. Never remove."
                )
            )

            put(
                "com.qualcomm.qcrilmsgtunnel",
                PackageAppInfo(
                    packageName = "com.qualcomm.qcrilmsgtunnel",
                    appName = "Qualcomm QCRIL Message Tunnel",
                    purpose = "RIL (Radio Interface Layer) message tunnel for modem-SIM communication and IMS services.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "READ_PHONE_STATE",
                        "MODIFY_PHONE_STATE",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Voice calls may break; VoLTE/VoWiFi/RCS may fail.",
                    notes = "Carrier telephony core. Do not remove."
                )
            )

            put(
                "com.qualcomm.qti.cne",
                PackageAppInfo(
                    packageName = "com.qualcomm.qti.cne",
                    appName = "Qualcomm CNE (Connectivity Engine)",
                    purpose = "Intelligently switches between Wi-Fi/cellular, manages network bonding, optimizes throughput.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CAUTION,                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "CHANGE_NETWORK_STATE",
                        "ACCESS_NETWORK_STATE",
                        "INTERNET",
                        "READ_PHONE_STATE"
                    ),
                    impactIfDisabled = "Network switching may become less intelligent; gaming latency may increase.",
                    removalCommand = "adb shell pm disable-user --user 0 com.qualcomm.qti.cne"
                )
            )

            put(
                "com.qualcomm.qti.devicestatisticsservice",
                PackageAppInfo(
                    packageName = "com.qualcomm.qti.devicestatisticsservice",
                    appName = "Qualcomm Device Statistics",
                    purpose = "Collects hardware performance metrics, thermal data, and usage patterns for optimization.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "ACCESS_NETWORK_STATE",
                        "PACKAGE_USAGE_STATS"
                    ),
                    privacyNote = "Sends anonymized hardware diagnostics to Qualcomm/OnePlus.",
                    impactIfDisabled = "Hardware optimization telemetry stops; no user-visible impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.qualcomm.qti.devicestatisticsservice"
                )
            )

            put(
                "com.qualcomm.qti.gpudrivers.pineapple.api34",
                PackageAppInfo(
                    packageName = "com.qualcomm.qti.gpudrivers.pineapple.api34",
                    appName = "Adreno GPU Drivers",
                    purpose = "Adreno GPU drivers for Snapdragon 8 Gen 3 (Pineapple): hardware-accelerated graphics, gaming, UI.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Graphics break: games crash, UI stutters, video playback fails.",
                    notes = "Hardware driver dependency. Never remove."
                )
            )

            put(
                "com.qualcomm.qti.powersavemode",
                PackageAppInfo(
                    packageName = "com.qualcomm.qti.powersavemode",                    appName = "Qualcomm Power Save Mode",
                    purpose = "Optimizes CPU/GPU frequency, radio power states, and thermal throttling for battery life.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "WRITE_SECURE_SETTINGS",
                        "BATTERY_STATS",
                        "PACKAGE_USAGE_STATS"
                    ),
                    impactIfDisabled = "Battery drain may increase; thermal management may become less aggressive.",
                    replacements = listOf("Android Adaptive Battery"),
                    removalCommand = "adb shell pm disable-user --user 0 com.qualcomm.qti.powersavemode"
                )
            )

            put(
                "com.qualcomm.qti.qms.service.trustzoneaccess",
                PackageAppInfo(
                    packageName = "com.qualcomm.qti.qms.service.trustzoneaccess",
                    appName = "TrustZone Access Service",
                    purpose = "Bridges Android to Qualcomm TrustZone secure enclave: DRM keys, biometrics, hardware encryption.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "USE_BIOMETRIC",
                        "WRITE_SECURE_SETTINGS",
                        "MANAGE_USERS"
                    ),
                    impactIfDisabled = "Security breaks: fingerprint/face unlock fails, DRM content won't play, payments stop.",
                    notes = "Hardware security core. Never remove."
                )
            )

            put(
                "com.qualcomm.qti.telephonyservice",
                PackageAppInfo(
                    packageName = "com.qualcomm.qti.telephonyservice",
                    appName = "Qualcomm Telephony Service",
                    purpose = "Core telephony service for modem control, call routing, and carrier feature support.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "READ_PHONE_STATE",
                        "MODIFY_PHONE_STATE",
                        "SEND_SMS"
                    ),
                    impactIfDisabled = "Voice calls may break; SMS/MMS may fail.",                    notes = "Telephony framework core. Do not remove."
                )
            )

            put(
                "com.qualcomm.qti.uimGbaApp",
                PackageAppInfo(
                    packageName = "com.qualcomm.qti.uimGbaApp",
                    appName = "Qualcomm UIM GBA",
                    purpose = "Generic Bootstrapping Architecture for SIM-based authentication and carrier services.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("READ_PHONE_STATE"),
                    impactIfDisabled = "SIM-based authentication may fail; carrier features may break.",
                    notes = "SIM authentication dependency. Never remove."
                )
            )

            put(
                "com.qualcomm.qti.workloadclassifier",
                PackageAppInfo(
                    packageName = "com.qualcomm.qti.workloadclassifier",
                    appName = "Qualcomm Workload Classifier",
                    purpose = "Classifies app workloads for CPU/GPU scheduling and performance optimization.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf("PACKAGE_USAGE_STATS"),
                    impactIfDisabled = "Performance scheduling may become less intelligent; minor battery impact.",
                    removalCommand = "adb shell pm disable-user --user 0 com.qualcomm.qti.workloadclassifier"
                )
            )

            put(
                "com.qualcomm.qti.xrcb",
                PackageAppInfo(
                    packageName = "com.qualcomm.qti.xrcb",
                    appName = "Qualcomm XRCB",
                    purpose = "Extended radio control bridge for advanced modem features and carrier customization.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("READ_PHONE_STATE"),
                    impactIfDisabled = "Advanced modem features may break; carrier optimizations may fail.",
                    notes = "Modem framework dependency. Do not remove."
                )
            )

            put(                "com.qualcomm.qti.xrvd.service",
                PackageAppInfo(
                    packageName = "com.qualcomm.qti.xrvd.service",
                    appName = "Qualcomm XRVD Service",
                    purpose = "Extended radio video daemon for video call optimization and carrier video features.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("READ_PHONE_STATE", "CAMERA"),
                    impactIfDisabled = "Video calling features may degrade; carrier video services may fail.",
                    notes = "Video telephony dependency. Never remove."
                )
            )

            put(
                "com.qualcomm.timeservice",
                PackageAppInfo(
                    packageName = "com.qualcomm.timeservice",
                    appName = "Qualcomm Time Service",
                    purpose = "Network time synchronization service for accurate system clock and carrier time sync.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("INTERNET"),
                    impactIfDisabled = "System clock may drift; carrier time sync may fail.",
                    notes = "Time synchronization core. Do not remove."
                )
            )

            put(
                "com.qualcomm.uimremoteclient",
                PackageAppInfo(
                    packageName = "com.qualcomm.uimremoteclient",
                    appName = "Qualcomm UIM Remote Client",
                    purpose = "Remote SIM access client for eSIM provisioning and carrier profile management.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("READ_PHONE_STATE", "INTERNET"),
                    impactIfDisabled = "eSIM provisioning may fail; carrier profile management may break.",
                    notes = "eSIM framework dependency. Never remove."
                )
            )

            put(
                "com.qualcomm.uimremoteserver",
                PackageAppInfo(
                    packageName = "com.qualcomm.uimremoteserver",
                    appName = "Qualcomm UIM Remote Server",
                    purpose = "Remote SIM access server for eSIM profile download and activation.",                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf("READ_PHONE_STATE", "INTERNET"),
                    impactIfDisabled = "eSIM activation may fail; remote SIM management may break.",
                    notes = "eSIM server dependency. Do not remove."
                )
            )

            put(
                "com.qualcomm.wfd.service",
                PackageAppInfo(
                    packageName = "com.qualcomm.wfd.service",
                    appName = "Qualcomm Wi-Fi Display Service",
                    purpose = "Wi-Fi Display (Miracast) service for wireless screen mirroring to TVs/monitors.",
                    category = AppCategory.QUALCOMM,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "INTERNET",
                        "ACCESS_NETWORK_STATE",
                        "BLUETOOTH_CONNECT"
                    ),
                    impactIfDisabled = "Wireless screen mirroring stops; wired casting still works.",
                    replacements = listOf("Google Home (Chromecast)", "Scrcpy (wired)"),
                    removalCommand = "adb shell pm disable-user --user 0 com.qualcomm.wfd.service"
                )
            )

            put(
                "com.aiunit.aon",
                PackageAppInfo(
                    packageName = "com.aiunit.aon",
                    appName = "AON Service",
                    purpose = "Always-On Neural processing: powers low-power AI features like voice wake-word detection.",
                    category = AppCategory.THIRD_PARTY,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "RECORD_AUDIO",
                        "BODY_SENSORS",
                        "ACTIVITY_RECOGNITION"
                    ),
                    privacyNote = "Always listening for wake words. Privacy concern for microphone usage.",
                    impactIfDisabled = "Voice wake-word functionality breaks on supported apps.",
                    notes = "Low-power AI dependency. Disable only if privacy-focused.",                    removalCommand = "adb shell pm disable-user --user 0 com.aiunit.aon"
                )
            )

            put(
                "com.fido.fido2client",
                PackageAppInfo(
                    packageName = "com.fido.fido2client",
                    appName = "FIDO2 Client",
                    purpose = "FIDO2 authentication client: enables passwordless login and hardware security key support.",
                    category = AppCategory.THIRD_PARTY,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "USE_BIOMETRIC",
                        "INTERNET",
                        "READ_PHONE_STATE"
                    ),
                    impactIfDisabled = "FIDO2-based authentication fails; apps may fallback to password/PIN.",
                    replacements = listOf("Password managers"),
                    removalCommand = "adb shell pm disable-user --user 0 com.fido.fido2client"
                )
            )

            put(
                "com.fido.uafclient",
                PackageAppInfo(
                    packageName = "com.fido.uafclient",
                    appName = "FIDO UAF Client",
                    purpose = "FIDO UAF authentication client: legacy passwordless authentication protocol support.",
                    category = AppCategory.THIRD_PARTY,
                    safetyLevel = SafetyLevel.CAUTION,
                    removalStatus = RemovalStatus.CAUTION,
                    keyPermissions = listOf(
                        "USE_BIOMETRIC",
                        "INTERNET"
                    ),
                    impactIfDisabled = "Legacy FIDO UAF authentication fails.",
                    notes = "Legacy authentication dependency. Keep if using passwordless login.",
                    removalCommand = "adb shell pm disable-user --user 0 com.fido.uafclient"
                )
            )

            put(
                "com.gms.android.ncm.overlay.common",
                PackageAppInfo(
                    packageName = "com.gms.android.ncm.overlay.common",
                    appName = "NCM Overlay (Common)",
                    purpose = "Network Configuration Manager resource overlay from third-party vendor.",
                    category = AppCategory.THIRD_PARTY,                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = emptyList(),
                    impactIfDisabled = "Zero visible impact; network functionality unchanged.",
                    removalCommand = "adb shell pm disable-user --user 0 com.gms.android.ncm.overlay.common"
                )
            )

            put(
                "com.mediatek.omacp",
                PackageAppInfo(
                    packageName = "com.mediatek.omacp",
                    appName = "Omacp (MediaTek)",
                    purpose = "OMA Client Provisioning for APN/MMS auto-config. MediaTek chipset only (compatibility package).",
                    category = AppCategory.THIRD_PARTY,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "READ_PHONE_STATE",
                        "INTERNET",
                        "WRITE_APN_SETTINGS"
                    ),
                    impactIfDisabled = "Zero impact on OnePlus 13R (Qualcomm device); carrier config handled by Qualcomm services.",
                    removalCommand = "adb shell pm disable-user --user 0 com.mediatek.omacp"
                )
            )

            put(
                "com.redteamobile.roaming",
                PackageAppInfo(
                    packageName = "com.redteamobile.roaming",
                    appName = "ORoaming",
                    purpose = "Virtual SIM roaming service: provides international data roaming via virtual carrier partnerships.",
                    category = AppCategory.THIRD_PARTY,
                    safetyLevel = SafetyLevel.SAFE,
                    removalStatus = RemovalStatus.YES,
                    keyPermissions = listOf(
                        "READ_PHONE_STATE",
                        "INTERNET",
                        "ACCESS_NETWORK_STATE",
                        "CHANGE_NETWORK_STATE"
                    ),
                    privacyNote = "Tracks location and data usage for roaming billing.",
                    impactIfDisabled = "ORoaming feature disappears; standard carrier roaming still works.",
                    replacements = listOf("Carrier roaming plans", "local SIM cards", "eSIM providers"),
                    removalCommand = "adb shell pm disable-user --user 0 com.redteamobile.roaming"
                )
            )

            put(                "com.wapi.wapicertmanage",
                PackageAppInfo(
                    packageName = "com.wapi.wapicertmanage",
                    appName = "WAPI Certificate Manager",
                    purpose = "WAPI (Chinese Wi-Fi security standard) certificate manager for government-certified networks.",
                    category = AppCategory.THIRD_PARTY,
                    safetyLevel = SafetyLevel.CRITICAL,
                    removalStatus = RemovalStatus.NO,
                    keyPermissions = listOf(
                        "MANAGE_USERS",
                        "WRITE_SECURE_SETTINGS",
                        "READ_EXTERNAL_STORAGE"
                    ),
                    impactIfDisabled = "WAPI-secured Wi-Fi networks won't connect; critical for devices sold in China.",
                    notes = "Regional security framework. Do not remove if in China or using WAPI networks."
                )
            )

        }
    }
}