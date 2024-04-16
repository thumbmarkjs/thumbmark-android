package com.thumbmarkjs.thumbmark_android.models

import kotlinx.serialization.Serializable

@Serializable
data class Memory(
    val ram: Long,
    val diskSize: Long
)
