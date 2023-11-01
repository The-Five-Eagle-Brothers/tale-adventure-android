package com.open6.taleadventure.presentation.main.view

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.open6.taleadventure.R
import com.open6.taleadventure.data.local.TaleAdventureSharedPreferences
import com.open6.taleadventure.databinding.ActivityMainBinding
import com.open6.taleadventure.presentation.base.activity.BaseViewBindingActivity
import com.open6.taleadventure.util.PublicString.DID_USER_CHOOSE_TO_BE_NOTIFIED

class MainActivity : BaseViewBindingActivity<ActivityMainBinding>() {
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setViews()
        requestPermissions()
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

    private fun requestPermissions() {
        setResultLaunchers()
        requestNotificationPermission()
    }

    private fun setResultLaunchers() {
        requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission(),
        ) { isGranted: Boolean ->
            TaleAdventureSharedPreferences.setBoolean(DID_USER_CHOOSE_TO_BE_NOTIFIED, isGranted)
        }
    }

    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS,
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                // FCM SDK (and your app) can post notifications.
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                // TODO: display an educational UI explaining to the user the features that will be enabled
                //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
                //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
                //       If the user selects "No thanks," allow the user to continue without notifications.
            } else {
                // Directly ask for the permission (first time)
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        } else {
            TaleAdventureSharedPreferences.setBoolean(DID_USER_CHOOSE_TO_BE_NOTIFIED, true)
        }
    }

    override fun setBinding(inflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(inflater)
}