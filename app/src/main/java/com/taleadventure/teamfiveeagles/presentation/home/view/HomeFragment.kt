package com.taleadventure.teamfiveeagles.presentation.home.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.taleadventure.teamfiveeagles.R
import com.taleadventure.teamfiveeagles.databinding.FragmentHomeBinding
import com.taleadventure.teamfiveeagles.presentation.base.BaseDataBindingFragment
import com.taleadventure.teamfiveeagles.presentation.home.viewmodel.HomeViewModel

class HomeFragment : BaseDataBindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel by viewModels<HomeViewModel>()

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}