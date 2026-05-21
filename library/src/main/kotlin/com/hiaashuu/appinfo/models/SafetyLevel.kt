package com.hiaashuu.appinfo.models

enum class SafetyLevel {

    /** System will break or become unstable. Never remove. */
    CRITICAL,

    /** Has system dependencies. Remove only if you know the impact. */
    CAUTION,

    /** Generally safe to disable if you don't use the feature. */
    SAFE,

    /** Pre-installed junk with no system role. Safe to remove. */
    BLOATWARE
}