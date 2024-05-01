package com.thumbmarkjs.thumbmark_android.components

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.accessibility.AccessibilityManager
import com.thumbmarkjs.thumbmark_android.enums.ComponentVolatility
import com.thumbmarkjs.thumbmark_android.interfaces.Component
import com.thumbmarkjs.thumbmark_android.models.Accessibility


object AccessibilityComponent : Component<Accessibility> {
    @SuppressLint("NewApi")
    override fun getComponent(context: Context?): Accessibility {
        return Accessibility(
            fontWeightAdjustment = context?.resources?.configuration?.takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.S }?.fontWeightAdjustment ?: 0,
            fontScale = context?.resources?.configuration?.takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.O }?.fontScale,
            colorMode = context?.resources?.configuration?.takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.O }?.colorMode ?: 0,
            density = context?.resources?.displayMetrics?.scaledDensity,
            touchExplorationEnabled = (context?.getSystemService(Context.ACCESSIBILITY_SERVICE) as? AccessibilityManager)?.isTouchExplorationEnabled ?: false,
            nightModeEnabled = context?.resources?.configuration?.takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.R }?.isNightModeActive ?: false)
    }

    override val volatility: ComponentVolatility
        get() = ComponentVolatility.MEDIUM
}
