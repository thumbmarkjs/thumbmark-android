package com.thumbmarkjs.thumbmark_android

import android.content.Context
import com.thumbmarkjs.thumbmark_android.components.AccessibilityComponent
import com.thumbmarkjs.thumbmark_android.components.ProcessorComponent
import com.thumbmarkjs.thumbmark_android.components.CaptureDevicesComponent
import com.thumbmarkjs.thumbmark_android.components.CommunicationComponent
import com.thumbmarkjs.thumbmark_android.components.DeviceComponent
import com.thumbmarkjs.thumbmark_android.components.LocalityComponent
import com.thumbmarkjs.thumbmark_android.components.MemoryComponent
import com.thumbmarkjs.thumbmark_android.interfaces.ThumbmarkComponent
import com.thumbmarkjs.thumbmark_android.models.CaptureDevice
import com.thumbmarkjs.thumbmark_android.models.Fingerprint
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object Thumbmark {
    internal var components: List<ThumbmarkComponent>? = null

    /**
     * Returns a strongly-typed object representing the current devices known parameters.
     * This function is run on the thread that it was called from.
     * It can be particularly long running depending on the algorithm that is passed in (default is SHA-256).
     *
     * @param context
     * @return
     */
    fun fingerprint(context: Context): Fingerprint {
        val captureDevices: List<CaptureDevice> = CaptureDevicesComponent.getComponent(context)
        val processor = ProcessorComponent.getComponent(context)
        val device = DeviceComponent.getComponent(context)
        val memory = MemoryComponent.getComponent(context)
        val accessibility = AccessibilityComponent.getComponent(context)
        val locality = LocalityComponent.getComponent(context)
        val communication = CommunicationComponent.getComponent(context)
        val components: List<ThumbmarkComponent>? = components

        return Fingerprint(
            captureDevices = captureDevices,
            processor = processor,
            device = device,
            memory = memory,
            accessibility = accessibility,
            locality = locality,
            communication = communication,
            components = components
        )
    }

    /**
     * Applies custom values that will be appended/consumed when calculating the final hashed fingerprint.
     *
     * @param value
     */
    fun setAdditionalComponents(value: List<ThumbmarkComponent>?) {
        components = value
    }

    /**
     * Returns a hashed representation of the `fingerprint` value.
     * This function is run on the thread that it was called from.
     * It can be particularly long running depending on the algorithm that is passed in (default is SHA-256).
     *
     * @param algorithm
     */
    @Throws(NoSuchAlgorithmException::class)
    fun id(context: Context, algorithm: String = "SHA-256", fingerprint: Fingerprint = fingerprint(context)) = MessageDigest
        .getInstance(algorithm)
        .digest(Json.encodeToString(fingerprint).toByteArray())
        .fold("") { str, it -> str + "%02x".format(it) }
}