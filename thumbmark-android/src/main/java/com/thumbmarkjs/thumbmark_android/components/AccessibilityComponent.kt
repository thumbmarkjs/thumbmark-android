package com.thumbmarkjs.thumbmark_android.components

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.accessibility.AccessibilityManager
import com.thumbmarkjs.thumbmark_android.interfaces.Component
import com.thumbmarkjs.thumbmark_android.models.Accessibility


object AccessibilityComponent : Component<Accessibility> {
    @SuppressLint("NewApi")
    override fun getComponent(context: Context?): Accessibility {
        return Accessibility(context?.resources?.configuration?.takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.S }?.fontWeightAdjustment ?: 0,
            context?.resources?.configuration?.takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.O }?.fontScale,
            context?.resources?.configuration?.takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.O }?.colorMode ?: 0,
            context?.resources?.displayMetrics?.scaledDensity,
            (context?.getSystemService(Context.ACCESSIBILITY_SERVICE) as? AccessibilityManager)?.isTouchExplorationEnabled ?: false,
            context?.resources?.configuration?.takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.R }?.isNightModeActive ?: false)
    }
}
