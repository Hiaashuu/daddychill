package com.hiaashuu.appinfo

import android.content.Context
import android.content.pm.PackageManager
import com.hiaashuu.appinfo.data.AppDatabase
import com.hiaashuu.appinfo.models.AppCategory
import com.hiaashuu.appinfo.models.PackageAppInfo
import com.hiaashuu.appinfo.models.RemovalStatus
import com.hiaashuu.appinfo.models.SafetyLevel

object AppInfoLibrary {

    fun getInfo(packageName: String): PackageAppInfo? {
        return AppDatabase.all[packageName]
    }

    fun getInfoForPackages(packageNames: List<String>): List<PackageAppInfo> {
        return packageNames.mapNotNull { AppDatabase.all[it] }
    }

    fun scanInstalledApps(context: Context): List<PackageAppInfo> {
        val pm: PackageManager = context.packageManager
        val installedPackageNames: List<String> = pm
            .getInstalledPackages(0)
            .map { packageInfo -> packageInfo.packageName }
        return getInfoForPackages(installedPackageNames)
    }

    fun getBySafetyLevel(level: SafetyLevel): List<PackageAppInfo> {
        return AppDatabase.all.values.filter { info -> info.safetyLevel == level }
    }

    fun getSafeToRemove(): List<PackageAppInfo> {
        return AppDatabase.all.values.filter { info ->
            info.removalStatus == RemovalStatus.YES
        }
    }

    fun getCritical(): List<PackageAppInfo> {
        return AppDatabase.all.values.filter { info ->
            info.safetyLevel == SafetyLevel.CRITICAL
        }
    }

    fun getByCategory(category: AppCategory): List<PackageAppInfo> {
        return AppDatabase.all.values.filter { info -> info.category == category }
    }

    fun getPrivacyConcerns(): List<PackageAppInfo> {
        return AppDatabase.all.values.filter { info -> info.privacyNote != null }
    }

    fun getCaution(): List<PackageAppInfo> {
        return AppDatabase.all.values.filter { info ->
            info.removalStatus == RemovalStatus.CAUTION
        }
    }

    fun getAll(): Map<String, PackageAppInfo> {
        return AppDatabase.all
    }

    fun count(): Int {
        return AppDatabase.all.size
    }

    fun isKnown(packageName: String): Boolean {
        return AppDatabase.all.containsKey(packageName)
    }
}