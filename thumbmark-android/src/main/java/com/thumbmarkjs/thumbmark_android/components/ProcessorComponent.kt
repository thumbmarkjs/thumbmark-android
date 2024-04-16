package com.thumbmarkjs.thumbmark_android.components

import android.content.Context
import com.thumbmarkjs.thumbmark_android.interfaces.Component
import com.thumbmarkjs.thumbmark_android.models.Processor

object ProcessorComponent : Component<Processor> {
    override fun getComponent(context: Context?): Processor {
        return Processor(Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().totalMemory(),
            Runtime.getRuntime().maxMemory(),
            System.getProperty("os.arch"),
            System.getProperty("os.version"))
    }
}