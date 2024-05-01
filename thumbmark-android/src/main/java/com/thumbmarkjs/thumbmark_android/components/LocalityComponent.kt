package com.thumbmarkjs.thumbmark_android.components

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.text.format.DateFormat
import androidx.core.text.util.LocalePreferences
import com.thumbmarkjs.thumbmark_android.enums.ComponentVolatility
import com.thumbmarkjs.thumbmark_android.interfaces.Component
import com.thumbmarkjs.thumbmark_android.models.Locality
import java.util.Calendar

object LocalityComponent : Component<Locality> {
    @SuppressLint("NewApi")
    override fun getComponent(context: Context?): Locality {
        return Locality(
            country = context?.resources?.configuration?.takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.N }?.locales?.get(0)?.country,
            languageCode = context?.resources?.configuration?.takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.N }?.locales?.get(0)?.language,
            script = context?.resources?.configuration?.takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.N }?.locales?.get(0)?.script,
            isO3Country = context?.resources?.configuration?.takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.N }?.locales?.get(0)?.isO3Country,
            isO3Language = context?.resources?.configuration?.takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.N }?.locales?.get(0)?.isO3Language,
            calendarIdentifier = Calendar.getInstance()
                .takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.O }?.calendarType,
            timezone = Calendar.getInstance()
                .takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.O }?.timeZone?.id,
            twentyFourHourTimeEnabled = DateFormat.is24HourFormat(context),
            temperatureUnit = LocalePreferences.getTemperatureUnit()
        )
    }

    override val volatility: ComponentVolatility
        get() = ComponentVolatility.MEDIUM
}
