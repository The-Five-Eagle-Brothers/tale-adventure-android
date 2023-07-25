package com.taleadventure.teamfiveeagles.presentation.login.view

import android.os.Bundle
import androidx.activity.viewModels
import com.taleadventure.teamfiveeagles.R
import com.taleadventure.teamfiveeagles.databinding.ActivityLoginBinding
import com.taleadventure.teamfiveeagles.presentation.base.BaseDataBindingActivity
import com.taleadventure.teamfiveeagles.presentation.login.viewmodel.LoginViewModel

class LoginActivity : BaseDataBindingActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }
}