package com.open6.taleadventure.presentation.dailyadventure.list.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.open6.taleadventure.databinding.ActivityDailyAdventureListBinding
import com.open6.taleadventure.presentation.base.activity.BaseViewBindingActivity
import com.open6.taleadventure.presentation.dailyadventure.game.view.DailyAdventureGameActivity
import com.open6.taleadventure.presentation.dailyadventure.list.adapter.DailyAdventureListAdapter
import com.open6.taleadventure.presentation.dailyadventure.list.model.DailyAdventure

class DailyAdventureListActivity : BaseViewBindingActivity<ActivityDailyAdventureListBinding>() {
    private val dailyAdventureListAdapter by lazy {
        DailyAdventureListAdapter(
            navigateToDailyAdventureGameActivity
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setData()
        setViews()
        setClickEvents()
    }

    private fun setData() {

    }

    private fun setClickEvents() {
        setBackIVClickEvent()
    }

    private fun setBackIVClickEvent() {
        binding.ivDailyAdventureListBack.setOnClickListener {
            if (!isFinishing) finish()
        }
    }

    private fun setViews() {
        setDailyAdventureListAdapter()
    }

    private fun setDailyAdventureListAdapter() {
        binding.rvDailyAdventureList.adapter = dailyAdventureListAdapter
        dailyAdventureListAdapter.submitList(listOf(DailyAdventure(1)))
    }

    private val navigateToDailyAdventureGameActivity: () -> Unit = {
        startActivity(Intent(this, DailyAdventureGameActivity::class.java))
    }

    override fun setBinding(inflater: LayoutInflater): ActivityDailyAdventureListBinding =
        ActivityDailyAdventureListBinding.inflate(layoutInflater)
}