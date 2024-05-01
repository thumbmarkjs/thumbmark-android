package com.thumbmarkjs.thumbmark_android.interfaces

import com.thumbmarkjs.thumbmark_android.enums.ComponentVolatility

interface ThumbmarkComponent {
    val key: String
    val values: Map<String, String>
    val volatility: ComponentVolatility
}