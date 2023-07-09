package com.android.ssutudy.presentation.base

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.android.ssutudy.util.extensions.hideKeyboard

abstract class BaseDataBindingActivity<DB : ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    AppCompatActivity() {

    lateinit var binding: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getInflatedLayout())
        bindViewModelWithBinding()
    }

    protected abstract fun bindViewModelWithBinding()

    private fun getInflatedLayout(): View {
        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        hideKeyboard(binding.root)
        return super.dispatchTouchEvent(ev)
    }
}