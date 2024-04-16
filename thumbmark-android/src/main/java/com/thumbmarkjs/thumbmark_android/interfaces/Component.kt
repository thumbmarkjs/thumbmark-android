package com.thumbmarkjs.thumbmark_android.interfaces

import android.content.Context

interface Component<T> {
    fun getComponent(context: Context?): T
}
