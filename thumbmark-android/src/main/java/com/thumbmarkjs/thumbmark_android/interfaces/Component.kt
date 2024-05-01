package com.thumbmarkjs.thumbmark_android.interfaces

import android.content.Context
import com.thumbmarkjs.thumbmark_android.enums.ComponentVolatility

interface Component<T> {
    fun getComponent(context: Context?): T
    val volatility: ComponentVolatility

    fun withVolatilityThreshold(context: Context?, threshold: ComponentVolatility): T? {
        return if (volatility <= threshold) {
            getComponent(context)
        } else {
            null
        }
    }
}