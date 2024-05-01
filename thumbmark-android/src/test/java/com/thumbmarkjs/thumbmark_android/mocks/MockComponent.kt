package com.thumbmarkjs.thumbmark_android.mocks

import com.thumbmarkjs.thumbmark_android.enums.ComponentVolatility
import com.thumbmarkjs.thumbmark_android.interfaces.ThumbmarkComponent

class MockComponent: ThumbmarkComponent {
    override val key: String
        get() = "mockComponent"
    override val values: Map<String, String>
        get() {
            val value: MutableMap<String, String> = mutableMapOf()
            value["someKey"] = "someValue"
            return value
        }

    override val volatility: ComponentVolatility
        get() = ComponentVolatility.LOW
}