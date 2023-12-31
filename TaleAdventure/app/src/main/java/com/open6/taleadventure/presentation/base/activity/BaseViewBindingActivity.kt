package com.open6.taleadventure.presentation.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.open6.taleadventure.util.extensions.hideKeyboard

abstract class BaseViewBindingActivity<VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getInflatedLayout(layoutInflater))
    }

    protected abstract fun setBinding(inflater: LayoutInflater): VB

    private fun getInflatedLayout(inflater: LayoutInflater): View {
        binding = setBinding(inflater)
        return binding.root
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        hideKeyboard(binding.root)
        return super.dispatchTouchEvent(ev)
    }
}