package com.taleadventure.teamfiveeagles.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import com.taleadventure.teamfiveeagles.databinding.ActivityMainBinding
import com.taleadventure.teamfiveeagles.presentation.base.BaseViewBindingActivity

class MainActivity : BaseViewBindingActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setBinding(layoutInflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)
}