package com.open6.taleadventure.presentation.tale.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import coil.load
import com.open6.taleadventure.data.remote.model.chapter.ResponseChapterDto
import com.open6.taleadventure.databinding.ActivityTaleBinding
import com.open6.taleadventure.presentation.base.activity.BaseViewBindingActivity
import com.open6.taleadventure.presentation.tale.adapter.ChapterAdapter
import com.open6.taleadventure.presentation.tale.viewmodel.TaleViewModel
import com.open6.taleadventure.presentation.wordgame.view.WordGameActivity
import com.open6.taleadventure.util.PublicString.CHAPTER_NAME
import com.open6.taleadventure.util.PublicString.IS_FROM_CHAPTER
import com.open6.taleadventure.util.extensions.makeToastMessage

class TaleActivity : BaseViewBindingActivity<ActivityTaleBinding>() {
    private val viewModel by viewModels<TaleViewModel>()
    private val chapterAdapter by lazy { ChapterAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getData()
        setViews()
        setClickEvents()
        setObservers()
    }

    private fun setObservers() {
        setGetChaptersObservers()
    }

    private fun setGetChaptersObservers() {
        setGetChaptersSuccessObserver()
        setGetChaptersErrorObserver()
    }

    private fun setGetChaptersSuccessObserver() {
        viewModel.getChaptersSuccessResponse.observe(this) { successData ->
            successData.run {
                setData()
                updateChapterAdapter()
            }
        }
    }

    private fun List<ResponseChapterDto>?.setData() {
        binding.ivTaleBack.load(this?.first()?.taleBook?.chapterImageUrl)
    }

    private fun List<ResponseChapterDto>?.updateChapterAdapter() {
        chapterAdapter.submitList(this)
    }

    private fun setGetChaptersErrorObserver() {
        viewModel.getChaptersErrorResponse.observe(this) { errorMessage ->
            makeToastMessage(errorMessage)
        }
    }

    private fun getData() {
        viewModel.getChapters()
    }

    private fun setClickEvents() {
        setBackIVClickEvent()
    }

    private fun setBackIVClickEvent() {
        binding.ivTaleBack.setOnClickListener { if (!isFinishing) finish() }
    }

    private fun setViews() {
        setChapterAdapter()
    }

    private fun setChapterAdapter() {
        binding.rvTaleChapter.adapter = chapterAdapter.also { adapter ->
            adapter.setOnItemClick(navigateToGameActivity)
        }
    }

    private val navigateToGameActivity: (String) -> Unit = { chapterName ->
        Intent(this, WordGameActivity::class.java).putExtra(CHAPTER_NAME, chapterName).putExtra(
            IS_FROM_CHAPTER, true
        ).also { intent ->
            startActivity(intent)
        }
    }

    override fun setBinding(inflater: LayoutInflater): ActivityTaleBinding =
        ActivityTaleBinding.inflate(inflater)
}