package com.thumbmarkjs.thumbmark_android.components

import android.app.ActivityManager
import android.content.Context
import android.os.Environment
import android.os.StatFs
import com.thumbmarkjs.thumbmark_android.interfaces.Component
import com.thumbmarkjs.thumbmark_android.models.Memory


object MemoryComponent : Component<Memory> {
    override fun getComponent(context: Context?): Memory {
        return Memory(ramSize(context), diskSize)
    }

    private fun ramSize(context: Context?): Long {
            val manager = context?.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val memoryInfo = ActivityManager.MemoryInfo()
            manager.getMemoryInfo(memoryInfo)
            return memoryInfo.totalMem
        }

    private val diskSize: Long
        get() {
            return StatFs(Environment.getRootDirectory().absolutePath).totalBytes
        }
}
