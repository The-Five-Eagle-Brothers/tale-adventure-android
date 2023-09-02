package com.open6.taleadventure.presentation.home.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.FragmentHomeBinding
import com.open6.taleadventure.presentation.base.fragment.BaseDataBindingFragment
import com.open6.taleadventure.presentation.home.adapter.LibraryAdapter
import com.open6.taleadventure.presentation.home.viewmodel.HomeViewModel

class HomeFragment : BaseDataBindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val viewModel by viewModels<HomeViewModel>()
    private var libraryAdapter: LibraryAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setClickEvents()
    }

    private fun setViews() {
        setLibraryRecyclerView()
    }

    private fun setLibraryRecyclerView() {
        libraryAdapter = LibraryAdapter()
        binding.rvHomeLibrary.adapter = libraryAdapter
    }

    private val navigateToLibraryActivity = {
        // TODO : 라이브러리 - 동화 페이지로 이동
    }

    private fun setClickEvents() {
        setGamePlayTVClickEvent()
    }

    private fun setGamePlayTVClickEvent() {
        binding.tvHomeGamePlay.setOnClickListener {
            // TODO : 데일리 어드벤쳐 메인 뷰로 이동
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        libraryAdapter = null
    }

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }
}