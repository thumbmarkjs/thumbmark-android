package com.thumbmarkjs.thumbmark_android.components

import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.os.Build
import android.provider.Settings
import com.thumbmarkjs.thumbmark_android.enums.ComponentVolatility
import com.thumbmarkjs.thumbmark_android.interfaces.Component
import com.thumbmarkjs.thumbmark_android.models.Device

object DeviceComponent : Component<Device> {
    override fun getComponent(context: Context?): Device {
        return Device(
            machine = Build.DEVICE,
            model = Build.MODEL,
            hostName = Build.HOST,
            osVersion = System.getProperty("os.version"),
            osName = System.getProperty("os.name"))
    }

    override val volatility: ComponentVolatility = ComponentVolatility.HIGH
}