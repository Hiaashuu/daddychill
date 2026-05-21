package com.hiaashuu.appinfo.models

enum class RemovalStatus {

    /** Do not remove under any circumstance. */
    NO,

    /** Can be removed but test core features after. */
    CAUTION,

    /** Safe to remove. No meaningful system impact. */
    YES
}