package com.open6.taleadventure.presentation.dailyadventure.game.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import com.open6.taleadventure.databinding.ActivityDailyAdventureGameBinding
import com.open6.taleadventure.presentation.base.activity.BaseViewBindingActivity

class DailyAdventureGameActivity : BaseViewBindingActivity<ActivityDailyAdventureGameBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setViews()
    }

    private fun setViews() {
        setWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setWebView() {
        binding.wvDailyAdventureGame.run {
            settings.javaScriptEnabled = true
            loadUrl("https://tale-adventure-webview.vercel.app/")
        }
    }

    override fun setBinding(inflater: LayoutInflater): ActivityDailyAdventureGameBinding =
        ActivityDailyAdventureGameBinding.inflate(layoutInflater)
}