package com.thumbmarkjs.thumbmark_android.models

import kotlinx.serialization.Serializable

@Serializable
data class Communication(
    var mobileCountryCode: Int?,
    var mobileNetworkCode: Int?
)