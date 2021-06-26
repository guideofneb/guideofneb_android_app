package com.rishadbaniya.guideofneb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.ads.MobileAds
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBTheme
import com.rishadbaniya.guideofneb.ui.GuideofNEBApp
import com.rishadbaniya.guideofneb.viewmodels.LocalMainViewModel
import com.rishadbaniya.guideofneb.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    @ExperimentalMaterialApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_GuideOfNEB_NoActionBar)
        setContent {
            val navController = rememberNavController()
            GuideOfNEBTheme(isDark = false){
                Surface(color = GuideOfNEBTheme.colors.background) {
                    CompositionLocalProvider(LocalMainViewModel provides mainViewModel) {
                        GuideofNEBApp(navController = navController)
                    }
                }
            }
        }
        MobileAds.initialize(this)
    }
}




