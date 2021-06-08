package com.rishadbaniya.guideofneb.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

class GuideOfNEBColors(
    background : Color,
    onBackground : Color,
){
    var background by mutableStateOf(background)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set
    fun update(other : GuideOfNEBColors){
        background = other.background
        onBackground = other.onBackground
    }
}

val localGuideOfNEBColors = compositionLocalOf<GuideOfNEBColors>{ error("Sorry! No any GuideOfNEBColors was provided")}

object GuideOfNEBTheme{
    val colors : GuideOfNEBColors
    @Composable
    get() = localGuideOfNEBColors.current
}

private val darkThemeColors = GuideOfNEBColors(
    background = Color.Black,
    onBackground = Color.White
)

private val lightThemeColors = GuideOfNEBColors(
    background = Color.White,
    onBackground = Color.Black
)

@Composable
fun GuideOfNEBTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
){

    val colors = if (isDark) darkThemeColors else lightThemeColors;
    ProvideGuideOfNEBColors(colors = colors) {
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
