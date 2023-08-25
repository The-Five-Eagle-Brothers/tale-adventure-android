package com.open6.taleadventure.util.builder

import android.view.View

class ViewIntMapBuilder {
    private val viewIntMap: MutableMap<View, Int> = mutableMapOf()

    fun addView(view: View, maxAge: Int): ViewIntMapBuilder {
        viewIntMap[view] = maxAge
        return this
    }

    fun build() = viewIntMap
}