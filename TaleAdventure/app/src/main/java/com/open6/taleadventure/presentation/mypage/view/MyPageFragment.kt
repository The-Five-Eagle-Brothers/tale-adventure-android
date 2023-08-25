package com.open6.taleadventure.presentation.mypage.view

import androidx.fragment.app.viewModels
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.FragmentMyPageBinding
import com.open6.taleadventure.presentation.base.BaseDataBindingFragment
import com.open6.taleadventure.presentation.mypage.viewmodel.MyPageViewModel

class MyPageFragment : BaseDataBindingFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {
    private val viewModel by viewModels<MyPageViewModel>()

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }
}