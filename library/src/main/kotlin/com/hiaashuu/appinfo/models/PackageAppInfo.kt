package com.hiaashuu.appinfo.models

data class PackageAppInfo(
    val packageName: String,
    val appName: String,
    val purpose: String,
    val category: AppCategory,
    val safetyLevel: SafetyLevel,
    val removalStatus: RemovalStatus,
    val keyPermissions: List<String> = emptyList(),
    val privacyNote: String? = null,
    val impactIfDisabled: String? = null,
    val replacements: List<String> = emptyList(),
    val removalCommand: String? = null,
    val notes: String? = null
)