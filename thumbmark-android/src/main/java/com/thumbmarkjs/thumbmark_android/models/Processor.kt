package com.thumbmarkjs.thumbmark_android.models

import kotlinx.serialization.Serializable

@Serializable
data class Processor(
    val processorCount: Int,
    val totalMemory: Long,
    val maxMemory: Long,
    val architecture: String?,
    val kernelVersion: String?
)