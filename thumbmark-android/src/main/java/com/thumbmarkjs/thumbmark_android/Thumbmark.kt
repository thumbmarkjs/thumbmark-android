package com.thumbmarkjs.thumbmark_android

import android.content.Context
import com.thumbmarkjs.thumbmark_android.components.AccessibilityComponent
import com.thumbmarkjs.thumbmark_android.components.ProcessorComponent
import com.thumbmarkjs.thumbmark_android.components.CaptureDevicesComponent
import com.thumbmarkjs.thumbmark_android.components.CommunicationComponent
import com.thumbmarkjs.thumbmark_android.components.DeviceComponent
import com.thumbmarkjs.thumbmark_android.components.LocalityComponent
import com.thumbmarkjs.thumbmark_android.components.MemoryComponent
import com.thumbmarkjs.thumbmark_android.enums.ComponentVolatility
import com.thumbmarkjs.thumbmark_android.interfaces.ThumbmarkComponent
import com.thumbmarkjs.thumbmark_android.models.CaptureDevice
import com.thumbmarkjs.thumbmark_android.models.Fingerprint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object Thumbmark {
    internal var components: List<ThumbmarkComponent>? = null
    internal var volatility: ComponentVolatility = ComponentVolatility.HIGH

    /**
     * Returns a strongly-typed object representing the current devices known parameters.
     * This function is run on the thread that it was called from.
     *
     * @param context
     * @return
     */
    fun fingerprint(context: Context): Fingerprint {
        val captureDevices = CaptureDevicesComponent.withVolatilityThreshold(context, volatility)
        val processor = ProcessorComponent.withVolatilityThreshold(context, volatility)
        val device = DeviceComponent.withVolatilityThreshold(context, volatility)
        val memory = MemoryComponent.withVolatilityThreshold(context, volatility)
        val accessibility = AccessibilityComponent.withVolatilityThreshold(context, volatility)
        val locality = LocalityComponent.withVolatilityThreshold(context, volatility)
        val communication = CommunicationComponent.withVolatilityThreshold(context, volatility)
        val components: List<ThumbmarkComponent>? = components?.filter { it.volatility <= this.volatility }

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
        this.components = value
    }

    /**
     * Sets the accepted level of "volatility" that will be used when producing id's and fingerprints
     *
     * @param value
     */
    fun setVolatility(value: ComponentVolatility) {
        this.volatility = value
    }

    /**
     * Returns a hashed representation of the `fingerprint` value.
     * This function is run on `Dispatchers.IO`.
     * It can be particularly long running depending on the algorithm that is passed in (default is SHA-256).
     *
     * @param context
     * @param scope
     * @param algorithm
     * @param fingerprint
     * @param onSuccess
     * @param onError
     */
    fun id(
        context: Context,
        scope: CoroutineScope = CoroutineScope(Dispatchers.IO),
        algorithm: String = "SHA-256",
        fingerprint: Fingerprint = fingerprint(context),
        onSuccess: (String) -> Unit,
        onError: (Exception) -> Unit = {}
    ) = scope.launch {
        try {
            val value = id(context, algorithm, fingerprint)
            onSuccess(value)
        } catch (e: Exception) {
            onError(e)
        }
    }

    /**
     * Returns a hashed representation of the `fingerprint` value.
     * This function runs on the thread that it was called on.
     * It can be particularly long running depending on the algorithm that is passed in (default is SHA-256).
     *
     * @param context
     * @param algorithm
     * @param fingerprint
     */
    @Throws(NoSuchAlgorithmException::class)
    fun id(
        context: Context,
        algorithm: String = "SHA-256",
        fingerprint: Fingerprint = fingerprint(context)
    ) = MessageDigest.getInstance(algorithm).digest(Json.encodeToString(fingerprint).toByteArray())
        .fold("") { str, it -> str + "%02x".format(it) }
}