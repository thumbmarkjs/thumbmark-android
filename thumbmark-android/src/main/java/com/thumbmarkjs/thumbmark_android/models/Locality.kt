package com.thumbmarkjs.thumbmark_android.models

import kotlinx.serialization.Serializable

@Serializable
data class Locality(
    val country: String?,
    val languageCode: String?,
    val script: String?,
    val isO3Country: String?,
    val isO3Language: String?,
    val calendarIdentifier: String?,
    val timezone: String?,
    val twentyFourHourTimeEnabled: Boolean,
    val temperatureUnit: String
)