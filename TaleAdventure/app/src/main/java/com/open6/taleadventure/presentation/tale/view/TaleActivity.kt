package com.open6.taleadventure.presentation.tale.view

import android.os.Bundle
import android.view.LayoutInflater
import com.open6.taleadventure.databinding.ActivityTaleBinding
import com.open6.taleadventure.presentation.base.BaseViewBindingActivity
import com.open6.taleadventure.presentation.tale.adapter.ChapterAdapter

class TaleActivity : BaseViewBindingActivity<ActivityTaleBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setViews()
    }

    private fun setViews() {
        setChapterAdapter()
    }

    private fun setChapterAdapter() {
        binding.rvTaleChapter.adapter = ChapterAdapter()
    }

    override fun setBinding(inflater: LayoutInflater): ActivityTaleBinding =
        ActivityTaleBinding.inflate(inflater)
}