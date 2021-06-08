package com.rishadbaniya.guideofneb.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuideOfNEBTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = GuideOfNEBTheme.colors.background) {
                }
            }
        }
    }
}