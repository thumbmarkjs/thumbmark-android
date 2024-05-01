package com.thumbmarkjs.thumbmark_android.components

import android.content.Context
import com.thumbmarkjs.thumbmark_android.enums.ComponentVolatility
import com.thumbmarkjs.thumbmark_android.interfaces.Component
import com.thumbmarkjs.thumbmark_android.models.Processor

object ProcessorComponent : Component<Processor> {
    override fun getComponent(context: Context?): Processor {
        return Processor(
            processorCount = Runtime.getRuntime().availableProcessors(),
            totalMemory = Runtime.getRuntime().totalMemory(),
            maxMemory = Runtime.getRuntime().maxMemory(),
            architecture = System.getProperty("os.arch"),
            kernelVersion = System.getProperty("os.version")
        )
    }

    override val volatility: ComponentVolatility = ComponentVolatility.MEDIUM
}