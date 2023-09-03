package com.open6.taleadventure.presentation.onboard.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.FragmentOnboardThirdBinding
import com.open6.taleadventure.presentation.base.fragment.BaseDataBindingFragment
import com.open6.taleadventure.presentation.onboard.viewmodel.OnboardThirdViewModel

class OnboardThirdFragment :
    BaseDataBindingFragment<FragmentOnboardThirdBinding>(R.layout.fragment_onboard_third) {

    private val navController by lazy { findNavController() }
    private val viewModel by viewModels<OnboardThirdViewModel>()

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClickEvents()
    }

    private fun setClickEvents() {
        setNextTVClickEvent()
        setBackIVClickEvent()
    }

    private fun setBackIVClickEvent() {
        binding.ivOnboardThirdBack.setOnClickListener {
            navController.navigateUp()
        }
    }

    private fun setNextTVClickEvent() {
        binding.tvOnboardThirdNext.setOnClickListener {
            navController.navigate(R.id.action_onboardThirdFragment_to_onboardFourthFragment)
            viewModel.resetSelectedView()
        }
    }

}