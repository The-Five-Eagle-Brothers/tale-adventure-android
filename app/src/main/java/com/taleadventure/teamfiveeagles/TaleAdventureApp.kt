package com.taleadventure.teamfiveeagles

import android.app.Application
import com.taleadventure.teamfiveeagles.util.timber.TaleAdventureTimber
import timber.log.Timber

class TaleAdventureApp : Application() {
    override fun onCreate() {
        super.onCreate()

        setTimber()
    }

    private fun setTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(TaleAdventureTimber())
        }
    }
}