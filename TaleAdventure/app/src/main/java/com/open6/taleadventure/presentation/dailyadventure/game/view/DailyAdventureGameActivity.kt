package com.open6.taleadventure.presentation.dailyadventure.game.view

import android.os.Bundle
import android.view.LayoutInflater
import com.open6.taleadventure.databinding.ActivityDailyAdventureGameBinding
import com.open6.taleadventure.presentation.base.activity.BaseViewBindingActivity

class DailyAdventureGameActivity : BaseViewBindingActivity<ActivityDailyAdventureGameBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun setBinding(inflater: LayoutInflater): ActivityDailyAdventureGameBinding =
        ActivityDailyAdventureGameBinding.inflate(layoutInflater)
}