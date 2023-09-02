package com.open6.taleadventure.presentation.onboard.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.FragmentOnboardFirstBinding
import com.open6.taleadventure.presentation.base.fragment.BaseDataBindingFragment
import com.open6.taleadventure.presentation.onboard.viewmodel.OnboardFirstViewModel
import com.open6.taleadventure.util.builder.StringIntMapBuilder
import com.open6.taleadventure.util.extensions.makeToastMessage

class OnboardFirstFragment :
    BaseDataBindingFragment<FragmentOnboardFirstBinding>(R.layout.fragment_onboard_first) {

    private val viewModel by viewModels<OnboardFirstViewModel>()

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData()
        setClickEvents()
        setObservers()
    }

    private fun setObservers() {
        setSetAgeResponse()
    }

    private fun setSetAgeResponse() {
        setSetAgeSuccessResponse()
        setSetAgeErrorResponse()
    }

    private fun setSetAgeSuccessResponse() {
        viewModel.setAgeSuccessResponse.observe(viewLifecycleOwner) { successData ->
            findNavController().navigate(R.id.action_onboardFirstFragment_to_onboardSecondFragment)
            viewModel.resetSelectedView()
        }
    }

    private fun setSetAgeErrorResponse() {
        viewModel.setAgeErrorResponse.observe(viewLifecycleOwner) { errorMessage ->
            makeToastMessage(errorMessage)
        }
    }

    private fun setClickEvents() {
        setNextTVClickEvent()
    }

    private fun setNextTVClickEvent() {
        binding.tvOnboardFirstNext.setOnClickListener {
            viewModel.setAge()
        }
    }

    private fun setData() {
        setAgeMap()
    }

    private fun setAgeMap() {
        with(binding) {
            val ageMap = StringIntMapBuilder().addView(tvOnboardFirstAgeFirst.text.toString(), 2)
                .addView(tvOnboardFirstAgeSecond.text.toString(), 5)
                .addView(tvOnboardFirstAgeThird.text.toString(), 8)
                .addView(tvOnboardFirstAgeFourth.text.toString(), 9).build()

            viewModel.setAgeMap(ageMap)
        }
    }

}