package com.taleadventure.teamfiveeagles.util.timber

import timber.log.Timber

class TaleAdventureTimber : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement) =
        "Timber : ${element.fileName}:${element.lineNumber}#${element.methodName}"
}