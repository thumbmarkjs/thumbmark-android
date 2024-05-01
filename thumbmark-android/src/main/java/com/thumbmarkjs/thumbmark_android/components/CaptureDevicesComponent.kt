package com.thumbmarkjs.thumbmark_android.components

import android.content.Context
import android.hardware.Camera
import com.thumbmarkjs.thumbmark_android.enums.ComponentVolatility
import com.thumbmarkjs.thumbmark_android.interfaces.Component
import com.thumbmarkjs.thumbmark_android.models.CaptureDevice
import java.util.LinkedList

object CaptureDevicesComponent : Component<List<CaptureDevice>> {
    override fun getComponent(context: Context?): List<CaptureDevice> {
        val numberOfCameras = Camera.getNumberOfCameras()
        val result = LinkedList<CaptureDevice>()
        for (i in 0 until numberOfCameras) {
            val info = Camera.CameraInfo()
            Camera.getCameraInfo(i, info)
            val facing = facingDescription(info.facing)
            val orientation = info.orientation.toString()
            result.add(CaptureDevice(i.toString(), facing, orientation))
        }
        return result
    }

    override val volatility: ComponentVolatility
        get() = ComponentVolatility.LOW

    private fun facingDescription(from: Int) = when (from) {
        Camera.CameraInfo.CAMERA_FACING_FRONT -> "front"
        Camera.CameraInfo.CAMERA_FACING_BACK -> "back"
        else -> ""
    }
}