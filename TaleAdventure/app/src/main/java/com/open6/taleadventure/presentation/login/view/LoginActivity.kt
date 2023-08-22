package com.open6.taleadventure.presentation.login.view

import android.os.Bundle
import android.view.LayoutInflater
import com.open6.taleadventure.databinding.ActivityLoginBinding
import com.open6.taleadventure.presentation.base.BaseViewBindingActivity

class LoginActivity : BaseViewBindingActivity<ActivityLoginBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun setBinding(inflater: LayoutInflater): ActivityLoginBinding =
        ActivityLoginBinding.inflate(inflater)

}