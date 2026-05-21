package com.hiaashuu.appinfo

import android.content.Context
import android.content.pm.PackageManager
import com.hiaashuu.appinfo.data.AppDatabase
import com.hiaashuu.appinfo.models.AppCategory
import com.hiaashuu.appinfo.models.PackageAppInfo
import com.hiaashuu.appinfo.models.RemovalStatus
import com.hiaashuu.appinfo.models.SafetyLevel

/**
 * AppInfoLibrary — Public API
 *
 * Usage from any app:
 *   val info = AppInfoLibrary.getInfo("com.android.bluetooth")
 *   val allSafe = AppInfoLibrary.getSafeToRemove()
 *   val installed = AppInfoLibrary.scanInstalledApps(context)
 */
object AppInfoLibrary {

    /**
     * Look up info for a single package.
     * Returns null if the package is not in the database.
     *
     * Example:
     *   val info = AppInfoLibrary.getInfo("com.android.bluetooth")
     *   if (info != null) { showInfo(info) }
     */
    fun getInfo(packageName: String): PackageAppInfo? {
        return AppDatabase.all[packageName]
    }

    /**
     * Look up info for multiple packages at once.
     * Silently skips packages not in the database.
     *
     * Example:
     *   val infos = AppInfoLibrary.getInfoForPackages(listOf("com.android.bluetooth", "com.google.android.gm"))
     */
    fun getInfoForPackages(packageNames: List<String>): List<PackageAppInfo> {
        return packageNames.mapNotNull { AppDatabase.all[it] }
    }

    /**
     * Scans all installed apps on the device and returns database entries
     * for every package that is known to the library.
     *
     * Example:
     *   val results = AppInfoLibrary.scanInstalledApps(context)
     *   results.forEach { info -> Log.d("AppInfo", "${info.appName} → ${info.safetyLevel}") }
     */
    fun scanInstalledApps(context: Context): List<PackageAppInfo> {
        val pm: PackageManager = context.packageManager
        val installedPackageNames: List<String> = pm
            .getInstalledPackages(0)
            .map { packageInfo -> packageInfo.packageName }
        return getInfoForPackages(installedPackageNames)
    }

    /**
     * Returns all database entries matching a specific SafetyLevel.
     *
     * Example:
     *   val critical = AppInfoLibrary.getBySafetyLevel(SafetyLevel.CRITICAL)
     */
    fun getBySafetyLevel(level: SafetyLevel): List<PackageAppInfo> {
        return AppDatabase.all.values.filter { info -> info.safetyLevel == level }
    }

    /**
     * Returns all packages confirmed safe to remove (RemovalStatus.YES).
     */
    fun getSafeToRemove(): List<PackageAppInfo> {
        return AppDatabase.all.values.filter { info ->
            info.removalStatus == RemovalStatus.YES
        }
    }

    /**
     * Returns all packages that should never be removed (SafetyLevel.CRITICAL).
     */
    fun getCritical(): List<PackageAppInfo> {
        return AppDatabase.all.values.filter { info ->
            info.safetyLevel == SafetyLevel.CRITICAL
        }
    }

    /**
     * Returns all packages belonging to a specific category.
     *
     * Example:
     *   val facebookApps = AppInfoLibrary.getByCategory(AppCategory.META_FACEBOOK)
     */
    fun getByCategory(category: AppCategory): List<PackageAppInfo> {
        return AppDatabase.all.values.filter { info -> info.category == category }
    }

    /**
     * Returns all packages that have a non-null privacyNote.
     * Use this to show the user which apps are privacy risks.
     */
    fun getPrivacyConcerns(): List<PackageAppInfo> {
        return AppDatabase.all.values.filter { info -> info.privacyNote != null }
    }

    /**
     * Returns all packages that require caution if removed.
     */
    fun getCaution(): List<PackageAppInfo> {
        return AppDatabase.all.values.filter { info ->
            info.removalStatus == RemovalStatus.CAUTION
        }
    }

    /**
     * Returns all packages in the database.
     */
    fun getAll(): Map<String, PackageAppInfo> {
        return AppDatabase.all
    }

    /**
     * Returns total number of packages in the database.
     */
    fun count(): Int {
        return AppDatabase.all.size
    }

    /**
     * Returns true if the package exists in the database.
     */
    fun isKnown(packageName: String): Boolean {
        return AppDatabase.all.containsKey(packageName)
    }
}