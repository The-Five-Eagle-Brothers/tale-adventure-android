package com.taleadventure.teamfiveeagles

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import com.kakao.sdk.common.KakaoSdk
import com.taleadventure.teamfiveeagles.util.timber.TaleAdventureTimber
import timber.log.Timber

class TaleAdventureApp : Application() {
    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        setTimber()
        setKakaoSdk()
    }

    private fun setKakaoSdk() {
        KakaoSdk.init(this, BuildConfig.KAKAO_NATIVE_APP_KEY)
    }

    private fun setTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(TaleAdventureTimber())
        }
    }
}