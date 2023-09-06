package com.open6.taleadventure.presentation.home.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.open6.taleadventure.R
import com.open6.taleadventure.data.remote.model.home.ResponseHomeDto
import com.open6.taleadventure.databinding.FragmentHomeBinding
import com.open6.taleadventure.presentation.base.fragment.BaseDataBindingFragment
import com.open6.taleadventure.presentation.dailyadventure.game.view.DailyAdventureGameActivity
import com.open6.taleadventure.presentation.home.adapter.LibraryAdapter
import com.open6.taleadventure.presentation.home.viewmodel.HomeViewModel
import com.open6.taleadventure.presentation.tale.view.TaleActivity
import com.open6.taleadventure.util.PublicString.TALE_NAME
import com.open6.taleadventure.util.extensions.makeToastMessage

class HomeFragment : BaseDataBindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val viewModel by viewModels<HomeViewModel>()
    private var libraryAdapter: LibraryAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        setViews()
        setClickEvents()
        setObservers()
    }

    private fun setObservers() {
        setGetHomeDataObservers()
    }

    private fun setGetHomeDataObservers() {
        setGetHomeDataSuccessResponseObserver()
        setGetHomeDataErrorResponseObserver()
    }

    private fun setGetHomeDataSuccessResponseObserver() {
        viewModel.getHomeDataSuccessResponse.observe(viewLifecycleOwner) { successData ->
            successData.run {
                setData()
                updateLibraryAdapter()
            }
        }
    }

    private fun ResponseHomeDto?.updateLibraryAdapter() {
        libraryAdapter?.run {
            submitList(this@updateLibraryAdapter?.taleBooks)
            setOnItemClick(navigateToLibraryActivity)
        }
    }

    private val navigateToLibraryActivity: (String) -> Unit = { taleName ->
        kotlin.run {
            val activity = requireActivity()
            Intent(activity, TaleActivity::class.java).putExtra(TALE_NAME, taleName)
                .also { intent ->
                    startActivity(intent)
                }
        }
    }

    private fun ResponseHomeDto?.setData() {
        binding.run {
            tvHomeDay.text = (this@setData?.day ?: 1).toString()
            tvHomeNickname.text =
                (this@setData?.nickname ?: getString(R.string.nickname_example)).toString()
        }
    }

    private fun setGetHomeDataErrorResponseObserver() {
        viewModel.getHomeDataErrorResponse.observe(viewLifecycleOwner) { errorMessage ->
            makeToastMessage(errorMessage)
        }
    }

    private fun getData() {
        viewModel.getHomeData()
    }

    private fun setViews() {
        setLibraryRecyclerView()
    }

    private fun setLibraryRecyclerView() {
        libraryAdapter = LibraryAdapter()
        binding.rvHomeLibrary.adapter = libraryAdapter
    }

    private fun setClickEvents() {
        setGamePlayTVClickEvent()
    }

    private fun setGamePlayTVClickEvent() {
        binding.tvHomeGamePlay.setOnClickListener {
            startActivity(Intent(requireActivity(), DailyAdventureGameActivity::class.java))
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