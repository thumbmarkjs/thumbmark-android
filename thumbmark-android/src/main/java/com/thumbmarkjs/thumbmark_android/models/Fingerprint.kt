package com.thumbmarkjs.thumbmark_android.models

import com.thumbmarkjs.thumbmark_android.interfaces.ThumbmarkComponent
import kotlinx.serialization.Serializable

@Serializable
data class Fingerprint(
    var captureDevices: List<CaptureDevice>?,
    var processor: Processor?,
    var device: Device?,
    var memory: Memory?,
    var accessibility: Accessibility?,
    var locality: Locality?,
    var communication: Communication?,
    var components: List<ThumbmarkComponent>?
)
