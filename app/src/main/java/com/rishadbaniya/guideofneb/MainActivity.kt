package com.rishadbaniya.guideofneb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBTheme
import com.rishadbaniya.guideofneb.ui.GuideofNEBApp
import com.rishadbaniya.guideofneb.viewmodels.LocalMainViewModel
import com.rishadbaniya.guideofneb.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.time.ExperimentalTime

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

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
    }
}




