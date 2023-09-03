package com.open6.taleadventure.presentation.main.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.ActivityMainBinding
import com.open6.taleadventure.presentation.base.activity.BaseViewBindingActivity

class MainActivity : BaseViewBindingActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setViews()
    }

    private fun setViews() {
        setMainBnv()
    }

    private fun setMainBnv() {
        setIconBackgroundTransparent()
        setBnvRounded()
        setFragmentsWithNavController()
    }

    private fun setFragmentsWithNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_main) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bnvMain.setupWithNavController(navController)
    }

    private fun setIconBackgroundTransparent() {
        binding.bnvMain.itemIconTintList = null
    }

    private fun setBnvRounded() {
        val bnvRadius = resources.getDimension(R.dimen.bnv_radius)
        val bottomNavigationViewBackground = binding.bnvMain.background as MaterialShapeDrawable
        bottomNavigationViewBackground.shapeAppearanceModel =
            bottomNavigationViewBackground.shapeAppearanceModel.toBuilder()
                .setTopRightCorner(CornerFamily.ROUNDED, bnvRadius)
                .setTopLeftCorner(CornerFamily.ROUNDED, bnvRadius).build()
    }

    override fun setBinding(inflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(inflater)
}