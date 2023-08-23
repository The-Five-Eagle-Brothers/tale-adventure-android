package com.open6.taleadventure.presentation.onboard.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.FragmentOnboardFourthBinding
import com.open6.taleadventure.presentation.base.BaseDataBindingFragment
import com.open6.taleadventure.presentation.onboard.viewmodel.OnboardFourthViewModel

class OnboardFourthFragment :
    BaseDataBindingFragment<FragmentOnboardFourthBinding>(R.layout.fragment_onboard_fourth) {

    private val viewModel by viewModels<OnboardFourthViewModel>()

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}