package com.thumbmarkjs.thumbmark_android.components

import android.content.Context
import androidx.core.text.util.LocalePreferences
import com.thumbmarkjs.thumbmark_android.enums.ComponentVolatility
import com.thumbmarkjs.thumbmark_android.interfaces.Component
import com.thumbmarkjs.thumbmark_android.models.Communication

object CommunicationComponent : Component<Communication> {
    override fun getComponent(context: Context?): Communication {
        return Communication(
            mobileNetworkCode = context?.resources?.configuration?.mnc,
            mobileCountryCode = context?.resources?.configuration?.mcc
        )
    }

    override val volatility: ComponentVolatility = ComponentVolatility.MEDIUM
}