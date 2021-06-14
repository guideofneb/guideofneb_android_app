package com.rishadbaniya.guideofneb.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class GuideOfNEBColors(
    background : Color,
    onBackground : Color,
    onBackgroundStrong : Color,
    horizontalDivider : Color,
    keyAvailable : Color = Color(0xFF3DA23A),
    keyToSpend : Color = Color(0xFFA23A39),
    onKey : Color = Color.White,
    statusBar : Color,
    isDark: Boolean
){
    var background by mutableStateOf(background)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set
    var onBackgroundStrong by mutableStateOf(onBackgroundStrong)
        private set
    var isDark by mutableStateOf(isDark)
        private set
    var horizontalDividier by mutableStateOf(horizontalDivider)
        private set
    var statusBar by mutableStateOf(statusBar)
        private set
    var keyAvailaible by mutableStateOf(keyAvailable)
        private set
    var keyToSpend by mutableStateOf(keyToSpend)
        private set
    var onKey by mutableStateOf(onKey)
        private set
    fun update(other : GuideOfNEBColors){
        background = other.background
        onBackground = other.onBackground
        onBackgroundStrong = other.onBackgroundStrong
        isDark = other.isDark
        horizontalDividier = other.horizontalDividier
    }
}

val localGuideOfNEBColors = compositionLocalOf<GuideOfNEBColors>{ error("Sorry! No any GuideOfNEBColors was provided")}

object GuideOfNEBTheme{
    val colors : GuideOfNEBColors
    @Composable
    get() = localGuideOfNEBColors.current
}

private val darkThemeColors = GuideOfNEBColors(
    background = Color(0xFF202125),
    onBackground = Color(0xFF9BA0A6),
    onBackgroundStrong = Color.White,
    horizontalDivider = Color(0xFF3B3B3B),
    statusBar = Color(0xFF202125),
    isDark = true
)

private val lightThemeColors = GuideOfNEBColors(
    background = Color.White,
    onBackground = Color(0xFF5F6267),
    onBackgroundStrong = Color.Black,
    horizontalDivider = Color(0xFFE1E1E1),
    statusBar = Color(0xFFCCCCCC),
    isDark = false
)

@Composable
fun GuideOfNEBTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
){
    val colors = if (isDark) darkThemeColors else lightThemeColors;
    ProvideGuideOfNEBColors(colors = colors) {
        val systemUiController = rememberSystemUiController()
        systemUiController.setStatusBarColor(
            color = GuideOfNEBTheme.colors.statusBar,
            darkIcons = !GuideOfNEBTheme.colors.isDark
        )
        MaterialTheme(
            colors = debugMaterialColors(isDark = isDark),
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }

}

@Composable
fun ProvideGuideOfNEBColors(
    colors : GuideOfNEBColors,
    content: @Composable () -> Unit
){
    val colorPalette = remember { colors };
    colorPalette.update(colors)
    CompositionLocalProvider(localGuideOfNEBColors provides colorPalette, content = content)
}

@Composable
fun debugMaterialColors(
    isDark : Boolean,
    debugColor : Color = Color.Gray
) = Colors(
    primary = debugColor,
    onPrimary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    onSurface = debugColor,
    error = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onError= debugColor,
    isLight= !isDark
)
