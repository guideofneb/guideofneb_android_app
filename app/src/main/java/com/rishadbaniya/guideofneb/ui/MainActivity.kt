package com.rishadbaniya.guideofneb.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBTheme
import com.rishadbaniya.guideofneb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_GuideOfNEB_NoActionBar)
        setContent {
            GuideOfNEBTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = GuideOfNEBTheme.colors.background) {
                    GuideofNEBApp()
                }
            }
        }
    }
}




