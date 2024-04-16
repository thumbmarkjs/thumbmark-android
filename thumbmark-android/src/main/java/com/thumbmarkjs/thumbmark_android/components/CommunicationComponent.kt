package com.thumbmarkjs.thumbmark_android.components

import android.content.Context
import androidx.core.text.util.LocalePreferences
import com.thumbmarkjs.thumbmark_android.interfaces.Component
import com.thumbmarkjs.thumbmark_android.models.Communication

object CommunicationComponent : Component<Communication> {
    override fun getComponent(context: Context?): Communication {
        return Communication(
            context?.resources?.configuration?.mnc,
            context?.resources?.configuration?.mcc
        )
    }
}