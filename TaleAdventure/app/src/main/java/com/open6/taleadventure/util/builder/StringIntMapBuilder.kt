package com.open6.taleadventure.util.builder

class StringIntMapBuilder {
    private val stringIntMap: MutableMap<String, Int> = mutableMapOf()

    fun addView(text: String, maxAge: Int): StringIntMapBuilder {
        stringIntMap[text] = maxAge
        return this
    }

    fun build() = stringIntMap
}