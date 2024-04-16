package com.thumbmarkjs.thumbmark_android.mocks

import com.thumbmarkjs.thumbmark_android.Thumbmark
import com.thumbmarkjs.thumbmark_android.components.AccessibilityComponent
import com.thumbmarkjs.thumbmark_android.components.CaptureDevicesComponent
import com.thumbmarkjs.thumbmark_android.components.CommunicationComponent
import com.thumbmarkjs.thumbmark_android.components.DeviceComponent
import com.thumbmarkjs.thumbmark_android.components.LocalityComponent
import com.thumbmarkjs.thumbmark_android.components.MemoryComponent
import com.thumbmarkjs.thumbmark_android.components.ProcessorComponent
import com.thumbmarkjs.thumbmark_android.interfaces.ThumbmarkComponent
import com.thumbmarkjs.thumbmark_android.models.Accessibility
import com.thumbmarkjs.thumbmark_android.models.CaptureDevice
import com.thumbmarkjs.thumbmark_android.models.Communication
import com.thumbmarkjs.thumbmark_android.models.Device
import com.thumbmarkjs.thumbmark_android.models.Fingerprint
import com.thumbmarkjs.thumbmark_android.models.Locality
import com.thumbmarkjs.thumbmark_android.models.Memory
import com.thumbmarkjs.thumbmark_android.models.Processor

object MockFingerprint {
    val expectedId: String
        get() = ""
    val fingerprint: Fingerprint
        get() {
            val captureDevices: List<CaptureDevice> = listOf(
                CaptureDevice(
                    "mockPosition",
                    "mockFacing",
                    "mockOrientation")
            )
            val processor = Processor(
                8,
                123456,
                123456789,
                "x86",
                "1.33.7"
            )
            val device = Device(
                "mockMachine",
                "mockModel",
                "mockHost",
                "mockVersion",
                "mockOs"
            )
            val memory = Memory(
                12345,
                1234567890
            )
            val accessibility = Accessibility(
                1,
                1.0f,
                1,
                1.0f,
                true,
                false
            )
            val locality = Locality(
                "Australia",
                "en-AU",
                "mockScript",
                "mockIsoCountry",
                "mockIsoLanguage",
                "mockCalendar",
                "mockTimezone",
                true,
                "mockTemperature",
            )
            val communication = Communication(
                1,
                2
            )

            return Fingerprint(
                captureDevices = captureDevices,
                processor = processor,
                device = device,
                memory = memory,
                accessibility = accessibility,
                locality = locality,
                communication = communication,
                components = null
            )
        }
}