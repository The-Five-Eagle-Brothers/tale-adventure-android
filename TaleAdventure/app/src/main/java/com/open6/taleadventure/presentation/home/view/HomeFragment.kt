package com.open6.taleadventure.presentation.home.view

import androidx.fragment.app.viewModels
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.FragmentHomeBinding
import com.open6.taleadventure.presentation.base.BaseDataBindingFragment
import com.open6.taleadventure.presentation.home.viewmodel.HomeViewModel

class HomeFragment : BaseDataBindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val viewModel by viewModels<HomeViewModel>()

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }
}