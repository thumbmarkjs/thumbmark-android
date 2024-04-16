package com.thumbmarkjs.thumbmark_android.models

import kotlinx.serialization.Serializable

@Serializable
data class Device(
    val machine: String,
    val model: String,
    val hostName: String,
    val osVersion: String?,
    val osName: String?
)