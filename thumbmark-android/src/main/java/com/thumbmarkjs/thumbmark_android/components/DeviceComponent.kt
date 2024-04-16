package com.thumbmarkjs.thumbmark_android.components

import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.os.Build
import android.provider.Settings
import com.thumbmarkjs.thumbmark_android.interfaces.Component
import com.thumbmarkjs.thumbmark_android.models.Device

object DeviceComponent : Component<Device> {
    override fun getComponent(context: Context?): Device {
        return Device(Build.DEVICE,
            Build.MODEL,
            Build.HOST,
            System.getProperty("os.version"),
            System.getProperty("os.name"))
    }
}