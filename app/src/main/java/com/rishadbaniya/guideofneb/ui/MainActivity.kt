package com.rishadbaniya.guideofneb.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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




