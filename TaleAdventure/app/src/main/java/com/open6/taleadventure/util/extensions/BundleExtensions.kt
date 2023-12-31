package com.open6.taleadventure.util.extensions

import android.os.Build
import android.os.Bundle

fun <T> Bundle.getParcelableFromBundle(name: String, clazz: Class<T>): T? =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelable(name, clazz)
    } else {
        getParcelable(name)
    }