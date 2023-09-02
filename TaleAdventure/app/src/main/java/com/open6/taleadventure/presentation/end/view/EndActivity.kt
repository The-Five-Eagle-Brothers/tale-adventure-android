package com.open6.taleadventure.presentation.end.view

import android.os.Bundle
import androidx.activity.viewModels
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.ActivityEndBinding
import com.open6.taleadventure.presentation.base.activity.BaseDataBindingActivity
import com.open6.taleadventure.presentation.end.adapter.WordsAdapter
import com.open6.taleadventure.presentation.end.viewmodel.EndViewModel

class EndActivity : BaseDataBindingActivity<ActivityEndBinding>(R.layout.activity_end) {
    private val viewModel by viewModels<EndViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setViews()
        setClickEvents()
    }

    private fun setClickEvents() {
        setCompleteIVClickEvent()
    }

    private fun setCompleteIVClickEvent() {
        binding.btnEndComplete.setOnClickListener {
            if (!isFinishing) finish()
        }
    }

    private fun setViews() {
        setScoreAdapter()
    }

    private fun setScoreAdapter() {
        binding.rvEndWords.adapter = WordsAdapter()
    }

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }
}