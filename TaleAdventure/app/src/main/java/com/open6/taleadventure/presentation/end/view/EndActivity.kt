package com.open6.taleadventure.presentation.end.view

import android.os.Bundle
import androidx.activity.viewModels
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.ActivityEndBinding
import com.open6.taleadventure.presentation.base.BaseDataBindingActivity
import com.open6.taleadventure.presentation.end.viewmodel.EndViewModel

class EndActivity : BaseDataBindingActivity<ActivityEndBinding>(R.layout.activity_end) {
    private val viewModel by viewModels<EndViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }
}