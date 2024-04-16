package com.thumbmarkjs.thumbmark_android.models

import kotlinx.serialization.Serializable

@Serializable
data class CaptureDevice(
    val position: String,
    val facing: String,
    val orientation: String
)
