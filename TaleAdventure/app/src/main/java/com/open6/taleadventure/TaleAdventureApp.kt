package com.open6.taleadventure

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import com.kakao.sdk.common.KakaoSdk
import com.open6.taleadventure.data.local.TaleAdventureSharedPreferences
import com.open6.taleadventure.util.TaleAdventureDebugTree
import timber.log.Timber

class TaleAdventureApp : Application() {
    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        setTimber()
        setSharedPreferences()
        setKakaoSdk()
    }

    private fun setKakaoSdk() {
        KakaoSdk.init(this, BuildConfig.NATIVE_APP_KEY)
    }

    private fun setSharedPreferences() {
        TaleAdventureSharedPreferences.init(applicationContext)
    }

    private fun setTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(TaleAdventureDebugTree())
        }
    }
}