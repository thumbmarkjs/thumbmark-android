package com.thumbmarkjs.thumbmark_android.models

import kotlinx.serialization.Serializable

@Serializable
data class Accessibility(
    val fontWeightAdjustment: Int,
    val fontScale: Float?,
    val colorMode: Int,
    val density: Float?,
    val touchExplorationEnabled: Boolean,
    val nightModeEnabled: Boolean
)
