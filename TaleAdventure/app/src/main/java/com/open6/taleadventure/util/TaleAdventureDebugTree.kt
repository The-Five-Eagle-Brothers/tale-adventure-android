package com.open6.taleadventure.util

import timber.log.Timber

class TaleAdventureDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement) =
        "${element.fileName}:${element.lineNumber}#${element.methodName}"
}